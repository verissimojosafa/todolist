package app.controller;

import java.util.List;

import app.dao.TaskDAO;
import app.todolist.item.task.Task;

/**
 * 
 * @author JOSAF� VER�SSIMO
 *
 */
public class TaskController {
	private final TaskDAO TASK_DAO = new TaskDAO();

	public Task store(Task task) {
		return this.TASK_DAO.store(task);
	}

	public List<Task> retrieveAll() {
		return this.TASK_DAO.retrieveAll();
	}

	public void delete(Long id) {
		this.TASK_DAO.delete(id);
	}

	public void update(Long id, String task, int priority) {
		this.TASK_DAO.update(id, task, priority);
	}

	public List<Task> retrieve(String text) {
		return this.TASK_DAO.retrieve(text);
	}

	public Task retrieve(Long id) {
		return this.TASK_DAO.retrieve(id);
	}
}
