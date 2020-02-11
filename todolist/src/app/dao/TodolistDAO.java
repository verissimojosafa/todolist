package app.dao;

import java.util.List;

import javax.persistence.Query;

import app.todolist.Todolist;

public class TodolistDAO extends Dao {
	public Todolist store(Todolist todolist) {
		super.openSession();

		super.manager.getTransaction().begin();
		super.manager.persist(todolist);
		super.manager.getTransaction().commit();

		super.closeSession();

		return todolist;
	}

	public List<Todolist> retrieveAll() {
		super.openSession();

		super.manager.getTransaction().begin();
		Query select = super.manager.createQuery("SELECT t from Todolist t");
		List<Todolist> todolists = select.getResultList();

		super.manager.getTransaction().commit();

		super.closeSession();

		return todolists;
	}

	public void update(Long todolistId, String name, int priority) {
		super.openSession();

		super.manager.getTransaction().begin();

		Query query = super.manager.createQuery(
				"UPDATE Todolist SET name = '" + name + "', priority = '" + priority + "' WHERE id = " + todolistId);
		query.executeUpdate();

		super.manager.getTransaction().commit();

		super.manager.close();
	}

	public void delete(Long id) {
		super.openSession();

		super.manager.getTransaction().begin();

		Query deleteTodolistQuery = super.manager.createNativeQuery("delete from todolists where id = " + id);
		deleteTodolistQuery.executeUpdate();

		super.manager.getTransaction().commit();

		super.closeSession();
	}

	public List<Todolist> retrieve(String text) {
		super.openSession();

		super.manager.getTransaction().begin();

		Query select = super.manager.createQuery("SELECT t from Todolist t WHERE name like '%" + text + "%'");
		List<Todolist> todolists = select.getResultList();

		super.manager.getTransaction().commit();

		super.closeSession();

		return todolists;
	}

	public Todolist retrieve(Long id) {
		super.openSession();

		super.manager.getTransaction().begin();

		Query select = super.manager.createQuery("SELECT t from Todolist t WHERE id = " + id);
		Todolist todolist = (Todolist) select.getSingleResult();

		super.manager.getTransaction().commit();

		super.closeSession();

		return todolist;
	}
}
