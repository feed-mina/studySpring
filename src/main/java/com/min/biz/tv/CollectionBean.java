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

// setter �������� ���ؼ� �迭 ��ü�� �ʱ�ȭ�Ѵ�. setter�ż��带 ����Ϸ��� ���ڿ� �迭 ��ü�� ���ڷ� ���޵Ǿ߸� �Ѵ�. xml ���Ͽ��� property > list > value�� �����Ѵ�. 
// xml �󿡼� �����͸� �����Ѵ�. 






// ���ο� �ּҰ� �߰��ǰų� ������ �ּҰ� ����, �����ɶ����� �Ź� �׶����� �ҽ��� �����ϰ� �������� �ؾ߸��� �ý��ۿ� �ݿ� �� �� �ִ�.
// �������� �÷����� ����ϰ� �÷����� �ڹټҽ��� ���� �����ϰ� �Ǹ� �׷������� �������� �ٽ� �ؾ� �ϴµ� �� �κ��� Collection injection�� ���� �ذ� �� �� �ִ�.
// �迭�� ��ü�� �����Ҷ� ũ�Ⱑ �����ȴ�. array out of bounds ���� �׷��� �迭�� �ٽ� �����ؾ� �Ѵ�. �� �κ��� List�� �ذ��� �� �ִ�.
// List�� Set�� ���̴� List�� ������ �ߺ��� �����ϰ� �Ѵ�. Set�� ������ �������� �ʰ� unique�� �����͸� �����Ϸ��� �Ѵ�.
// Map�� Ű-���� ������ ��ü�� �����͸� �����Ҷ� ����Ѵ�.
// Properties �� property���Ͽ��� Ű = ������ property file�� property�� �����ϰ� ����Ѵ�.