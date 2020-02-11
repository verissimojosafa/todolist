package app.dao;

import java.util.List;

import javax.persistence.Query;

import app.todolist.item.task.subtask.Subtask;

public class SubtaskDAO extends Dao {
	public Subtask store(Subtask subtask) {
		super.openSession();

		super.manager.getTransaction().begin();
		super.manager.persist(subtask);
		super.manager.getTransaction().commit();

		super.closeSession();

		return subtask;
	}

	public List<Subtask> retrieveAll() {
		super.openSession();

		super.manager.getTransaction().begin();
		Query select = super.manager.createQuery("SELECT s from Subtask s");
		List<Subtask> subtasks = select.getResultList();

		super.manager.getTransaction().commit();

		super.closeSession();

		return subtasks;
	}

	public void update(Long id, String subtask, int priority) {
		super.openSession();

		super.manager.getTransaction().begin();

		Query query = super.manager.createQuery("UPDATE Subtask SET subtask = '" + subtask + "' WHERE id = " + id);
		int updateCount = query.executeUpdate();

		super.manager.getTransaction().commit();

		super.manager.close();
	}

	public void delete(Long id) {
		super.openSession();

		super.manager.getTransaction().begin();

		Query deleteSubtaskQuery = super.manager.createNativeQuery("delete from subtasks where id = " + id);
		deleteSubtaskQuery.executeUpdate();

		super.manager.getTransaction().commit();

		super.closeSession();
	}

	public List<Subtask> retrieve(String text) {
		super.openSession();

		super.manager.getTransaction().begin();

		Query select = super.manager.createQuery("SELECT s from Subtask s where subtask like '%" + text + "%'");
		List<Subtask> subtasks = select.getResultList();

		super.manager.getTransaction().commit();

		super.closeSession();

		return subtasks;
	}

	public Subtask retrieve(Long id) {
		super.openSession();

		super.manager.getTransaction().begin();

		Query select = super.manager.createQuery("SELECT s from Subtask s WHERE id = " + id);
		Subtask subtask = (Subtask) select.getSingleResult();

		super.manager.getTransaction().commit();

		super.closeSession();

		return subtask;
	}
}
