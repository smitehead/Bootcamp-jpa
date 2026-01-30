package com.bs.jpa.controller;

import java.util.List;

import com.bs.jpa.jpql.model.entity.BoardEntity;
import com.bs.jpa.jpql.model.entity.QBoardEntity;
import com.bs.jpa.model.entity.QWebMemberEntity;
import com.bs.jpa.model.entity.WebMemberEntity;
import com.querydsl.jpa.impl.JPAQuery;

import jakarta.persistence.EntityManager;



public class QueryDSLController {
	public void basicQueryDsl(EntityManager em) {
		
		QBoardEntity qboard=new QBoardEntity("board");
		
		JPAQuery<BoardEntity> query=new JPAQuery(em);
		//querydsl라이브러리에서 Entity를 기반으로 새로운 객체를 생성
		
		
		List<BoardEntity> boards=query.from(qboard)
			.where(qboard.boardWriter.userId.eq("admin"))
			.fetch();
		
		boards.forEach(System.out::println);
		
		
		
		QWebMemberEntity member=new QWebMemberEntity("member");
		
		JPAQuery<WebMemberEntity> query1 =new JPAQuery(em);
		
		List<WebMemberEntity> members = query1.from(member).fetch();
		
		members.forEach(System.out::println);
	}
}
