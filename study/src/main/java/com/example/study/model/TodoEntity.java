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
@Entity //�ڹ� Ŭ������ ����Ƽ�� �����Ϸ���@Entity ������̼� ���, ����Ƽ�� �̸��� �ο��ϰ� ������@Entity("TodoEntity")ó�� �Ű����� ��밡��
@Table(name = "Todo") //���̺� �̸��� ����, �� ����Ƽ�� �����ͺ��̽� Todo ���̺� ������ �ȴٴ� �ǹ��̴�.
					  //@Table�� �߰����� �ʰų�, �߰��ص� name�� ������� ������ @Entity�� �̸��� ���̺� �̸����� �����Ѵ�.
					  //@Entity�� �̸��� �������� �ʴ� ��� Ŭ������ �̸��� ���̺� �̸����� �����Ѵ�.
public class TodoEntity {
	@Id //�⺻ Ű�� �� �ʵ忡 ����
	@GeneratedValue(generator = "system-uuid") //ID�� �ڵ����� �����ϰڴٴ� �ǹ�, system-uuid��� generator�� ����Ѵٴ� �ǹ�
	@GenericGenerator(name="system-uuid",strategy ="uuid") //system-uuid�� @GenericGenerator�� ���ǵ� generator�� �̸�����
														   //Hibernate�� �����ϴ� �⺻ Generator�� �ƴ϶� ������ Generator�� ����ϰ� ���� ��� �̿�
	private String id; //�� ������Ʈ�� ���̵�
	private String userId; //�� ������Ʈ�� ������ ������� ���̵�
	private String title; //Todo Ÿ��Ʋ(��:��ϱ�)
	private boolean done;	//true = todo�� �Ϸ��� ���(checked)
}


/*
 @Builder������̼��� ����ϸ� Builder Ŭ������ ���� �������� �ʰ� Builder ������ ����� ������Ʈ�� ������ �� �ִ�.
 TodoEntity todo = TodoEntity.builder
 				   ().id("t-10328373)
 				   .userId("developer")
 				   .title("Implement Model")
 				   .build();
 */


 /*
 @NoArgsConstructor ������̼��� ����ϸ� �Ű������� ���� �����ڸ� �������ش�
 public TodoEntity(){
 }
 */
  

 /*
 @AllArgsConstrcutor ������̼��� Ŭ������ ��� ��� ������ �Ű������� �޴� �����ڸ� �������ش�.
 
 public TodoEntity(String id,String userId, String title, boolean done){
 	super();
 	this.id = id;
 	this.userId = userId;
 	this.title = title;
 	this.done = done;
 }
 */
 

 /*
 @Data ������̼��� Ŭ���� ��� ������ Getter/Setter �޼��带 �������ش�.
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
