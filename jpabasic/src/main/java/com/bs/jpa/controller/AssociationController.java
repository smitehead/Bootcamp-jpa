package com.bs.jpa.controller;

import com.bs.jpa.common.Local;
import com.bs.jpa.model.entity.onetomany.DepartmentEntity;
import com.bs.jpa.model.entity.onetomany.EmployeeEntity;
import com.bs.jpa.model.entity.onetomany.LessonBs;
import com.bs.jpa.model.entity.onetomany.StudentBS;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class AssociationController {
	
	public void oneToManyTest(EntityManager em) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		
//		EmployeeEntity e = EmployeeEntity.builder()
//				.empName("바나나")
//				.empAge("25")
//				.empSalary(1000000000)
//				.empBonus(0.5)
//				.empAddress("바나나시")
//				.build();
//		DepartmentEntity dept = DepartmentEntity.builder()
//				.deptName("전쟁부")
//				.localName(Local.EUROPE)
//				.build();
//		
//		e.setDept(dept);
//		em.persist(dept);
//		em.persist(e);
		
		EmployeeEntity e = em.find(EmployeeEntity.class, 3L);
		DepartmentEntity d = em.find(DepartmentEntity.class, 1L);
		
		System.out.println(e);
		System.out.println(d);
		
		et.commit();
		
	}
	public void oneToManyTest2(EntityManager em) {
		EntityTransaction et =em.getTransaction();
		et.begin();
		EmployeeEntity e = EmployeeEntity.builder() //빌더만듬
				.empName("나나바")
				.empAge("2")
				.empSalary(200000000)
				.empBonus(0.5)
				.empAddress("켄디왕국")
				.build();
		
		DepartmentEntity de = em.find(DepartmentEntity.class, 1L); //이때 db에서 불러옴
		e.setDept(de); //e객체에다가 de객체를 참조해줌
		//de.getEmployees().add(e); //이게 없으면 de객체에는 참조관리를 하지 않은상태
		em.persist(e); //영속성부여를해줌
		
		System.out.println(e.getDept()); //그래서 이건 제대로 나옴 참조를 했기때문
		System.out.println(de.getEmployees()); //add를 안할시 따로 참조를 안했기때문에 옛날 참조안한 객체를 해줌
		et.commit();
	}
	
	public void insertTest(EntityManager em) {
		em.getTransaction().begin();
		StudentBS s=StudentBS.builder()
				.name("김영호")
				.age(25)
				.address("경북 구미")
				.grade(4)
				.build();
		StudentBS s3=StudentBS.builder()
				.name("신동호")
				.age(26)
				.address("경남 창원")
				.grade(5)
				.build();
		StudentBS s1=StudentBS.builder()
				.name("황지한")
				.age(25)
				.address("서울시 강서구")
				.grade(4)
				.build();
		StudentBS s2=StudentBS.builder()
				.name("김태련")
				.age(23)
				.address("서울시 중랑구")
				.grade(4)
				.build();
		
		em.persist(s);
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		
		LessonBs l=LessonBs.builder()
				.lessonTitle("이건 첫번째 레슨")
				.lessonContent("유노윤호의 레슨")
				.location("3강의장")
				.build();
		
		LessonBs l2=LessonBs.builder()
				.lessonTitle("이건 두번째 레슨")
				.lessonContent("유노윤호의 레슨2")
				.location("4강의장")
				.build();
		
		s.setLesson(l);
		s1.setLesson(l);
		s2.setLesson(l);
		s3.setLesson(l2);
		
		em.getTransaction().commit();
		
	}
	
	public void removeStudent(EntityManager em, Long studentNo) {
		em.getTransaction().begin();
		StudentBS s=em.find(StudentBS.class, studentNo);
		em.remove(s);
		em.getTransaction().commit();
	}
	public void removeLesson(EntityManager em, Long lessonNo) {
		em.getTransaction().begin();
		LessonBs l=em.find(LessonBs.class, lessonNo);
		em.remove(l);
		em.getTransaction().commit();
	}
	public void searchData(EntityManager em) {
		StudentBS s = em.find(StudentBS.class, 6L);
//		System.out.println(s);
		System.out.println(s.getName());
//		System.out.println(s.getLesson());
		
		LessonBs l = em.find(LessonBs.class, 12L);
		System.out.println(l);
	}
	

}
