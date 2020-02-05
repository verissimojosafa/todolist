package app.controller;

import app.dao.SubtaskDAO;
import app.inventory.item.task.subtask.Subtask;

/**
 * 
 * @author Josafa
 *
 */
public class SubtaskController {
	private final SubtaskDAO SUBTASK_DAO = new SubtaskDAO();

	public void store(Subtask subtask) {
		this.SUBTASK_DAO.store(subtask);
	}
}