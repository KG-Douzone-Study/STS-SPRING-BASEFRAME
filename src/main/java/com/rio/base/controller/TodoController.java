package com.rio.base.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rio.base.dto.TodoDTO;
import com.rio.base.service.TodoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping("/todo")
@RequiredArgsConstructor
@Controller
public class TodoController {
	
	private final TodoService todoService;
	
	@RequestMapping("/list")
	public void list() {
		log.info("todo list.........");
	}
	
	//@RequestMapping(value = "/register", method = RequestMethod.GET)
	@GetMapping("/register")
	public void register() {
		log.info("GET todo register.......");
	}
	
	@PostMapping("/coreRegister")
	public void registerPost(@ModelAttribute TodoDTO todoDTO) {
		log.info("@ModelAttribute POST todo register.....");
		log.info(todoDTO);
	}
	
	@PostMapping("/register")
	public String registerPost(@Valid TodoDTO todoDTO, 
								BindingResult bindingResult,
								RedirectAttributes redirectAttributes) {
		log.info("POST todo register........");
		
		if(bindingResult.hasErrors()) {
			log.info("has erros........");
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			
			return "redirect:/todo/register";
		}
		
		log.info(todoDTO);
		
		return "redirect:/todo/list";
	}

}
