package app.todolist.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import app.todolist.Todolist;
import app.todolist.item.task.ITaskCRUD;
import app.todolist.item.task.Task;
import app.todolist.item.task.subtask.ISubtaskCRUD;

/**
 * 
 * @author Josafa
 *
 */
@Entity(name = "Item")
@Table(name = "items")
public class Item implements ITaskCRUD {
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "todolist_id")
	private Todolist todolist;

	@Column(name = "name")
	private String name;

	@Transient
	private Task task;

	public Item() {
	}

	public Item(Todolist todolist, String name) {
		if (todolist.getId() != null) {
			this.todolist = todolist;
		}
		this.name = name;
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

	public Long getTodolistId() {
		return this.todolist.getId();
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

	// [C]RU[D] - task
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

	public String retrieveTask() {
		return this.task.toString();
	}

	// end [C]RU[D]

	public ISubtaskCRUD getSubtaskCRUD() {
		ISubtaskCRUD subtaskCRUD = this.task;

		return subtaskCRUD;
	}

	public static boolean isNameValid(String name) {
		if (name.equals(" ") || name.equals("")) {
			return false;
		}

		return true;
	}

	public String toString() {
		String id = "";
		if (this.getId() != null) {
			id += this.getId();

			id = id + " - ";
		}

		String item = id + this.getName() + ":\n";

		if (this.task != null) {
			this.task.setTaskSpaces(4);

			item += this.task.toString();
		}
		return item;
	}
}
