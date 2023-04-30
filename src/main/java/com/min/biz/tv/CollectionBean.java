package com.min.biz.tv;

import java.util.Properties;

public class CollectionBean {
	
	
	private Properties addressList;
	// private List<String> addressList;
	// private String[] addressList ;

	public Properties getAddressList() {
		return addressList;
	}

	public void setAddressList(Properties addressList) {
		this.addressList = addressList;
	}
	
}

// setter 인젝션을 통해서 배열 객체를 초기화한다. setter매서드를 사용하려면 문자열 배열 객체가 인자로 전달되야만 한다. xml 파일에서 property > list > value를 지정한다. 
// xml 상에서 데이터를 수정한다. 






// 새로운 주소가 추가되거나 기존의 주소가 수정, 삭제될때마다 매번 그때마다 소스를 수정하고 컴파일을 해야만이 시스템에 반영 될 수 있다.
// 여러가지 컬렉션을 사용하고 컬렉션을 자바소스로 직접 수정하게 되면 그럴때마다 컴파일을 다시 해야 하는데 이 부분을 Collection injection을 통해 해결 할 수 있다.
// 배열은 객체를 생성할때 크기가 고정된다. array out of bounds 에러 그래서 배열을 다시 생성해야 한다. 이 부분을 List로 해결할 수 있다.
// List와 Set의 차이는 List의 순서와 중복을 가능하게 한다. Set은 순서를 보장하지 않고 unique한 데이터만 유지하려고 한다.
// Map은 키-벨류 쌍으로 객체나 데이터를 저장할때 사용한다.
// Properties 는 property파일에서 키 = 벨류의 property file의 property를 관리하고 사용한다.