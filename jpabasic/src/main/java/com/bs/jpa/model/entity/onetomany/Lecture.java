package com.bs.jpa.model.entity.onetomany;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name="LECTURE_TW")
@SequenceGenerator(name="seq_ltno", sequenceName = "sd_ltno", allocationSize = 1, initialValue = 1)
public class Lecture {
	@Id
	@GeneratedValue(generator = "seq_ltno", strategy =GenerationType.SEQUENCE)
	private Long lectureNo;
	@Column(unique = true)
	private String lectureName;
	private String lectureRoom;
	private String lectureClass;
	
	@Builder.Default
	@OneToMany(mappedBy = "lt", cascade = CascadeType.REMOVE)// cascade를하면 부모 지우면 자식까지 삭제됨
	private List<Student> st =  new ArrayList<>();
	
	
}
