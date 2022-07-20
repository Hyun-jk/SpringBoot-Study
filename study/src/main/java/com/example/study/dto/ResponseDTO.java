package com.example.study.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//Http응답으로 사용할 DTO이다.

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDTO<T> {
	private String error;
	//이 프로젝트의 경우 Todo를 하나만 반환하는 경우보다 리스트를 반환하기 때문에 데이터를 리스트를 반환하도록 함.
	private List<T> data; 
}
