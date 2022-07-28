package com.example.study.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.study.model.TodoEntity;
										
@Repository								//테이블에 매핑될 엔터티 클래스, 이 엔티티의 기본 키 타입
public interface TodoRepository extends JpaRepository<TodoEntity,String> {
	
	//더 복잡한 쿼리는@Query 어노테이션을 사용해 지정할 수 있다.
	//?1은 메서드의 매개변수의 순서 위치다.
	@Query("select * FROM Todo t WHERE t.userId = ?1")
	List<TodoEntity> findByUserId(String userId);
	
	//이 메서드를 작성하면 스프링 데이터 JPA가 메서드 이름을 파싱해서
	//Select * FROM TOdoRepository WHERE userID = {userId}와 같은 쿼리를 작성해 실행한다.
	
	
}
