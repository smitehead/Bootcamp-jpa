package com.bs.jpa.model.entity.workshop;

import java.io.Serializable;

import com.bs.jpa.model.entity.compose.ComposeKeyMapping;


import lombok.Data;

@Data
public class KeyMappingBK implements Serializable {
	private static final long serialVersionUID = 5067703692884560897L;
	
	private Integer year;
	

	private Integer semester;
	

	private Student1 student;
	

	private Lesson1 lesson;

}
