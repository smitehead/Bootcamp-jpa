package com.bs.jpa.model.entity.workshop;

import java.time.LocalDate;

import com.bs.jpa.model.entity.manytomany.CartEntity;
import com.bs.jpa.model.entity.manytomany.CustomerEntity;
import com.bs.jpa.model.entity.manytomany.ProductEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.SequenceGenerators;
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
@IdClass(KeyMappingBK.class)
@Table(name="BUKET_TW")
@SequenceGenerators({
	@SequenceGenerator(name="seq1thbk" ,sequenceName="seq_firstbk",  allocationSize = 1, initialValue = 1),
	@SequenceGenerator(name="seq2thbk" ,sequenceName="seq_secondbk",  allocationSize = 1, initialValue = 1),
	@SequenceGenerator(name="seq3thbk" ,sequenceName="seq_secondbk",  allocationSize = 1, initialValue = 1),
	@SequenceGenerator(name="seq4thbk" ,sequenceName="seq_secondbk",  allocationSize = 1, initialValue = 1)
})
public class Buket {
	@GeneratedValue(generator = "seq1thbk",strategy = GenerationType.SEQUENCE)
	@Id
	private Integer year;
	
	@GeneratedValue(generator = "seq2thbk",strategy = GenerationType.SEQUENCE)
	@Id
	private Integer semester;
	
	@GeneratedValue(generator = "seq3thbk",strategy = GenerationType.SEQUENCE)
	@Id
	@JoinColumn(name="student_ref")
	@ManyToOne
	private Student1 student;
	
	
	@GeneratedValue(generator = "seq4thbk",strategy = GenerationType.SEQUENCE)
	@Id
	@JoinColumn(name="lesson_ref")
	@ManyToOne
	private Lesson1 lesson;

}
