package app.todolist.item.task.subtask;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import app.todolist.item.task.Task;

/**
 * 
 * @author Josafa
 *
 */
@Entity(name = "Subtask")
@Table(name = "subtasks")
public class Subtask {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "task_id")
	private Task rootTask;

	@Column(name = "subtask")
	private String task;

	@Column(name = "priority")
	private int priority;

	@Transient
	private int subtaskSpaces;

	public Subtask() {
	}

	public Subtask(Task rootTask, String task, int priority) {
		this.rootTask = rootTask;
		this.task = task;
		this.priority = priority;
		this.subtaskSpaces = 0;
	}

	public Long getId() {
		return this.id;
	}

	public Long getRootTaskId() {
		return this.rootTask.getId();
	}

	public String getTask() {
		return this.task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void setSubtaskSpaces(int spaces) {
		this.subtaskSpaces = spaces;
	}

	private String getSubtaskSpaces() {
		String spaces = "";
		for (int i = 1; i <= this.subtaskSpaces; i++) {
			spaces += " ";
		}

		return spaces;
	}

	public String toString() {
		String id = "";
		if (this.id != null) {
			id += this.getId();

			id = id + " - ";
		}

		String subtask = this.getSubtaskSpaces() + id + this.getTask() + ", " + this.getPriority() + ";\n";

		return subtask;
	}

}
