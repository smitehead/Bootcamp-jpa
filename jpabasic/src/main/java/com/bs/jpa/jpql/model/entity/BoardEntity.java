package com.bs.jpa.jpql.model.entity;

import java.util.Date;

import com.bs.jpa.model.entity.WebMemberEntity;

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

@Data@NoArgsConstructor@AllArgsConstructor@Builder

@Entity
@Table(name="BOARD")
@SequenceGenerator(name="seqBoardNo" , sequenceName = "SEQ_BOARD_NO", allocationSize = 1)
public class BoardEntity {
	@Id
	@GeneratedValue(generator = "seqBoardNo" , strategy = GenerationType.SEQUENCE)
	@Column(name = "board_no")
	private Long boardNo;
	@Column(name = "board_title")
	private String boardTitle;
	
	@ManyToOne
	@JoinColumn(name = "BOARD_WRITER")
	private WebMemberEntity boardWiter;
	
	
	@Column(name="BOARD_CONTENT")
	private String boardContent;
	
	@Column(name="BOARD_READCOUNT")
	private Integer boardReadCount;
	
	@Column(name="BOARD_ORIGINAL_FILENAME")
	private String boardOriginalFilename;
	
	@Column(name="BOARD_RENAMED_FILENAME")
	private String boardRenamedFilename;
	
	@Column(name="BOARD_DATE")
	private Date boardDate;
	
	public BoardEntity(String boardTitle,String boardContent, Date boardDate) {
		this.boardTitle = boardTitle;
		this.boardContent= boardContent;
		this.boardDate = boardDate;
	}

}
