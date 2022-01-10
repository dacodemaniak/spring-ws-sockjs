package com.aelion.sockets.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChatMessage implements Serializable {

	private static final long serialVersionUID = -5809487997380989279L;
	
	@JsonProperty("content")
	private String content;
	
	@JsonProperty("sender")
	private String sender;
	
	@JsonProperty("type")
	private MessageType type;
	
	public enum MessageType {CHAT, LEAVE, JOIN}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}
	
}
