package com.kiran.todo.todo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView; 

@Controller
public class ToDoController {
	
	@Autowired
	ToDoService toDoService ;
	
	@GetMapping("/todos")
	public ModelAndView index(	) {
		ModelAndView model = new ModelAndView();
		 
		model.setViewName("index"); 
		model.addObject("todos", toDoService.all());
		
		return model ; 
	}
	
	@PostMapping("/todo")
	public RedirectView store(ToDoItem item, RedirectAttributes attributes) {
		 
		toDoService.store(item);
		 
		 attributes.addFlashAttribute("message", "To do item added");
		 
		 return new RedirectView("todos");
	}
	
	@GetMapping("/todo/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id ) {
		ModelAndView model = new ModelAndView();
		ToDoItem todoItem = toDoService.findById(id);
	 
		model.addObject("todoItem", todoItem);
		model.addObject("todos", toDoService.all());
		model.setViewName("index");
		
		return model ; 
	}
}
