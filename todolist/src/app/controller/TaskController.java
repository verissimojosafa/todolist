package app.controller;

import java.util.List;

import app.dao.TaskDAO;
import app.inventory.item.task.Task;

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

	public void delete(int id) {
		this.TASK_DAO.delete(id);
	}

	public void update(int id, String name, int priority) {
		this.TASK_DAO.update(id, name, priority);
	}

	public List<Task> retrieve(String text) {
		return this.TASK_DAO.retrieve(text);
	}
}
