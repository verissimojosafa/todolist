package app.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import app.inventory.Inventory;

/**
 * 
 * @author Josafa
 *
 */
public class InventoryController {
	private EntityManagerFactory factory;
	private EntityManager manager;

	public InventoryController() {
		factory = Persistence.createEntityManagerFactory("todolist");
		manager = factory.createEntityManager();
	}

	public void store(Inventory inventory) {
		manager.getTransaction().begin();
		manager.persist(inventory);

		manager.getTransaction().commit();
	}

	public void delete(Inventory inventory) {
		manager.getTransaction().begin();

		Query deleteInventoryQuery = manager
				.createNativeQuery("delete from inventories where id = " + inventory.getId());
		deleteInventoryQuery.executeUpdate();

		manager.getTransaction().commit();
	}

	public void delete(int id) {
		manager.getTransaction().begin();

		Query delete = manager.createNativeQuery("delete from inventories where id = " + id);
		delete.executeUpdate();

		manager.getTransaction().commit();
	}

	public List<Inventory> retrieveAll() {
		manager.getTransaction().begin();

		Query select = manager.createQuery("SELECT inventories FROM Inventory inventories");
		List<Inventory> inventories = select.getResultList();

		manager.getTransaction().commit();

		return inventories;
	}

	public void close() {
		manager.close();
		factory.close();
	}
}
