package com.bs.jpa.jpql.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

import com.bs.jpa.jpql.model.entity.BoardEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CriteriaController {
	//jpa에서 공식적으로 제공하는 메소드로 jpql구문을 작성하는 기능 구문 하드코딩은 ㅂㅅ같다고 만들어놓고 ㅈㄴ 어렵게 만듬
	public void basicCriteria(EntityManager em) {
		
		//select * from b;를 만드는법
		
		//1.criteria빌더를 생성
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		//2. 쿼리문 실행 후 반환객체를 설정
		CriteriaQuery<BoardEntity> criteriaQuery = cb.createQuery(BoardEntity.class);
		
		//3. from설정하기
		Root<BoardEntity> board = criteriaQuery.from(BoardEntity.class);
		
		//4. select절 설정하기 
		criteriaQuery.select(board);
		
		//쿼리 실행절
		TypedQuery<BoardEntity> tQeury =em.createQuery(criteriaQuery);
		tQeury.getResultStream().forEach(System.out::println);
		
		
		
		//다시 복습
		CriteriaQuery criteriaQuery2 = cb.createQuery(Object.class);
		
		//from절
		Root<BoardEntity> board2 = criteriaQuery2.from(BoardEntity.class);
		//select절 
		criteriaQuery2.select(board2.get("boardTitle"));
		em.createQuery(criteriaQuery2).getResultStream().forEach(System.out::println);
		
		
		//다수컬럼 지정하기
		//select문 multiselect()를 이용
		//2
		CriteriaQuery criteriaQuery3 = cb.createQuery(Object[].class);
		//3
		Root<BoardEntity> board3 = criteriaQuery3.from(BoardEntity.class);
		//4
		criteriaQuery3.multiselect(board3.get("boardTitle"),board3.get("boardReadCount"));
		//5.출력
		em.createQuery(criteriaQuery3).getResultList().forEach(e->{
			Arrays.stream((Object[])e).forEach(System.out::println);
		});
		
		
		//cb.array()메소드 이용하기
				criteriaQuery3.select(
						cb.array(board3.get("boardTitle"),
								board3.get("boardReadCount"),
								board3.get("boardDate")));
				
				em.createQuery(criteriaQuery3).getResultList()
				.forEach(e->{
					Arrays.stream((Object[])e).forEach(System.out::println);
				});
	
		
		
	}
	//where절 사용
	public void searchkeyword(EntityManager em) {
		//where메소드를 이용
		//where 
		//연산자 : 
		//숫자비교 : greaterThan(),lessThan(),greaterThanOrEqualsTo() 
		//gt(),lt(),ge(),le() 로 사용해도 가능
		//동등비교 : equal, like(), in()
		//논리 :  and(), or() 처럼 전부 메소드화해서 만들어 둠
		//Predicate객체로 저장

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<BoardEntity> criteriaQuery=cb.createQuery(BoardEntity.class);
		Root<BoardEntity> board = criteriaQuery.from(BoardEntity.class);
		
		//where절 생성하기
		//where 비교대상 = 비교할값
		Predicate boardWiter= cb.equal(board.get("boardWriter").get("userId"), "admin");
		criteriaQuery.select(board).where(boardWiter);
		
		em.createQuery(criteriaQuery).getResultList().forEach(System.out::println);
		String name="user";
		//where절 만들기
		Predicate where  = cb.greaterThan(board.get("boardDate"), Date.valueOf(LocalDate.of(2001, 03, 21)));
		Predicate where1 = cb.like(board.get("boardWriter").get("userName")
				,cb.parameter(String.class,"name")); //이러면 string의 name값을 받을꺼야라고 지정
		Predicate and = cb.and(where,where1);//2개를 and로 합치기
		
		
		criteriaQuery.select(board).where(and);
		Query query = em.createQuery(criteriaQuery);//쿼리제작
		query.setParameter("name", '%'+name+'%');  //파라미터를 설정해서 넣어주기
		query.getResultList().forEach(System.out::println);
//		em.createQuery(criteriaQuery).getResultList().forEach(System.out::println);
		
	}
}
