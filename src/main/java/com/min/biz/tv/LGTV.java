package com.min.biz.tv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// 마치 xml에서 <bean class="com.min.biz.tv.LGTV#0"/> 를 사용한것과 @Component 사용이 같은 역할을 한다.
// 클래스 이름이 변경할때 컴포넌트만 인식하면 되기 때문에 xml을 따로 수정하지 않아도 되는 편리함이 있다.
// 클래스의 이름을 기준으로 첫글자를 소문자로 변경하여 id로 인식한다.
// 만약에 class이름이 복잡할 경우,  @("id이름")을 통해 설정할 수 있다.
// @Component("tv")

// @Component("tv")
public class LGTV implements TV {
	
	@Autowired // 3. Type injection이라고 부른다.
//	@Qualifier("sonySpeaker") 
	private Speaker speaker;
	
	
	
//	public LGTV(SonySpeaker speaker) {
//		super();
//		this.speaker = speaker;
//	}

// 1. constructor injection : 생성자 인젝션

//	public void setSpeaker(SonySpeaker speaker) {
//		this.speaker = speaker;
//	}
// 2. setter injection 	
// 생성자 인젝션이나 setter injection을 사용하려면 xml설정파일을 수정할 필요가 있다.
// 생성자 인젝션은 xml설정에서 Constructor-args 태그를 사용하고 setter 인젝션을 사용하려면 property 태그를 사용
	
// @Autowired 변수를 사용해서 생성자 인젝션이나 setter injection을 대신 할 수 있다. 주로 변수 위에 설정하여 객체와 객체를 자동으로 엮어준다.
	

// speaker의 종류가 바뀔때마다 자바소스를 수정하지 않고 의존관계 변경 할 수 있는 방법은 다형성에 있다.
// speaker의 변수 타입을 모든 speaker의 최상인 부모타입인 speaker 인터페이스 타입으로 사용하면 유지보수 과정에서 수정을 하지 않아도 된다.
// 다형성 3가지 : 1. 상속 , 2. 매서드 오버라이딩 , 3. 자식 객체를 할당(auto wired) 묵시적 형변환	
// 컨테이너는 오로지 설정정보(meta data)를 참고하여  동작하기 때문에
// 
	
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
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}

}

// @component 컴포넌트로 된 어노테이션으로 설정한 클래스를 context:component-scan 태그를 사용해서 발견하고 사용할수있다.
// 컴포넌트 어노테이션을 이용해 객체를 사용할때는 default 생성자만 사용하기 때문에  멤버변수는 초기화가 되서 null point 에러가 난다.
// 이때 alt + shift + s 단축키를 생성자 (constructor)를 추가하거나 , generate getter setter를 사용해서 setter 매서드를 사용한다.
