package com.bs.jpa.model.entity.workshop;

import java.util.ArrayList;
import java.util.List;

import com.bs.jpa.common.Gender;
import com.bs.jpa.model.entity.manytomany.CartEntity;
import com.bs.jpa.model.entity.manytomany.ProductEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "STUDENT1_TW")
@SequenceGenerator(name = "seqst", sequenceName = "seq_stno_tw", allocationSize = 1, initialValue = 1)
public class Student1 {
	@GeneratedValue(generator = "seqst", strategy =GenerationType.SEQUENCE)
	@Id
	private Long studentNo;
	
	private String studentName;
	private Integer grade;
	private Integer	classNum;
	private Integer numberSt;
	@Enumerated(EnumType.ORDINAL)
	private Gender gender;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "student")
	private List<Buket> lesson = new ArrayList<>();
	
}
