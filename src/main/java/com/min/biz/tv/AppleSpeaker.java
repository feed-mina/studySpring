package com.min.biz.tv;

import org.springframework.stereotype.Component;

// @Component 
public class AppleSpeaker implements Speaker {
	
	// �������� ������, �����ӿ�ũ�� �����ϴµ� �⺻�̿��� �Ѵ�. 
	// �������̽� ��� : Alt + Shift + T Ű > Extract Interface  
	
	public AppleSpeaker() {
		System.out.println("===> AppleSpeaker ��ü ����");
	}
	public void volumeUp() {
		System.out.println("AppleSpeaker �Ҹ� �︮��." );
	}
	public void volumeDown() {
		System.out.println("AppleSpeaker �Ҹ� ������.");
	}
	
}
