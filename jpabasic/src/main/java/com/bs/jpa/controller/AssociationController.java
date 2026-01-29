package com.bs.jpa.controller;

import java.time.LocalDate;

import com.bs.jpa.common.Gender;
import com.bs.jpa.model.entity.manytomany.CartEntity;
import com.bs.jpa.model.entity.manytomany.CustomerEntity;
import com.bs.jpa.model.entity.manytomany.ProductEntity;
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
	public void manyTomanyTest(EntityManager em) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		ProductEntity p = ProductEntity.builder()
				.productName("RAM")
				.price(200000)
				.discount(0.2)
				.build();
		ProductEntity p1 = ProductEntity.builder()
				.productName("그래픽카드")
				.price(200000)
				.discount(0.1)
				.build();
		em.persist(p);
		em.persist(p1);
		CustomerEntity c = CustomerEntity.builder()
				.customerName("바나나씨")
				.age(22)
				.gender(Gender.M)
				.address("바나나시")
				.build();
		CustomerEntity c1 = CustomerEntity.builder()
				.customerName("나나씨")
				.age(19)
				.gender(Gender.F)
				.address("캔디왕국")
				.build();
		
		CustomerEntity c2 = CustomerEntity.builder()
				.customerName("나나바씨")
				.age(19)
				.gender(Gender.F)
				.address("캔디왕국")
				.build();
		
		em.persist(c1);
		em.persist(c);
		em.persist(c2);
		
		
//		p.setCustomers(List.of(c,c1,c2));
//		p1.setCustomers(List.of(c,c1));
		System.out.println(c);
		et.commit();
		
		
	}
	public void manyToManySearch(EntityManager em) {
		ProductEntity target = em.find(ProductEntity.class, 27L);
//		CustomerEntity c = target.getCustomers().get(0);
		System.out.println(target);
	}
	
	
	public void manyTomanyTest1(EntityManager em) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		ProductEntity p = em.find(ProductEntity.class, 27L);
		ProductEntity p1 = em.find(ProductEntity.class, 28L);
		
		CustomerEntity c= em.find(CustomerEntity.class, 41L);
		CustomerEntity c1= em.find(CustomerEntity.class, 42L);
		CustomerEntity c2= em.find(CustomerEntity.class, 43L);
		
		CartEntity cart = CartEntity.builder()
				.cartCount(3)
				.products(p)
				.customers(c)
				.cartDate(LocalDate.now())
				.build();
		
		em.persist(cart);
		c.getProducts().add(cart);
		p.getCustomers().add(cart);
		et.commit();
		
	}
	
	

}
