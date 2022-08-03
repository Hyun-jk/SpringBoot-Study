package com.example.study.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.study.model.TodoEntity;
import com.example.study.persistence.TodoRepository;

import lombok.extern.slf4j.Slf4j;



//@Service 내부에는 @Component어노테이션을 포함하고 있다.
//이 클래스는 Component 어노테이션과 비교했을 때 특별한 기능 차이는 없다.
//단지 이 클래스는 스프링 컴포넌트이며 기능적으로 비즈니스 로직을 수행하는 서비스 레이어임을 알려주는 어노테이션이다.
@Slf4j //로그 라이브러리
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
	
	public List<TodoEntity> create(final TodoEntity entity){
		//Vallidations : 넘어온 엔티티가 유효한지 검사하는 로직, 코드가 더 커지면 TodoValidator.java로 분리 가능
		validate(entity);
		
		repository.save(entity);
		
		log.info("Entity Id: {} is saved.", entity.getId());
		
		return repository.findByUserId(entity.getUserId());
	
	}
	
	public List<TodoEntity> retrieve(final String userId){
		return repository.findByUserId(userId);
	}
	
	
	public List<TodoEntity> update(final TodoEntity entity){
		//1. w저장할 엔티티가 유효한지 확인한다.
		validate(entity);
		
		//2.넘겨받은 엔티티 id를 이용해 TodoEntity를 가져온다. 존재하지 않은 엔티티는 업데이트 할 수 없기 때문이다.
		final Optional<TodoEntity> original = repository.findById(entity.getId());
		
		if(original.isPresent()) {
			//3.반환된 TodoEntity가 존재하면 값을 새 entity 값으로 덮어 씌운다.
			final TodoEntity todo = original.get();
			todo.setTitle(entity.getTitle());
			todo.setDone(entity.isDone());
			
			//4.데이터베이스에 새 값을 저장한다.
			repository.save(todo);
		}
		
		//사용자의 모든 Todo 리스트를 리턴한다.
		return retrieve(entity.getUserId());
		
	}
	
	public List<TodoEntity> delete(final TodoEntity entity){
		//1.저장할 엔티티가 유효한지 확인한다.
		validate(entity);
		
		try {
			//2 엔티티를 삭제한다.
			repository.delete(entity);
						
		}catch(Exception e) {
			//3.exceptino 발생 시 id와 exception을 로깅한다.
			log.error("error deleting entity", entity.getId(), e);
			
			//4.컨트롤러 exception을 보낸다. 데이버테이스 내부 로직을 캡슐화하려면 e를 리턴하지 않고 새 exception 오브젝트를 리턴한다.
			throw new RuntimeException("error deleting entity" + entity.getId());
		}
		//5. 새 Todo 리스트를 가져와 리턴한다.
		return retrieve(entity.getUserId());
		
	}
	
	
	
	//리팩토리한 메서드
	private void validate(final TodoEntity entity) {
		if(entity == null) {
			log.warn("Entity cannot be null.");
			throw new RuntimeException("Entity cannot be null");
		}
		
		if(entity.getUserId() == null) {
				log.warn("Unknown user.");
				throw new RuntimeException("Unknown user.");
		}
		
	}
	
	


}
