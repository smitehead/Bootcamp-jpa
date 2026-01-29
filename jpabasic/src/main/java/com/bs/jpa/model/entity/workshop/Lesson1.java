package com.bs.jpa.model.entity.workshop;

import java.util.ArrayList;
import java.util.List;

import com.bs.jpa.common.Gender;

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
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "LESSON1_TW")
@SequenceGenerator(name = "seqln", sequenceName = "seq_lnno_tw", allocationSize = 1, initialValue = 1)
public class Lesson1 {
	@GeneratedValue(generator = "seqst", strategy =GenerationType.SEQUENCE)
	@Id
	private Long lessonNo;
	private String lessonName;
	
	private Integer price;
	@ToString.Exclude
	@OneToMany(mappedBy ="lesson")
	private List<Buket> student = new ArrayList<>();
}
