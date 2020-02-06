package app.dao;

import java.util.List;

import javax.persistence.Query;

import app.inventory.item.task.Task;

/**
 * 
 * @author JOSAF� VER�SSIMO
 *
 */
public class TaskDAO extends Dao {
	public Task store(Task task) {
		super.openSession();

		super.manager.getTransaction().begin();
		super.manager.persist(task);
		super.manager.getTransaction().commit();

		super.closeSession();

		return task;
	}

	public List<Task> retrieveAll() {
		super.openSession();

		super.manager.getTransaction().begin();
		Query select = super.manager.createQuery("SELECT tasks from Task tasks");
		List<Task> tasks = select.getResultList();

		super.manager.getTransaction().commit();

		super.closeSession();

		return tasks;
	}

	public void update(int taskId, String name, int priority) {
		super.openSession();

		super.manager.getTransaction().begin();

		Query query = super.manager.createQuery("UPDATE Task SET task = '" + name + "', priority = '"+ priority +"' WHERE id = " + taskId);
		int updateCount = query.executeUpdate();

		super.manager.getTransaction().commit();

		super.manager.close();
	}

	public void delete(int id) {
		super.openSession();

		super.manager.getTransaction().begin();

		Query deleteTaskQuery = super.manager.createNativeQuery("delete from tasks where id = " + id);
		deleteTaskQuery.executeUpdate();

		super.manager.getTransaction().commit();

		super.closeSession();
	}

	public List<Task> retrieve(String text) {
		super.openSession();

		super.manager.getTransaction().begin();
		Query select = super.manager.createQuery("SELECT t from Task t where task like '%" + text + "%'", Task.class);
		List<Task> tasks = select.getResultList();

		super.manager.getTransaction().commit();

		super.closeSession();

		return tasks;
	}
}
