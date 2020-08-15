package com.kiran.todo.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

@Service
public class ToDoService {

	@Autowired
	private ToDoRepository toDoRepository ; 
	
	public ToDoItem store(ToDoItem item ) {
		return toDoRepository.save(item);
	}
	
	public List<ToDoItem> all(){
		List<ToDoItem> toDoItems = new ArrayList<>();
		toDoRepository.findAll()
			.forEach(toDoItems::add);
		
		 
		return toDoItems; 
	}
	
	public ToDoItem findById(Long id ) {
		ToDoItem todo = toDoRepository.findById(id).get();
		 
		return todo;
	}
	 
}
