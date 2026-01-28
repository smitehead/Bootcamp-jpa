package com.bs.jpa.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.bs.jpa.common.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

//걍 엔티티의 이름 테이블 설정 안하면 이게 테이블 이름
@Entity(name="Member_entity")
//테이블에 관련된 설정
@Table(name="MEMBER_ENTITY_BS", 
uniqueConstraints = @UniqueConstraint(name="uq_phone_id",
							columnNames = {"MEMBER_ID","MEMBER_PHONE"}),
indexes = {
		@Index(name="idx_memberid11", columnList="MEMBER_ID,MEMBERNAME")
})
//시퀸스 객체 만들기
//여기 네임은 영속성 컨텍스트에서 가지는 이름
@SequenceGenerator(name="seqMemberNo" , sequenceName="seq_member_no_tw" ,
initialValue = 1 , allocationSize = 1)
public class MemberEntity {
	@Id
	@GeneratedValue(generator="seqMemberNo", strategy = GenerationType.SEQUENCE)
	@Column(name="MEMBER_NO")
	private Long memberNo;
	
	
	@Column(name="MEMBER_ID", nullable=false, unique = true)
	//unique는 이거 중복값이 없어야만 한다
	private String memberId;
	@Column(name="MEMBER_PWD" , length=50)
	private String password;
	
	private String memberName;
	
	@Column(name="MEMBER_GENDER") //이넘 설정해도 제약조건은 가능함
	@Enumerated(EnumType.STRING) //이거 스트링으로 쓰는걸 거의 강추 왜냐
	//int로 했다가 컬럼 변경하면 0,1로 저장된게 꼬여서 ㅈ될수 있음
	private Gender gender;
	
	//columnDefinition은 db에 직접 명령어를 내릴때사용 이름 빼고 작성할 문자 적으면됨
	@Column(name="MEMBER_PHONE" , columnDefinition ="varchar2(20) default '없음' NOT NULL UNIQUE")
	private String phone;
	
	//이건 타입지정
	@Temporal(TemporalType.DATE)
	private LocalDate birthDay;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime accessTime;
	
	@Embedded
	private Address address;
	
	@Transient//db랑은 상관없는 그냥 객체임
	private int count;
	
	


}
