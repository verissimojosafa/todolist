package app.dao;

import app.inventory.item.task.Task;

/**
 * 
 * @author JOSAFÁ VERÍSSIMO
 *
 */
public class ItemDAO extends Dao {

	public ItemDAO() {
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
