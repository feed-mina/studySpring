package com.min.biz.tv;

import java.util.Collection;
import java.util.Properties;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		// 1. ������ �����̳ʸ� �����Ѵ�.
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. ����� ��ü�� Lookup �Ѵ�.
		CollectionBean bean = (CollectionBean) container.getBean("collection");
		
		// dependency Lookup���� ȹ��, getBean ���´� String �� �Ű������� �ް� return type�� Object�� �޴´�. : ����� ����ȯ�� �ʿ��ϴ�.
		
		// 3. Lookup�� ��ü�� ����Ѵ�.
		
		Properties data = bean.getAddressList();
		Collection<Object> addressList = data.values();
		// List<String> addressList = bean.getAddressList();
		// String[] addressList = bean.getAddressList();
		System.out.println("[ �ּ� ���]");
		// for (String address : addressList) {
		for (Object address : addressList) {
			System.out.println("====> " + address.toString());
		}
		
		// 4. ������ �����̳ʸ� �����Ѵ�.
		container.close();
		

	}

}
