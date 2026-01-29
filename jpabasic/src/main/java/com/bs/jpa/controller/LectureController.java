package com.bs.jpa.controller;

import java.util.List;

import com.bs.jpa.model.entity.BasicEntity;
import com.bs.jpa.model.entity.onetomany.Lecture;
import com.bs.jpa.model.entity.onetomany.Student;
import com.bs.jpa.model.entity.onetomany.StudentBS;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class LectureController {
	public void LectureInsert(EntityManager em) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		Lecture lt = Lecture.builder()
				.lectureName("바나나학")
				.lectureRoom("바나나재배실")
				.lectureClass("바나나재배술")
				.build();
		
		Lecture lt2 = Lecture.builder()
				.lectureName("바나나1학")
				.lectureRoom("바나나재배실2")
				.lectureClass("바나나재배술3")
				.build();
		em.persist(lt);
		em.persist(lt2);
		Student st = Student.builder()
				.studentName("나나")
				.age(2)
				.address("캔디왕국")
				.grade(1)
				.build();
		
		Student st1 = Student.builder()
				.studentName("바나")
				.age(1)
				.address("캔디왕국")
				.grade(1)
				.build();
		
		Student st2 = Student.builder()
				.studentName("나바")
				.age(1)
				.address("캔디왕국")
				.grade(1)
				.build();		

		Student st3 = Student.builder()
				.studentName("바바")
				.age(1)
				.address("캔디왕국")
				.grade(1)
				.build();
		
		st.setLt(lt);
		st3.setLt(lt);
		st1.setLt(lt2);
		st2.setLt(lt2);

		em.persist(st1);
		em.persist(st);
		em.persist(st2);
		em.persist(st3);
		
		et.commit();
	}
	public void selectTest(EntityManager em) {
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		String sql="SELECT s FROM Student s ";
		Query query = em.createQuery(sql);
		
		List<Student> all = query.getResultList();
		
		all.forEach(System.out::println);
		
	}
	public void removeTest(EntityManager em, Long num) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		Student st = em.find(Student.class, num);
		em.remove(st);
		et.commit();
	}
	
	
	
}
