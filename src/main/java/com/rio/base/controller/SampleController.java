package com.rio.base.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rio.base.dto.TodoDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class SampleController {
	
	@GetMapping("/hello")
	public void hello() {
		log.info("hello.....");
	}
	
	@GetMapping("/ex1")
	public void ex1(String name, int age) {
		log.info("ex1.........");
		log.info("name : " + name);
		log.info("age : " + age);
	}
	
	@GetMapping("/ex2")
	public void ex2(@RequestParam(name = "name", defaultValue = "AAA") String name,
					@RequestParam(name = "age", defaultValue = "20") int age ) {
		
		log.info("ex2......");
		log.info("name : " + name);
		log.info("age : " + age);
	}
	
	@GetMapping("/ex3")
	public void ex3(LocalDate dueDate) {
		log.info("ex3........");
		log.info("dueDate : " + dueDate);
	}
	
	// @Controller 어노테이션이 붙은 클래스는 기본적으로 return으로 이동할 페이지를 알려주어야 한다.
	// 이동할 페이지가 없다면 @GetMapping("/ex4")를 보고 ex4.jsp 를 찾게 된다.
	@GetMapping("/ex4")
	public void ex4(Model model) {
		log.info("-----------------------");
		
		model.addAttribute("message", "Hello World");
	}
	
	@GetMapping("/ex4_1")
	public void ex4Extra(@ModelAttribute("dto") TodoDTO todoDTO, Model model) {
		log.info(todoDTO);
	}
	
	//@ModelAttribute를 적지않아도 파라미터에 객체가 있다면 스프링이 자동으로 맞춰준다.
	@GetMapping("/ex4_2")
	public void ex4Extra2(TodoDTO todoDTO, Model model) {
		log.info(todoDTO);
	}
	
	// POST 방식으로 어떤 처리를 하고 Redirect를 해서 GET 방식으로 특정한 페이지로 이동하는 
	// POST - Redirect - GET (PRG) 패턴을 처리하기 위해서 RedirectAttribute라는 특별한 타입을 제공
	/**
	 * - addAttribute(key, value) : 리다이렉트할 때 쿼리 스트링이 되는 값을 지정
	 * - addFlashAttribute(key, value) : 일회용으로만 데이터를 전달하고 삭제되는 값을 지정
	 */
	@GetMapping("/ex5")
	public String ex5(RedirectAttributes redirectAttributes) {
		
		redirectAttributes.addAttribute("name", "ABC");
		redirectAttributes.addFlashAttribute("result", "success");
		
		// 스프링 MVC에서 리다이렉트하기 위해서는 'redirect:' 라는 접두어를 붙여서 문자열로 반환한다.
		return "redirect:/ex6";
		
	}
	
	@GetMapping("/ex6")
	public void ex6() {
		
	}
	
	// @ExceptionHandler @ControllerAdivce example
	// http://localhost:8080/ex7?p1=AAA&p2=BBB 입력
	/**
	 * @warnMessage : WARN [org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver] 
	 * Resolved [org.springframework.web.method.annotation.MethodArgumentTypeMismatchException:
	 * Failed to convert value of type 'java.lang.String' to required type 'int'; 
	 * nested exception is java.lang.NumberFormatException: For input string: "BBB"]
	 */
	@GetMapping("/ex7")
	public void ex7(String p1, int p2) {
		log.info("p1......." + p1);
		log.info("p2......." + p2);
	}

}
