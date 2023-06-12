package com.rio.base.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rio.base.dto.TodoDTO;
import com.rio.base.service.TodoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping("/todo")
@RequiredArgsConstructor
@Controller
//@RestController
public class TodoController {
	
	private final TodoService todoService;

	@ResponseBody
	@RequestMapping("/list")
	public ResponseEntity<?> list(Model model) {
		log.info("todo list.........");
		return todoService.getAllJson();
	}
	
//	@ResponseBody
//	@RequestMapping("/list")
//	public void list(Model model) {
//		log.info("todo list.........");
//		model.addAttribute("dtoList", todoService.getAll());
//	}
//	
	
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
	
//	@PostMapping("/register")
//	public String registerPost(@Valid TodoDTO todoDTO, 
//								BindingResult bindingResult,
//								RedirectAttributes redirectAttributes) {
//		log.info("POST todo register........");
//		
//		log.info(todoDTO);
//		
//		if(bindingResult.hasErrors()) {
//			log.info("has erros........");
//			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
//			
//			return "redirect:/todo/register";
//		}
//		
//		log.info(todoDTO);
//		
//		todoService.register(todoDTO);
//		
//		return "redirect:/todo/list";
//	}
	
	@PostMapping("/register")
	public String registerPost(@Valid @RequestBody TodoDTO todoDTO, 
								BindingResult bindingResult,
								RedirectAttributes redirectAttributes) {
		log.info("POST todo register........");
		
		log.info(todoDTO);
		
		if(bindingResult.hasErrors()) {
			log.info("has erros........");
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			
			return "redirect:/todo/register";
		}
		
		log.info(todoDTO);
		
		todoService.register(todoDTO);
		
		return "redirect:/todo/list";
	}
	
	@GetMapping({"/read", "/modify"})
	public void read(Long tno, Model model) {
		
		TodoDTO todoDTO = todoService.getOne(tno);
		log.info(todoDTO);
		
		model.addAttribute("dto", todoDTO);
	}
	
	@PostMapping("/remove")
	public String remove(Long tno, RedirectAttributes redirectAttributes) {
		
		log.info("------------------remove---------------------");
		log.info("tno: " + tno);
		
		todoService.remove(tno);
		
		return "redirect:/todo/list";
	}
	
	@PostMapping("/modify")
	public String modify(@Valid TodoDTO todoDTO,
						BindingResult bindingResult,
						RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()) {
			log.info("has erros......");
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			
			redirectAttributes.addAttribute("tno", todoDTO.getTno() );
			return "redirect:/todo/modify";
		}
		
		log.info(todoDTO);
		
		todoService.modify(todoDTO);
		
		return "redirect:/todo/list";
	}
}
