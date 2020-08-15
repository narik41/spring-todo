package com.kiran.todo.todo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="todo_items")
public class ToDoItem {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id ; 
	
	@Column(name="name")
	private String name ; 
	
	@Column(name="is_done")
	private Boolean isDone = false;
	
	@Column(name="created_at")
	private Date createdAt = new Date();

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Boolean getIsDone() {
		return isDone;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
