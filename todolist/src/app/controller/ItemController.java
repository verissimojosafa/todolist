package app.controller;

import java.util.List;

import app.dao.ItemDAO;
import app.todolist.item.Item;

/**
 * 
 * @author Josafa
 *
 */
public class ItemController {
	private final ItemDAO ITEM_DAO = new ItemDAO();

	public Item store(Item item) {
		return this.ITEM_DAO.store(item);
	}

	public List<Item> retrieveAll() {
		return this.ITEM_DAO.retrieveAll();
	}

	public void delete(Long id) {
		this.ITEM_DAO.delete(id);
	}

	public void update(Long id, String name) {
		this.ITEM_DAO.update(id, name);
	}

	public List<Item> retrieve(String text) {
		return this.ITEM_DAO.retrieve(text);
	}

	public Item retrieve(Long id) {
		return this.ITEM_DAO.retrieve(id);
	}
}
