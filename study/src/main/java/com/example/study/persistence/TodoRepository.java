package com.example.study.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.study.model.TodoEntity;
										
@Repository								//���̺� ���ε� ����Ƽ Ŭ����, �� ��ƼƼ�� �⺻ Ű Ÿ��
public interface TodoRepository extends JpaRepository<TodoEntity,String> {
	
	//�� ������ ������@Query ������̼��� ����� ������ �� �ִ�.
	//?1�� �޼����� �Ű������� ���� ��ġ��.
	@Query("select * FROM Todo t WHERE t.userId = ?1")
	List<TodoEntity> findByUserId(String userId);
	
	//�� �޼��带 �ۼ��ϸ� ������ ������ JPA�� �޼��� �̸��� �Ľ��ؼ�
	//Select * FROM TOdoRepository WHERE userID = {userId}�� ���� ������ �ۼ��� �����Ѵ�.
	
	
}
