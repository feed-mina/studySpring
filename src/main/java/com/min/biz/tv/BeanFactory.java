package com.min.biz.tv;

public class BeanFactory {

	public Object getBean(String id) {
		if(id.equals("samsung")) {
			return new SamsungTV();
		} else if (id.equals("lg")) {
			return new LGTV();
		}else if (id.equals("google")) {
			return new GoogleTV();
		}
		return null;
	}
}
