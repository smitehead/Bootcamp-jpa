package com.bs.jpa.model.entity.onetomany;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name="STUDENT_TW")
@SequenceGenerator(name="seq_sdno", sequenceName = "sd_sdno", allocationSize = 1, initialValue = 1)
public class Student {
	@Id
	@GeneratedValue(generator = "seq_sdno", strategy = GenerationType.SEQUENCE)
	private Long studentNo;
	@Column(unique = true)
	private String studentName;
	private Integer age;
	private String address;
	private Integer grade;
	
	@ToString.Exclude
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "LECTURENO")
	private Lecture lt;
}
