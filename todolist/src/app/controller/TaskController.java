package app.controller;

import app.dao.TaskDAO;
import app.inventory.item.task.Task;

/**
 * 
 * @author JOSAF� VER�SSIMO
 *
 */
public class TaskController {
	private final TaskDAO TASK_DAO = new TaskDAO();

	public TaskController() {
	}

	public void store(Task task) {
		this.TASK_DAO.store(task);
	}
}
