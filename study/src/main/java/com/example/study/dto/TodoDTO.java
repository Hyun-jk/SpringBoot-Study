package com.example.study.dto;

import com.example.study.model.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//����ڴ� �� Ŭ������ �̿��� Todo �������� ����,����,������ ����
//userID�� ���µ�, ������ ��ť���͸� �̿��� ������ ������ ����
//userID�� ���ø����̼ǰ� �����ͺ��̽����� ����ڸ� �����ϴ� ���� �ĺ��ڷ� ����ϱ� ������ ���� �� �ִٸ� ���ܾ��Ѵ�.


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoDTO {
	private String id;
	private String title;
	private boolean done;
	
	public TodoDTO(final TodoEntity entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.done = entity.isDone();
	}
	
	//Http������ ��ȯ�� �� ����Ͻ� ������ ĸ��Ȱ�ϰų� �߰����� ������ �Բ� ��ȯ�Ϸ��� DTO�� ����Ѵٰ� �Ͽ���.
	//��Ʈ�ѷ��� ����ڿ��Լ� TodoDTO�� ��û �ٵ�� �Ѱܹް� �̸� TodoENtity�� ��ȯ�� �����ؾ��Ѵ�.
	public static TodoEntity toEntity(final TodoDTO dto) {
		return TodoEntity.builder()
						 .id(dto.getId())
						 .title(dto.getTitle())
						 .done(dto.isDone()).build();
	}

	
}
