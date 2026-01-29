package com.bs.jpa.controller;

import java.util.List;

import com.bs.jpa.model.entity.WebMemberEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class WebController {
	public void searchMember(EntityManager em, String id) {
		WebMemberEntity m  = em.find(WebMemberEntity.class, id);
		System.out.println(m);
	}
	public void searchMemberAll(EntityManager em) {
		String sql = "SELECT m FROM WebMemberEntity m";
		Query query = em.createQuery(sql);
		List<WebMemberEntity> members = query.getResultList();
		members.forEach(System.out::println);
	}
	
	public void insertMember(EntityManager em, WebMemberEntity m) {
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
	}
	
	public void updateMember(EntityManager em, String id, int age) {
		em.getTransaction().begin();
		WebMemberEntity search = em.find(WebMemberEntity.class, id);
		search.setAge(age);
		em.getTransaction().commit();
	}
}
