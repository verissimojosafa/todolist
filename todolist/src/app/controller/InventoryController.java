package app.controller;

import java.util.List;

import app.dao.InventoryDAO;
import app.inventory.Inventory;

/**
 * 
 * @author Josafa
 *
 */
public class InventoryController {
	private final InventoryDAO INVENTORY_DAO = new InventoryDAO();

	public Inventory store(Inventory inventory) {
		return this.INVENTORY_DAO.store(inventory);
	}

	public List<Inventory> retrieveAll() {
		return this.INVENTORY_DAO.retrieveAll();
	}

	public void delete(int id) {
		this.INVENTORY_DAO.delete(id);
	}

	public void update(int id, String name, int priority) {
		this.INVENTORY_DAO.update(id, name, priority);
	}

	public List<Inventory> retrieve(String text) {
		return this.INVENTORY_DAO.retrieve(text);
	}

}
