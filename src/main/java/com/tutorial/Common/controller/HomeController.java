package com.tutorial.Common.controller;

import com.tutorial.Common.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequiredArgsConstructor
public class HomeController {
    private final MessageService messageService;
    public List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/sse/subscribe", consumes = MediaType.ALL_VALUE)
    public SseEmitter subscribe() {
        SseEmitter sseEmitter = new SseEmitter();
        try {
            sseEmitter.send(SseEmitter.event().data("INIT"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // onCompletion để xóa SseEmitter khỏi danh sách khi kết nối đã hoàn thành.
        sseEmitter.onCompletion(() -> emitters.remove(sseEmitter));
        emitters.add(sseEmitter);
        return sseEmitter;
    }

    @PostMapping(value = "/sse/dispatch", consumes = MediaType.ALL_VALUE)
    public void dispatchEventToClients(@RequestParam String content) {
        SseEmitter sseEmitter = new SseEmitter();
        String evenFormatted = new JSONObject().put("text", content).toString();
        messageService.save(content);
        for (SseEmitter emitter : emitters) {
            try {
                emitter.send(SseEmitter.event().name("latestNews").data(evenFormatted));
            } catch (Exception ex) {
                emitters.remove(emitter);
            }
        }
    }

}
