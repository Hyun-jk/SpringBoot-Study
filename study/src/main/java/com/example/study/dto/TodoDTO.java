package com.example.study.dto;

import com.example.study.model.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//사용자는 이 클래스를 이용해 Todo 아이템을 생성,수정,삭제할 예정
//userID가 없는데, 스프링 시큐리터를 이용해 인증을 구현할 예정
//userID는 애플리케이션과 데이터베이스에서 사용자를 구별하는 고유 식별자로 사용하기 때문에 숨길 수 있다면 숨겨야한다.


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
}
