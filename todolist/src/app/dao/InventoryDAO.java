package app.dao;

import java.util.List;

import javax.persistence.Query;

import app.inventory.Inventory;

public class InventoryDAO extends Dao {
	public Inventory store(Inventory inventory) {
		super.openSession();

		super.manager.getTransaction().begin();
		super.manager.persist(inventory);
		super.manager.getTransaction().commit();

		super.closeSession();

		return inventory;
	}

	public List<Inventory> retrieveAll() {
		super.openSession();

		super.manager.getTransaction().begin();
		Query select = super.manager.createQuery("SELECT inventories from Inventory inventories");
		List<Inventory> inventories = select.getResultList();

		super.manager.getTransaction().commit();

		super.closeSession();

		return inventories;
	}

	public void update(int inventoryId, String name, int priority) {
		super.openSession();

		super.manager.getTransaction().begin();

		Query query = super.manager.createQuery(
				"UPDATE Inventory SET name = '" + name + "', priority = '" + priority + "' WHERE id = " + inventoryId);
		int updateCount = query.executeUpdate();

		super.manager.getTransaction().commit();

		super.manager.close();
	}

	public void delete(int id) {
		super.openSession();

		super.manager.getTransaction().begin();

		Query deleteInventoryQuery = super.manager.createNativeQuery("delete from inventories where id = " + id);
		deleteInventoryQuery.executeUpdate();

		super.manager.getTransaction().commit();

		super.closeSession();
	}

	public List<Inventory> retrieve(String text) {
		super.openSession();

		super.manager.getTransaction().begin();
		Query select = super.manager
				.createQuery("SELECT i from Inventory i WHERE name like '%" + text + "%'");
		List<Inventory> inventories = select.getResultList();

		super.manager.getTransaction().commit();

		super.closeSession();

		return inventories;
	}
}
