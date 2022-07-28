package com.example.study.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.study.dto.ResponseDTO;
import com.example.study.service.TodoService;

@RestController
@RequestMapping("todo")
public class TodoController {
	
	//알아서 빈을 찾은 다음 그 빈을 이 인스턴스 멤버 변수에 연결하라는 뜻
	@Autowired
	private TodoService service;
	
	
	@PostMapping("/test")
	public ResponseEntity<?> testTodo(){
		String str = service.testService(); //테스트 서비스 사용
		List<String> list = new ArrayList<>();
		list.add(str);
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		return ResponseEntity.ok().body(response);
	}

}
