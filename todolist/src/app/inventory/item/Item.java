package app.inventory.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import app.inventory.Inventory;
import app.inventory.item.task.Task;
import app.inventory.item.task.subtask.ISubtaskCRUD;

@Entity
@Table(name = "items")
public class Item {
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "inventory_id")
	private Inventory inventory;

	@Column(name = "name")
	private String name;

	@OneToOne
	@JoinColumn(name = "task_id")
	private Task task;

	public Item() {
	}

	public Item(String name, String task, int priority) {
		this.name = name;
		this.task = new Task(task, priority);
	}

	public Item(String name) {
		this.name = name;
		this.task = new Task();
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTask() {
		return this.task.toString();
	}

	public boolean updateTask(String task, int priority) {
		if (Task.isValidTask(task)) {
			this.task.setTask(task);
			this.task.setPriority(priority);

			return true;

		} else {
			return false;
		}
	}

	public boolean updateTask(String task) {
		if (this.task == null)
			return false;

		return this.task.setTask(task);
	}

	public void updateTask(int priority) {
		this.task.setPriority(priority);
	}

	public ISubtaskCRUD getSubtaskCRUD() {
		ISubtaskCRUD subtaskCRUD = this.task;

		return subtaskCRUD;
	}

	public String toString() {
		String item = this.getName() + ":\n";
		this.task.setTaskSpaces(4);

		item += this.task.toString();

		return item;
	}
}
