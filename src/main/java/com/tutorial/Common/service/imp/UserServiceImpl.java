package com.tutorial.Common.service.imp;

import com.tutorial.Common.model.MessageEntity;
import com.tutorial.Common.model.User;
import com.tutorial.Common.repository.MessageRepository;
import com.tutorial.Common.repository.UserRepository;
import com.tutorial.Common.response.MessageResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    public UserServiceImpl(UserRepository userRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    public List<MessageResponse> getMesage() {
        var messages = messageRepository.getAll();
        List<Integer> usersIds = messages.stream().filter(Objects::nonNull).map(i -> i.getUserId()).collect(Collectors.toList());
        var users = userRepository.findByIdIsIn(usersIds);
        Map<Integer, List<String>> mapMessage = messages
                .stream()
                .collect(Collectors.groupingBy(MessageEntity::getUserId,
                Collectors.mapping(MessageEntity::getContent, Collectors.toList())));

        Map<Integer, List<User>> mapUser = users.stream().collect(Collectors.groupingBy(User::getId));
        List<MessageResponse> messageResponses = new MessageResponse().getResponse(mapMessage, mapUser);
        return messageResponses;
    }
}
