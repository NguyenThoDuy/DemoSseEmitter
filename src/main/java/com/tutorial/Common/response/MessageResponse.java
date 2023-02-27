package com.tutorial.Common.response;

import com.tutorial.Common.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponse {
    private String userName;
    private String image;
    private List<String> message;

    public List<MessageResponse> getResponse(Map<Integer, List<String>> mapMessage, Map<Integer, List<User>> mapUser) {
        List<MessageResponse> responses = new ArrayList<>();
        for (var entry : mapMessage.entrySet()){
            var key = entry.getKey();
            responses.add(new MessageResponse(mapUser.get(key).get(0), mapMessage.get(key)));
        }
        return responses;
    }

    public MessageResponse(User user, List<String> message) {
        this.userName = user.getDisplayName();
        this.image = user.getPicture();
        this.message = message;
    }
}
