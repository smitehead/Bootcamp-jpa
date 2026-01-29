package com.bs.jpa.jpql.controller;

import java.util.List;

import com.bs.jpa.jpql.model.entity.BoardEntity;
import com.bs.jpa.model.entity.WebMemberEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class JPQLController {
	public void baiscJPQLTest(EntityManager em) {
		//JPQL 이용하기
		//SELECT문 이용하기
		//1. SELECT문의 대소문자를 구분함 ->예약어는 예외(select , from, as)
		//2. 설정한 엔티티명으로 조회(테이블명 아님)
		//		@Entity(name="엔티티명") / 설정안하면 클래스명이 Entity명이 된다
		//3. from 뒤에 엔티티명을 작성하고 별칭을 부여
		BoardEntity b=em.find(BoardEntity.class, 2);
		String sql="SELECT b FROM BoardEntity b";
		//createQuery()메소ㅗ드를 이용해서 쿼리 실행객체를 생성
		//반환형은 Query/typedQuery 두 객체로 반환
		//Query : 타입이 정해지지 않았을때 사용하는 객체
		//TypeedQuery : 타입을 설정했을때 사용하는 객체
		Query query = em.createQuery(sql);
		TypedQuery<BoardEntity> tquery = em.createQuery(sql,BoardEntity.class);
//		List<Object> result = query.getResultList();
//		result.forEach(System.out::println);
		
		
		// 1. JPQL 문장 정의
		// 엔티티 전체(m)가 아니라 m.boardTitle 등 특정 속성만 나열했습니다.
		// 이렇게 조회하면 반환 타입은 엔티티가 아니라 '데이터 덩어리'가 됩니다.
		sql="""
				select m.boardTitle,m.boardContent,m.boardDate
				from BoardEntity m
				""";
		
		// 2. 쿼리 객체 생성
		// em.createQuery(sql)은 실행할 준비가 된 쿼리 객체를 반환합니다.
		// 이때 조회 항목이 여러 개(Title, Content, Date)이므로 결과는 배열 형태가 됩니다.
		query=em.createQuery(sql);
		
		// 3. 결과 리스트 받아오기
		// 여러 필드를 조회했기 때문에 한 행(Row)은 Object[] 배열에 담깁니다.
		// 즉, List 안에는 [ "제목1", "내용1", "날짜1" ], [ "제목2", "내용2", "날짜2" ] 식의 배열들이 들어있습니다.
		List<Object[]> result2=query.getResultList();
		
		// 4. 반복문을 통한 출력
		// result2는 배열의 리스트이므로, 요소 하나(arrObj)는 Object[] 타입입니다.
		result2.forEach(arrObj->{
			System.out.println(arrObj[0]+" "+arrObj[1]+" "+arrObj[2]); //이러면 제목 내용 날짜만 나옴
			//이러면 원하는 값만 골라서 출력이가능함
		});
		
		List<BoardEntity> boards=tquery.getResultList();
		boards.forEach(board->{
			System.out.println(board.getBoardTitle()
					+" "+board.getBoardContent());
		});
		// 1. NEW 연산자를 이용한 특정 필드 추출 조회 (Projection)
		// 엔티티 전체가 아니라, 필요한 필드만 골라서 '객체 생성자'에 바로 주입하는 방식입니다.
		sql="""
				select NEW com.bs.jpa.jpql.model.entity.BoardEntity(b.boardTitle,b.boardContent,b.boardDate)
					from BoardEntity b
						""";
		// 2. 쿼리 실행 (TypedQuery)
		// 두 번째 인자로 BoardEntity.class를 전달하여 결과 타입을 미리 지정합니다.
		tquery=em.createQuery(sql,BoardEntity.class);
		// 3. 결과 리스트 반환
		// JPA가 내부적으로 SELECT 된 데이터들을 사용하여 'new BoardEntity(...)'를 호출합니다.
		// 이렇게 만들어진 객체들은 리스트(boards)에 담기게 됩니다.
		boards= tquery.getResultList();
		
		// 4. 결과 확인
		// 리스트에 담긴 BoardEntity 객체들의 정보를 한꺼번에 출력합니다.
		// (클래스에 @ToString이 설정되어 있어야 내용이 예쁘게 출력됩니다.)
		System.out.println(boards);
	}
	
	public void jpqlWhereTest(EntityManager em) {
		//where절 사용하기
		
			  //select 프로젝션 FROM 엔티티명(Entity(name="member" 로설정함) 별칭 WHERE 별칭.필드명=값(리터럴->'')
		String sql="""
				select m from member m where m.userId='admin'
				""";
		TypedQuery<WebMemberEntity> tquery = em.createQuery(sql,WebMemberEntity.class);
		tquery.getResultList().forEach(System.out::println);
		
		//where변수 활용하기
		//나이 조회하기
		int age =100;
		 	  //select 프로젝션 FROM 엔티티명(Entity(name="member" 로설정함) 별칭 WHERE 별칭.필드명=값(리터럴->'')
		sql="""
				SELECT m from member m where m.age >= %d
				""".formatted(age);
		//이걸 쿼리날리기 형식정해서 받기
		tquery=em.createQuery(sql,WebMemberEntity.class);
		//stream으로 받아서 출력
		tquery.getResultStream().forEach(System.out::println);
		
		//변수를 파라미터로 처리하기 인덱스 값으로 설정함
		sql="SELECT m from member m where m.age >= ?1";
		tquery = em.createQuery(sql,WebMemberEntity.class);
		tquery.setParameter(1, age);
		System.out.println(tquery.getResultStream().count());
		
		//KEY값으로 설정
		String userId = "admin";
		//select 프로젝션 FROM 엔티티명(Entity(name="member" 로설정함) 별칭 WHERE 별칭.필드명=:key값
		sql="SELECT m from member m where m.userId=:id";
		tquery = em.createQuery(sql,WebMemberEntity.class);
		tquery.setParameter("id", userId);
		System.out.println(tquery.getResultStream().count());
		
		//다수값 가져오기
		//select 프로젝션 FROM 엔티티명(Entity(name="member" 로설정함) 별칭 WHERE 별칭.필드명=:key값
		sql="SELECT m from member m where m.userId=:id and m.age<=:age";
		tquery = em.createQuery(sql,WebMemberEntity.class);
		tquery.setParameter("id", userId);
		tquery.setParameter("age", age);
		//System.out.println(tquery.getResultStream().count());
		
		//singleResult로 받으면 무조건 하나로 받아서 .get이렇게 바로 사용가능하게 할 수도 있다
		System.out.println(tquery.getSingleResult().getUserId()); 
		
		
		//like사용하기
		String userName = "ba";
		sql="SELECT m from member m where m.userName like '%'||:name||'%'";
		tquery = em.createQuery(sql,WebMemberEntity.class);
		tquery.setParameter("name", userName);

		tquery.getResultStream().forEach(System.out::println);
		

	}
	
	public void groupFunction(EntityManager em) {
		
		//그룹함수
				// count, min, max, avg, sum
				String sql="""
						select count(m), min(m.age),max(m.age),sum(m.age),avg(m.age)
						from member m
						""";

		Query query = em.createQuery(sql);
		List<Object[]> resultArr=query.getResultList();
		resultArr.forEach(e->{
			for(Object o : e) {
				System.out.println(o);
			}
		});
		
		//groupby절 사용하기
				sql="select m.gender,count(m) from member m group by m.gender";
				query=em.createQuery(sql);
				resultArr=query.getResultList();
				resultArr.forEach(e->{
					for(Object o : e) {
						System.out.print(o+" ");
					}
					System.out.println();
				});
				
			}
	
	/*
	 * 1. 전체 계시글 조회
	 * 2.계시글 번호가 10인 게시글 조회
	 * 3.개시글 제목을 기준으로 조회하는 기능 만들기 부분조회하기
	 * 4.게시글 조회 ->제목 ,작성자만
	 * 5.최근 게시글 5개 조회
	 * 6.게시글 읽은수와 제목이 전달된 값으로 조회 읽은 수는 큰값, 제목은 부분일치
	 * 7.회원별 작성한 게시글 수 조회
	 * 8.게시글 평균 읽은 수, 최대 읽은 수 ,최소 읽은 수 조회
	 */
	
}


