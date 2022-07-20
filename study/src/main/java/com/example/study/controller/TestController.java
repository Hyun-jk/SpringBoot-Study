package com.example.study.controller;

import com.example.study.dto.ResponseDTO;
import com.example.study.dto.TestRequestBodyDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


//@RestController ������̼��� �̿��� �� ��Ʈ�ѷ��� RestController���� �����Ѵ�.
//@RestController�� �̿��ϸ� http�� ���õ� �ڵ� �� ��û/���� ������ �������� �˾Ƽ� ���ش�.

@RestController
@RequestMapping("test") //���ҽ�, URL��θ� ����
public class TestController {
	
	@GetMapping //Http �޼��带 ����
	public String testController() {
		return "Hello World!";
	}

	@GetMapping("/testGetMapping")
	public String testControllerWithPath() {
		return "Hello World! test GetMapping ";
	}
	
	// url = test/123
	@GetMapping("/{id}") //�Ű�����/{id}�� ��η� ������ ������ ���� �Ǵ� ���ڸ� ���� id�� �����϶�� ��
	public String testControllerWithParthVariables(@PathVariable(required=false)int id) {
		return "Hello World! ID" + id;
	}
	
	// url = /testRequestParam?id=123
	@GetMapping("/testRequestParam")
	public String testControllerRequestParam(@RequestParam(required = false) int id) {
		return "Hello World! ID" + id;
	}
	
	//@RequestBody >>>���� ��ȯ�ϰ��� �ϴ� ���ҽ��� ������ �� ����Ѵ�.
	//String, int ���� �⺻ �ڷ����� �ƴ϶� ������Ʈó�� ������ �ڷ����� ��°�� ��û�� ������ ���� ��찡 �̿� �ش�ȴ�.
	
	@GetMapping("/testRequestBody")
	public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
		return "Hello World! ID " + testRequestBodyDTO.getId() + "Message" + testRequestBodyDTO.getMessage();
	}

}


















