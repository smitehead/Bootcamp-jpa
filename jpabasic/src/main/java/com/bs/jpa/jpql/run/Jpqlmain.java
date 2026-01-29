package com.bs.jpa.jpql.run;

import com.bs.jpa.common.JPATemplate;
import com.bs.jpa.jpql.controller.JPQLController;

import jakarta.persistence.EntityManager;

public class Jpqlmain {
	public static void main(String[] args) {
		EntityManager em = JPATemplate.getWebEntityManagerFactory().createEntityManager();
//		new JPQLController().baiscJPQLTest(em);
		
		new JPQLController().groupFunction(em);
		
		
	}
}
