package app.inventory.item;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ItemController {
	private EntityManagerFactory factory;
	private EntityManager manager;
	
	public ItemController() {
		factory = Persistence.createEntityManagerFactory("todolist");
		manager = factory.createEntityManager();
	}
	
	public void store(Item item) {
		manager.getTransaction().begin();
		manager.persist(item);
		
		manager.getTransaction().commit();
	}
	
	public void delete(Item item) {
		manager.getTransaction().begin();
		
		Query deleteItemQuery = manager.createNativeQuery("delete from inventories where id = " + item.getId());
		deleteItemQuery.executeUpdate();
		
		manager.getTransaction().commit();
	}
	
	public void delete(int id) {
		manager.getTransaction().begin();
		
		Query deleteItemQuery = manager.createNativeQuery("delete from inventories where id = " + id);
		deleteItemQuery.executeUpdate();
		
		manager.getTransaction().commit();
	}
	
	public void close() {
		manager.close();
		factory.close();
	}
}
