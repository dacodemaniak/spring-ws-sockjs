package com.aelion.sockets.configs;

import java.net.URI;
import java.util.Objects;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	private URI allowOrigin;
	
	@Inject // constructor injection not working in this class, use setter injection instead
	public void setAllowOrigin(  @Value( "${allowOrigin}" ) final URI allowOrigin ) {
	    this.allowOrigin = Objects.requireNonNull( allowOrigin );
	}
	
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry
        	.addEndpoint("/stomp")
        	.setAllowedOrigins("*")
        	.withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }
}
