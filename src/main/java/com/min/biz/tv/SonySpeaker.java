package com.min.biz.tv;

import org.springframework.stereotype.Component;

// @Component 
public class SonySpeaker implements Speaker {
	public SonySpeaker() {
		System.out.println("===> SonySpeaker 按眉 积己");
	}
	public void volumeUp() {
		System.out.println("SonySpeaker 家府 匡府促." );
	}
	public void volumeDown() {
		System.out.println("SonySpeaker 家府 郴赴促.");
	}
	
}
