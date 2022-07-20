package com.example.study.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder 
@NoArgsConstructor 
@AllArgsConstructor 
@Data	
public class TodoEntity {
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
