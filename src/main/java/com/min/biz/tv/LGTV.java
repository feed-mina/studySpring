package com.min.biz.tv;

import org.springframework.stereotype.Component;

// 마치 xml에서 <bean class="com.min.biz.tv.LGTV#0"/> 를 사용한것과 @Component 사용이 같은 역할을 한다.
// 클래스 이름이 변경할때 컴포넌트만 인식하면 되기 때문에 xml을 따로 수정하지 않아도 되는 편리함이 있다.
// 클래스의 이름을 기준으로 첫글자를 소문자로 변경하여 id로 인식한다.
// 만약에 class이름이 복잡할 경우,  @("id이름")을 통해 설정할 수 있다.
// @Component("tv")

@Component("tv")
public class LGTV implements TV {
	public LGTV() {
		System.out.println("=====>LGTV생성");
	}
	public void powerOn() {
		System.out.println("LGTV 전원 키다.");
	}
	public void powerOff() {
		System.out.println("LGTV 전원 끄다.");
	}
	public void volumeUp() {
		System.out.println("LGTV 소리 울리다.");
	}
	public void volumeDown() {
		System.out.println("LGTV 소리 내린다.");
	}

}

// @component 컴포넌트로 된 어노테이션으로 설정한 클래스를 context:component-scan 태그를 사용해서 발견하고 사용할수있다.