package com.bs.jpa.main;

import com.bs.jpa.common.JPATemplate;
import com.bs.jpa.controller.AssociationController;
import com.bs.jpa.controller.BasicController;
import com.bs.jpa.controller.LectureController;
import com.bs.jpa.controller.WebController;
import com.bs.jpa.model.entity.BasicEntity;
import com.bs.jpa.model.entity.WebMemberEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory factory=JPATemplate.getEntityManagerFactory();
		//영속성 컨텍스트를 관리하는 EntityManager클래스를 생성
		EntityManager em = factory.createEntityManager();
		//트랜젝션을 관리하는 EntityTransaction클래스를 생성
		EntityTransaction et = em.getTransaction();
//		
//		BasicController bc = new BasicController();
//		bc.basicEntityUse(em); 
		
//		bc.basicTest3(em);
//		bc.delete(em);

//		bc.insert(em);
//		System.out.println(bc);
//		bc.update(em, 1L);
//		System.out.println(bc);
//		bc.delete(em, 20L);
//		bc.select(em);
		
//		AssociationController ac = new AssociationController();
//		ac.oneToManyTest(em);
//		ac.oneToManyTest2(em);
//		ac.insertTest(em);
//		ac.removeLesson(em, 8L);
//		ac.searchData(em);
		
	
//		LectureController lc = new LectureController();
//		lc.LectureInsert(em);
//		lc.selectTest(em);
//		lc.removeTest(em, 2L);
		
//		ac.manyToManySearch(em);
		WebController wc = new WebController();
		
		EntityManager webem = JPATemplate.getWebEntityManagerFactory().createEntityManager();
		wc.searchMember(webem, "admin");
		WebMemberEntity m = WebMemberEntity.builder()
				.userId("Bana55")
				.password("1234")
				.userName("babana")
				.age(12)
				.gender("F")
				.email("12@12")
				.phone("01011223344")
				.address("바나나시")
				.hobby("독서,세계정복")
				.build();
		wc.insertMember(webem, m);
		wc.updateMember(webem, "Bana55", 2);
		wc.searchMemberAll(webem);
	}
}
