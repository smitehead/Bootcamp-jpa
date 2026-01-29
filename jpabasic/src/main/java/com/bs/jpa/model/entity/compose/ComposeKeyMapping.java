package com.bs.jpa.model.entity.compose;

import java.io.Serializable;

import lombok.Data;

//이 클래스는 복합키로 설정한 값을 연결해주는 객체
//조건
//1.public 클래스여만 한다!
//2.기본 생성자가 무조건 있어야한다
//3.Serializeable인터페이스를 구현해서 무조건 직렬화 처리(객체를 바이트로 부셔서 전송할때 쓰는것)를 해야한다 
//4.equals, gasCode오버라이딩 되어 있어야만 한다
@Data
public class ComposeKeyMapping implements Serializable{
	
	private static final long serialVersionUID = -4271932831170587854L; //자동으로 나옴
	
	//복합키로 설정할 필드와 이름,타입이 동일해야함
	private Long firstId;
	private Long secondId;
	
}
