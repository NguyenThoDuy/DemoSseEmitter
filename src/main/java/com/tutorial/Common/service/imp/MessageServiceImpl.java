package com.tutorial.Common.service.imp;

import com.tutorial.Common.Utils.AuthUtils;
import com.tutorial.Common.model.MessageEntity;
import com.tutorial.Common.model.User;
import com.tutorial.Common.repository.MessageRepository;
import com.tutorial.Common.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final AuthUtils authUtils;
    @Override
    @Transactional
    public void save(String content) {
        User user = authUtils.getIdLogin();
        MessageEntity messageEntity = MessageEntity.builder().content(content).createAt(new Date()).userId(user.getId()).build();
        messageRepository.save(messageEntity);
    }
}
