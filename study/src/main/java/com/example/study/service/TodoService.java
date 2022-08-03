package com.example.study.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.study.model.TodoEntity;
import com.example.study.persistence.TodoRepository;

import lombok.extern.slf4j.Slf4j;



//@Service ���ο��� @Component������̼��� �����ϰ� �ִ�.
//�� Ŭ������ Component ������̼ǰ� ������ �� Ư���� ��� ���̴� ����.
//���� �� Ŭ������ ������ ������Ʈ�̸� ��������� ����Ͻ� ������ �����ϴ� ���� ���̾����� �˷��ִ� ������̼��̴�.
@Slf4j //�α� ���̺귯��
@Service
public class TodoService {
	
	@Autowired
	private TodoRepository repository;
	
	public String testService() {
		// TodoEntity ����
		TodoEntity entity = TodoEntity.builder().title("My First todo item").build();
		// TodoEntity ����
		repository.save(entity);
		// TodoEntity �˻�
		TodoEntity savedEntity = repository.findById(entity.getId()).get();
		return savedEntity.getTitle();
		
	}
	
	public List<TodoEntity> create(final TodoEntity entity){
		//Vallidations : �Ѿ�� ��ƼƼ�� ��ȿ���� �˻��ϴ� ����, �ڵ尡 �� Ŀ���� TodoValidator.java�� �и� ����
		validate(entity);
		
		repository.save(entity);
		
		log.info("Entity Id: {} is saved.", entity.getId());
		
		return repository.findByUserId(entity.getUserId());
	
	}
	
	public List<TodoEntity> retrieve(final String userId){
		return repository.findByUserId(userId);
	}
	
	
	public List<TodoEntity> update(final TodoEntity entity){
		//1. w������ ��ƼƼ�� ��ȿ���� Ȯ���Ѵ�.
		validate(entity);
		
		//2.�Ѱܹ��� ��ƼƼ id�� �̿��� TodoEntity�� �����´�. �������� ���� ��ƼƼ�� ������Ʈ �� �� ���� �����̴�.
		final Optional<TodoEntity> original = repository.findById(entity.getId());
		
		if(original.isPresent()) {
			//3.��ȯ�� TodoEntity�� �����ϸ� ���� �� entity ������ ���� �����.
			final TodoEntity todo = original.get();
			todo.setTitle(entity.getTitle());
			todo.setDone(entity.isDone());
			
			//4.�����ͺ��̽��� �� ���� �����Ѵ�.
			repository.save(todo);
		}
		
		//������� ��� Todo ����Ʈ�� �����Ѵ�.
		return retrieve(entity.getUserId());
		
	}
	
	public List<TodoEntity> delete(final TodoEntity entity){
		//1.������ ��ƼƼ�� ��ȿ���� Ȯ���Ѵ�.
		validate(entity);
		
		try {
			//2 ��ƼƼ�� �����Ѵ�.
			repository.delete(entity);
						
		}catch(Exception e) {
			//3.exceptino �߻� �� id�� exception�� �α��Ѵ�.
			log.error("error deleting entity", entity.getId(), e);
			
			//4.��Ʈ�ѷ� exception�� ������. ���̹����̽� ���� ������ ĸ��ȭ�Ϸ��� e�� �������� �ʰ� �� exception ������Ʈ�� �����Ѵ�.
			throw new RuntimeException("error deleting entity" + entity.getId());
		}
		//5. �� Todo ����Ʈ�� ������ �����Ѵ�.
		return retrieve(entity.getUserId());
		
	}
	
	
	
	//�����丮�� �޼���
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
