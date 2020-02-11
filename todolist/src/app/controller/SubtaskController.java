package app.controller;

import java.util.List;

import app.dao.SubtaskDAO;
import app.todolist.item.task.subtask.Subtask;

/**
 * 
 * @author Josafa
 *
 */
public class SubtaskController {
	private final SubtaskDAO SUBTASK_DAO = new SubtaskDAO();

	public Subtask store(Subtask subtask) {
		return this.SUBTASK_DAO.store(subtask);
	}

	public List<Subtask> retrieveAll() {
		return this.SUBTASK_DAO.retrieveAll();
	}

	public void delete(Long id) {
		this.SUBTASK_DAO.delete(id);
	}

	public void update(Long id, String subtask, int priority) {
		this.SUBTASK_DAO.update(id, subtask, priority);
	}

	public List<Subtask> retrieve(String text) {
		return this.SUBTASK_DAO.retrieve(text);
	}

	public Subtask retrieve(Long id) {
		return this.SUBTASK_DAO.retrieve(id);
	}
}
