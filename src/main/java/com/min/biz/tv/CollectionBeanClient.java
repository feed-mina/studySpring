package com.min.biz.tv;

import java.util.Collection;
import java.util.Properties;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		// 1. 스프링 컨테이너를 구동한다.
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. 사용할 개체를 Lookup 한다.
		CollectionBean bean = (CollectionBean) container.getBean("collection");
		
		// dependency Lookup으로 획득, getBean 형태는 String 을 매개변수로 받고 return type은 Object를 받는다. : 명시적 형변환이 필요하다.
		
		// 3. Lookup한 객체를 사용한다.
		
		Properties data = bean.getAddressList();
		Collection<Object> addressList = data.values();
		// List<String> addressList = bean.getAddressList();
		// String[] addressList = bean.getAddressList();
		System.out.println("[ 주소 목록]");
		// for (String address : addressList) {
		for (Object address : addressList) {
			System.out.println("====> " + address.toString());
		}
		
		// 4. 스프링 컨테이너를 종료한다.
		container.close();
		

	}

}
