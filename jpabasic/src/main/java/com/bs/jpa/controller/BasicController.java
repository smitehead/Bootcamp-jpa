package com.bs.jpa.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.bs.jpa.common.Gender;
import com.bs.jpa.model.entity.Address;
import com.bs.jpa.model.entity.BasicEntity;
import com.bs.jpa.model.entity.MemberEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class BasicController {
	public void basicEntityUse(EntityManager em) {
		//트랜젝션을 만들고
		EntityTransaction et = em.getTransaction();
		//트랜젝션 시작
		et.begin();
		
		
		//엔티티로 선언된 클래스를 생성! ->객체화(테이블의 1개 데이터(row))
		//이거 만들기만 했기 때문에 비영속성상태임 -> 영속성으로 만들어야 영속성 컨테이너에 들어감
		BasicEntity b = new BasicEntity();
		b.setBasicNo(3L);
		b.setBasicName("나의 3 바나나 데이터");
		b.setAccount(100);
		System.out.println(b);
		//영속성을 부여안해서 걍 비영속성이라 아무것도 안함
		
		//엔티티매니저를 사용해서 영속으로 바꾸기
//		em.persist(b);//애는 그냥 영속성 상태로만 만들어둠 (지연)
		
		BasicEntity b1 = BasicEntity.builder()
				.basicNo(6L)
				.basicName("4번째 바나나 저장")
				.account(20)
				.banana("banana")
				.build();
		
		em.persist(b1);
		//쿼리문 실행하기
		et.commit(); //애가 지연으로 넣다보니 이렇게 커밋해줘야함
		
		//조회 하기
		//em.find(클래스타입,@id 설정된 필드값)메소드를 이용해 사용함 -> 
		//한개 entity객체(row)만 가져올 수 있음
		BasicEntity search = em.find(BasicEntity.class, 1L);
		System.out.println(search);
		
		search = em.find(BasicEntity.class, 6L);
		System.out.println(search);
		
		
		
	}
	
	public void basicTest2(EntityManager em) {
		BasicEntity be = em.getReference(BasicEntity.class, 1L); //이러면 프록시만있어서 안됨
		//지연로딩 중이라 sql에 쿼리문이 안날라감
		
//		BasicEntity be = em.find(BasicEntity.class, 1L);
		//이걸써서 지연로딩을 해결해서 sql문을 날렸기에 다시 위에 코드가 작동함
		System.out.println(be);
		
		//영속성 컨텍스ㅡㅌ에 등록된 객체 제거
		em.clear();
		//이러면 각각 실행됨
		BasicEntity be2= em.find(BasicEntity.class, 1L);
	}
	
	public void basicTest3(EntityManager em) {
		//트랜젝션 생성
		EntityTransaction et = em.getTransaction();
		//insert객체 생성
		MemberEntity t1 = MemberEntity.builder()
			    .memberId("bana2")
			    .password("bana2")
			    .memberName("nanaba")
			    .gender(Gender.F)
			    .phone("01011114444")
			    .birthDay(LocalDate.of(2001, 3, 21)) 
			    .accessTime(LocalDateTime.now()) 
			    .address(Address.builder()
			                .zipCode("12345")
			                .sido("서울시")
			                .gungu("강남구")
			                .build())
			    .build();
		//트랜젝션 시작
		et.begin();
		//영속화처리
		em.persist(t1);
		et.commit();
		em.clear();
		
		MemberEntity searchMemberEntity = em.find(MemberEntity.class, 1L);
		System.out.println(searchMemberEntity);
	}
	public void delete(EntityManager em, Long num) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		BasicEntity del= em.find(BasicEntity.class, num);
		em.remove(del);
		et.commit();
		
		
	}
	public void insert(EntityManager em) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		BasicEntity bs = BasicEntity.builder()
				.basicName("st")
				.account(123)
				.banana("bana")
				.build();
		
		em.persist(bs);
		et.commit();
	}
	public void select(EntityManager em) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		//SELECT다음에 별칭.필드 | 필드-> *과 같음 FROM 엔티티명 별칭 WHERE 필드명 연산자 값
		String sql="SELECT b FROM BasicEntity b ";
		Query query = em.createQuery(sql);
		
		List<BasicEntity> all = query.getResultList();
		
		all.forEach(System.out::println);
	}
}
