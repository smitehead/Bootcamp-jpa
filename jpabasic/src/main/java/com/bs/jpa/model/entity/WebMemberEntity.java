package com.bs.jpa.model.entity;

import java.sql.Date;
import java.util.List;

import com.bs.jpa.jpql.model.entity.BoardEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


@Entity(name="member")
@Table(name="MEMBER")
public class WebMemberEntity {
	@Id
private String userId;
	
	private String password;
	private String userName;
	private String gender;
	private Integer age;
	private String email;
	private String phone;
	private String address;
	private String hobby;
	@Temporal(TemporalType.DATE)
	private Date enrollDate;
	@ToString.Exclude
	@OneToMany(mappedBy = "boardWriter")
	private List<BoardEntity> boards;
}
