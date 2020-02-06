package app.dao;

import app.inventory.item.task.subtask.Subtask;

public class SubtaskDAO extends Dao {
	public Subtask store(Subtask subtask) {
		super.openSession();

		super.manager.getTransaction().begin();

		super.manager.persist(subtask);

		super.manager.getTransaction().commit();

		super.closeSession();

		return subtask;
	}
}
