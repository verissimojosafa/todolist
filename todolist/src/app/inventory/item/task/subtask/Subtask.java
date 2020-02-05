package app.inventory.item.task.subtask;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import app.inventory.item.task.Task;

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

	public Subtask() {
	}

	public Subtask(Task rootTask, String task, int priority) {
		this.rootTask = rootTask;
		this.task = task;
		this.priority = priority;
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

	public String toString() {
		String subtask = this.getTask() + ", " + this.getPriority() + "\n";

		return subtask;
	}

}
