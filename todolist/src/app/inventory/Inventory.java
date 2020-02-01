package app.inventory;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import app.inventory.item.Item;

@Entity
@Table(name="inventories")
public class Inventory {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@Transient
	private ArrayList<Item> items;
	private int priority;
	
	// Construtor criado sem
	public Inventory() {
		this.name = "";
		this.items = new ArrayList<Item>();
		this.priority = 0;
	}

	/**
	 * 
	 * @param name
	 * @param priority
	 */
	public Inventory(String name, int priority) {
		this.name = name;
		this.priority = priority;

		this.items = new ArrayList<Item>();
	}

	public String getName() {
		return this.name;
	}
	
	public Long getId() {
		return this.id;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public int getPriority() {
		return this.priority;
	}

	/**
	 * 
	 * @param priority
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * Add item in ArrayList
	 * 
	 * @param name
	 * @param task
	 * @param priority
	 */
	public void addItem(String name, String task, int priority) {
		Item item = new Item(name, task, priority);

		items.add(item);
	}

	/**
	 * Add a subitem to item
	 * 
	 * @param text
	 * @param name
	 * @param task
	 * @param priority
	 */
	public boolean addSubTaskToItem(String text, String task, int priority) {
		Item item = this.getItem(text);

		if (item != null) {
			item.addSubTask(task, priority);

			return true;
		}

		return false;
	}

	/**
	 * 
	 * @param text
	 */
	public boolean removeItem(String text) {
		Item itemToRemove = this.getItem(text);

		if (itemToRemove != null) {
			this.items.remove(itemToRemove);

			return true;
		}

		return false;
	}

	private boolean textIsValid(String text) {
		if (text.equals("") && text.equals(" ")) {
			return false;
		}

		return true;
	}

	private Item getItem(String text) {
		if (this.textIsValid(text)) {
			int counter = 0;
			Item target = null;
			for (Item item : this.items) {
				if (item.getName().indexOf(text) != -1 && counter == 0) {
					target = item;
					counter++;
				}
			}

			return counter == 1 ? target : null;
		}

		return null;
	}

	public String toString() {
		String list = this.getName() + "\n\n";

		for (Item item : this.items) {
			list += item.toString();
		}

		return list;
	}
}