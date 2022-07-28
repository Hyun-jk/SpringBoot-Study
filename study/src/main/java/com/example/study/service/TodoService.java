package com.example.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.study.model.TodoEntity;
import com.example.study.persistence.TodoRepository;


//@Service 내부에는 @Component어노테이션을 포함하고 있다.
//이 클래스는 Component 어노테이션과 비교했을 때 특별한 기능 차이는 없다.
//단지 이 클래스는 스프링 컴포넌트이며 기능적으로 비즈니스 로직을 수행하는 서비스 레이어임을 알려주는 어노테이션이다.
@Service
public class TodoService {
	
	@Autowired
	private TodoRepository repository;
	
	public String testService() {
		// TodoEntity 생성
		TodoEntity entity = TodoEntity.builder().title("My First todo item").build();
		// TodoEntity 저장
		repository.save(entity);
		// TodoEntity 검색
		TodoEntity savedEntity = repository.findById(entity.getId()).get();
		return savedEntity.getTitle();
		
		
		
		
	}
}
