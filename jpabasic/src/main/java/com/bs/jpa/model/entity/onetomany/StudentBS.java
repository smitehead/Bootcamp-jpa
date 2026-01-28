package com.bs.jpa.model.entity.onetomany;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor@Builder

@Entity
@Table(name="STUDENT_TW1")
@SequenceGenerator(name="seqStudentNo",sequenceName = "SEQ_STUDENTNO1", 
	initialValue = 1, allocationSize = 1)

public class StudentBS {
	@Id
	@GeneratedValue(generator="seqStudentNo", strategy=GenerationType.SEQUENCE)
	private Long studentNo;
	@Column(unique = true)
	private String name;
	private Integer age;
	private Integer grade;
	private String address;
	@ManyToOne(cascade=CascadeType.PERSIST,  fetch=FetchType.EAGER) 
	// fetch=FetchType.LAZY 이건 지연로딩을해라
	@JoinColumn(name="lesson_ref",nullable = false)
	private LessonBs lesson;
	
	
	public void setLesson(LessonBs lesson) {
		if(this.lesson!=null && !this.lesson.equals(lesson)) {
			this.lesson.getStudents().remove(this);
		}
		if(lesson.getStudents()==null) {
			lesson.setStudents(new ArrayList<>());
		}
		lesson.getStudents().add(this);
		this.lesson = lesson;
	}
	
}
