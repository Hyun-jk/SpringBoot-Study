package com.example.study.controller;

import com.example.study.dto.ResponseDTO;
import com.example.study.dto.TestRequestBodyDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


//@RestController 어노테이션을 이용해 이 컨트롤러가 RestController임을 명시한다.
//@RestController를 이용하면 http와 관련된 코드 및 요청/응답 매핑을 스프링이 알아서 해준다.

@RestController
@RequestMapping("test") //리소스, URL경로를 매핑
public class TestController {
	
	@GetMapping //Http 메서드를 매핑
	public String testController() {
		return "Hello World!";
	}

	@GetMapping("/testGetMapping")
	public String testControllerWithPath() {
		return "Hello World! test GetMapping ";
	}
	
	// url = test/123
	@GetMapping("/{id}") //매개변수/{id}는 경로로 들어오는 임의의 숫자 또는 문자를 변수 id에 매핑하라는 뜻
	public String testControllerWithParthVariables(@PathVariable(required=false)int id) {
		return "Hello World! ID" + id;
	}
	
	// url = /testRequestParam?id=123
	@GetMapping("/testRequestParam")
	public String testControllerRequestParam(@RequestParam(required = false) int id) {
		return "Hello World! ID" + id;
	}
	
	//@RequestBody >>>보통 반환하고자 하는 리소스가 복잘할 때 사용한다.
	//String, int 같은 기본 자료형이 아니라 오브젝트처럼 복잡한 자료형을 통째로 요청에 보내고 싶은 경우가 이에 해당된다.
	@PostMapping("/testRequestBody")
	public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
		return "Hello World! ID " + testRequestBodyDTO.getId() + "Message :" + testRequestBodyDTO.getMessage();
	}
	
	//@RestController의 내부는 크게 두 어노테이션의 조합으로 이루어짐
	/* @Controller 와 @ResponseBody
	 * @Controller -> @Component로 스프링이 이 클래스의 오브젝트를 알아서 생성하고, 다른 오브젝트들과의 의존성을 연결
	 * @ResponseBody -> 이 클래스의 메서드가 리턴하는 것은 웹 서비스의 ResponseBody라는 뜻이다.
	 				 -> 다시 말해 메서드가 리턴할 때 스프링은 리턴된 오브젝트를 JSON의 형태로 바꾸고 HttpResponse에 담아서 반환한다는 뜻
	 */	
	
	@PostMapping("/testResponseBody") //ResponseDTO를 리턴하는 컨트롤러
	public ResponseDTO<String> testControllerResponseBody(){
		List<String> list = new ArrayList<>();
		list.add("Hello World! I'm ResponseDTO");
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build(); //ResponseDTO에 데이터 추가
		return response; 
		
	}
	//ResponseEntity는 HTTP 응답의 바디뿐만 아니라 여러 다른 매개변수들, ex)status나 header를 조작하고 싶을 때 사용됨
	@PostMapping("/testResponseEntity")
	public ResponseEntity<?> testControllerResponseEntity(){
		List<String> list = new ArrayList<>();
		list.add("Hello World! I'm ResponseEntity.And you got 400!");
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		//http status를 400dmfh tjfwjd
		return ResponseEntity.badRequest().body(response); 
		//정상적인 응답을 반환하려고 하면
		//return ResponseEntity.ok().body(response);
	}
	
}



















