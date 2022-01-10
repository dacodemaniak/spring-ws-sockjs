package com.aelion.sockets.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.aelion.sockets.models.ChatMessage;

@Controller
public class ChatController {
    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
    	
    	headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
    	
        return chatMessage;
    }

    @MessageMapping("/chat.hello")
    @SendTo("/topic/public")
    public ChatMessage sayHello(@Payload ChatMessage[] chatMessage) {
    	ChatMessage message = new ChatMessage();
    	message.setSender(chatMessage[0].getSender());
    	message.setContent("Hi all");
    	message.setType(chatMessage[0].getType());
    	
        return message;
    }
    
    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }
}
