package app.controller;

import java.util.List;

import app.dao.TodolistDAO;
import app.todolist.Todolist;

/**
 * 
 * @author Josafa
 *
 */
public class TodolistController {
	private final TodolistDAO TODOLIST_DAO = new TodolistDAO();

	public Todolist store(Todolist todolist) {
		return this.TODOLIST_DAO.store(todolist);
	}

	public List<Todolist> retrieveAll() {
		return this.TODOLIST_DAO.retrieveAll();
	}

	public void delete(Long id) {
		this.TODOLIST_DAO.delete(id);
	}

	public void update(Long id, String name, int priority) {
		this.TODOLIST_DAO.update(id, name, priority);
	}

	public List<Todolist> retrieve(String text) {
		return this.TODOLIST_DAO.retrieve(text);
	}

	public Todolist retrieve(Long id) {
		return this.TODOLIST_DAO.retrieve(id);
	}

}
