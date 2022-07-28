package com.example.study.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder 
@NoArgsConstructor 
@AllArgsConstructor 
@Data
@Entity //자바 클래스를 엔터티로 지정하려면@Entity 어노테이션 사용, 엔터티에 이름을 부여하고 싶으면@Entity("TodoEntity")처럼 매개변수 사용가능
@Table(name = "Todo") //테이블 이름을 지정, 이 엔터티는 데이터베이스 Todo 테이블에 매핑이 된다는 의미이다.
					  //@Table을 추가하지 않거나, 추가해도 name을 명시하지 않으면 @Entity의 이름을 테이블 이름으로 간주한다.
					  //@Entity의 이름을 지정하지 않는 경우 클래스의 이름을 테이블 이름으로 간주한다.
public class TodoEntity {
	@Id //기본 키가 될 필드에 지정
	@GeneratedValue(generator = "system-uuid") //ID를 자동으로 생성하겠다는 의미, system-uuid라는 generator를 사용한다는 의미
	@GenericGenerator(name="system-uuid",strategy ="uuid") //system-uuid는 @GenericGenerator에 정의된 generator의 이름으로
														   //Hibernate가 제공하는 기본 Generator가 아니라 나만의 Generator를 사용하고 싶을 경우 이용
	private String id; //이 오브젝트의 아이디
	private String userId; //이 오브젝트를 생성한 사용자의 아이디
	private String title; //Todo 타이틀(예:운동하기)
	private boolean done;	//true = todo를 완료한 경우(checked)
}


/*
 @Builder어노테이션을 사용하면 Builder 클래스를 따로 개발하지 않고도 Builder 패턴을 사용해 오브젝트를 생성할 수 있다.
 TodoEntity todo = TodoEntity.builder
 				   ().id("t-10328373)
 				   .userId("developer")
 				   .title("Implement Model")
 				   .build();
 */


 /*
 @NoArgsConstructor 어노테이션을 사용하면 매개변수가 없는 생성자를 구현해준다
 public TodoEntity(){
 }
 */
  

 /*
 @AllArgsConstrcutor 어노테이션은 클래스의 모든 멤버 변수를 매개변수로 받는 생성자를 구현해준다.
 
 public TodoEntity(String id,String userId, String title, boolean done){
 	super();
 	this.id = id;
 	this.userId = userId;
 	this.title = title;
 	this.done = done;
 }
 */
 

 /*
 @Data 어노테이션은 클래스 멤버 변수의 Getter/Setter 메서드를 구현해준다.
 public String getId(){
 	return id;
 }
 public void setId(String id){
 	this.id = id;
 }
 public String getUserId(){
 	return userId;
 }
 public String setUserId(String userId){
 	this.userId = userId;
 }
 public String getTitle(){
 	return title;
 }
 public String setTitle(String title){
 	this.title = title;
 }
 public boolean isDone(){
 	return done;
 }
 public void setDone(boolean doen){
 	this.done = done;
 }
 */
