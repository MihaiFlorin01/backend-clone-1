package com.example.backendclone1.schedule;

import com.example.backendclone1.controller.CloneController;
import com.example.backendclone1.model.Clone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class StatusScheduler {
    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    CloneController cloneController;

    @Scheduled(fixedRate = 2000)
    public void publishStatus(){
        template.convertAndSend("/topic/greetings", cloneController.getAll().get(0).isActive());
    }
}
