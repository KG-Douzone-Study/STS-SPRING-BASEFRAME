package com.rio.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rio.base.dto.TodoDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping("/todo")
@Controller
public class TodoController {
	
	@RequestMapping("/list")
	public void list() {
		log.info("todo list.........");
	}
	
	//@RequestMapping(value = "/register", method = RequestMethod.GET)
	@GetMapping("/register")
	public void register() {
		log.info("GET todo register.......");
	}
	
	@PostMapping("/register")
	public void registerPost(@ModelAttribute TodoDTO todoDTO) {
		log.info("@ModelAttribute POST todo register.....");
		log.info(todoDTO);
	}

}
