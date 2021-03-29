package com.example.backendclone1.controller;

import com.example.backendclone1.model.Clone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class WebSocketController {

    @Resource
    private CloneController cloneController;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Clone greeting(Clone clone) throws Exception {
        System.out.println(clone.isActive());
        Thread.sleep(1000); // simulated delay
        return new Clone(clone.isActive());
    }
}
