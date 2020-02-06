package app.inventory;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import app.inventory.item.IItemCRUD;
import app.inventory.item.Item;
import app.inventory.item.task.ITaskCRUD;
import app.inventory.item.task.subtask.ISubtaskCRUD;

/**
 * 
 * @author Josafa
 *
 */
@Entity(name = "Inventory")
@Table(name = "inventories")
public class Inventory implements IItemCRUD {
	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "inventory_id")
	private List<Item> items;

	private int priority;

	public Inventory() {
	}

	public Inventory(String name, int priority) {
		this.name = name;
		this.setPriority(priority);

		this.items = new ArrayList<Item>();
	}

	public String getName() {
		return this.name;
	}

	public Long getId() {
		return this.id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		if (priority > 3) {
			this.priority = 3;

		} else if (priority < 0) {
			this.priority = 0;

		} else {
			this.priority = priority;

		}
	}

	// CRUD - Item
	public boolean addItem(String name, String task, int priority) {
		if (Item.isNameValid(name)) {
			Item item = new Item(name, task, priority);

			items.add(item);
			return true;
		}

		return false;
	}

	public String retrieveItem(String text) {
		return this.getItem(text).toString();
	}

	public String retrieveAllItem() {
		return this.toString();
	}

	public boolean updateItem(String text, String name, int priority) {
		if (Item.isNameValid(name)) {
			Item target = this.getItem(text);

			target.setName(name);
			target.updateTask(priority);

			return true;
		}

		return false;
	}

	public boolean deleteItem(String text) {
		Item itemToRemove = this.getItem(text);

		if (itemToRemove != null) {
			this.items.remove(itemToRemove);

			return true;
		}

		return false;
	}
	// end CRUD - Item

	// CRUD - Task
	public ITaskCRUD getTaskCRUD(String toFindItem) {
		Item target = this.getItem(toFindItem);
		ITaskCRUD taskCRUD = target;

		return taskCRUD;
	}
	// end CRUD - Task

	// CRUD - Subtask
	public ISubtaskCRUD getSubTaskCRUD(String toItem) {
		Item target = this.getItem(toItem);

		return target.getSubtaskCRUD();
	}
	// end CRUD - Subtask

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
		String list = this.getName() + ", " + this.getPriority() + "\n\n";

		for (Item item : this.items) {
			list += item.toString() + "\n";
		}

		return list;
	}
}