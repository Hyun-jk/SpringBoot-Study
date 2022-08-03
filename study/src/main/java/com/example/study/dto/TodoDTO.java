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
	
	//Http응답을 반환할 때 비즈니스 로직을 캡슈활하거나 추가적인 정보를 함께 반환하려고 DTO를 사용한다고 하였다.
	//컨트롤러는 사용자에게서 TodoDTO를 요청 바디로 넘겨받고 이를 TodoENtity로 변환해 저장해야한다.
	public static TodoEntity toEntity(final TodoDTO dto) {
		return TodoEntity.builder()
						 .id(dto.getId())
						 .title(dto.getTitle())
						 .done(dto.isDone()).build();
	}

	
}
