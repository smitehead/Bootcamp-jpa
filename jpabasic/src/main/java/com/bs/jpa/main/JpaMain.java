package com.bs.jpa.main;

import com.bs.jpa.common.JPATemplate;
import com.bs.jpa.controller.BasicController;
import com.bs.jpa.model.entity.BasicEntity;

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
		
		BasicController bc = new BasicController();
//		bc.basicEntityUse(em); 
		
//		bc.basicTest3(em);
//		bc.delete(em);

//		bc.insert(em);
//		System.out.println(bc);
//		bc.update(em, 1L);
//		System.out.println(bc);
//		bc.delete(em, 20L);
		bc.select(em);
		
	}
}
