package app.dao;

import app.inventory.item.task.Task;

/**
 * 
 * @author JOSAF� VER�SSIMO
 *
 */
public class TaskDAO extends Dao {
	
	public TaskDAO() {
		super();
	}
	
	public void store(Task task) {
		super.openSession();
		
		super.manager.getTransaction().begin();		
			super.manager.persist(task);		
		super.manager.getTransaction().commit();
		
		super.closeSession();
	}
}