package com.example.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.study.model.TodoEntity;
import com.example.study.persistence.TodoRepository;


//@Service ���ο��� @Component������̼��� �����ϰ� �ִ�.
//�� Ŭ������ Component ������̼ǰ� ������ �� Ư���� ��� ���̴� ����.
//���� �� Ŭ������ ������ ������Ʈ�̸� ��������� ����Ͻ� ������ �����ϴ� ���� ���̾����� �˷��ִ� ������̼��̴�.
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
}
