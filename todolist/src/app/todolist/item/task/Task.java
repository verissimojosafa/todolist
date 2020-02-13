package app.todolist.item.task;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import app.todolist.item.task.subtask.ISubtaskCRUD;
import app.todolist.item.task.subtask.Subtask;

/**
 * 
 * @author Josafa
 *
 */
@Entity(name = "Task")
@Table(name = "tasks")
public class Task implements ISubtaskCRUD {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "task_id")
	private List<Subtask> subtasks;

	@Column(name = "task")
	private String task;

	@Column(name = "priority")
	private int priority;

	@Transient
	private int taskSpaces;

	public Task() {
		this.taskSpaces = 0;
	}

	public Task(String task, int priority) {
		this.setTask(task);
		this.setPriority(priority);

		this.subtasks = new ArrayList<Subtask>();
		this.taskSpaces = 0;
	}

	public void setTaskSpaces(int spaces) {
		this.taskSpaces = spaces;
	}

	private String getSpaces(int spaces) {
		String space = "";
		for (int i = 1; i <= spaces; i++) {
			space += " ";
		}

		return space;
	}

	public Long getId() {
		return this.id;
	}

	public String getTask() {
		return this.task;
	}

	public boolean setTask(String task) {
		if (Task.isValidTask(task)) {
			this.task = task;

			return true;
		}

		return false;
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

	public static boolean isValidTask(String task) {
		if (task.equals("") && task.equals(" ")) {
			return false;
		}

		return true;
	}

	/**
	 * Add sub task to main task
	 * 
	 * @param task
	 * @param priority
	 * @return
	 */
	public boolean addSubtask(String task, int priority) {
		if (Task.isValidTask(task)) {
			Subtask subtask = new Subtask(this, task, priority);

			this.subtasks.add(subtask);

			return true;
		}

		return false;
	}

	/**
	 * Update subTask
	 * 
	 * @param text
	 * @param subTask
	 * @param priority
	 * @return
	 */
	public boolean updateSubtask(String text, String subTask, int priority) {
		if (Task.isValidTask(subTask)) {
			Subtask oldSubtask = this.getSubtask(text);

			if (oldSubtask == null) {
				return false;
			} else {
				oldSubtask.setTask(subTask);
				oldSubtask.setPriority(priority);

				return true;
			}
		}

		return false;
	}

	public String retrieveSubtask(String text) {
		Subtask subtask = this.getSubtask(text);

		if (subtask != null) {
			return subtask.toString();
		} else {
			return "Subtarefa n�o encontrada";
		}
	}

	/**
	 * Remove subTask by content
	 * 
	 * @param text
	 * @return
	 */
	public boolean deleteSubtask(String text) {
		Subtask subTaskToRemove = this.getSubtask(text);

		if (subTaskToRemove != null) {
			this.subtasks.remove(subTaskToRemove);

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

	/**
	 * 
	 * @param text
	 * @return
	 */
	private Subtask getSubtask(String text) {
		if (this.textIsValid(text)) {
			int counter = 0;
			Subtask target = null;
			for (int i = 0; i < subtasks.size(); i++) {
				Subtask subtask = subtasks.get(i);

				if (subtask.getTask().indexOf(text) != -1) {
					counter++;
					target = subtask;
				}
			}
			return counter > 1 ? null : target;
		}

		return null;
	}

	public String retrieveAllSubtasks(int indentation) {
		String subtasksString = "";
		for (Subtask subtask : subtasks) {

			if (subtask == null) {
				continue;
			}

			subtask.setSubtaskSpaces(this.taskSpaces + indentation);

			subtasksString += subtask.toString();

//			subtasksString += this.getSpaces(this.taskSpaces + indentation) + subtask.getTask() + ", "
//					+ subtask.getPriority() + "\n";
		}

		return subtasksString;
	}

	public String retrieveAllSubtasks() {
		String subtasksString = "";
		for (Subtask subtask : subtasks) {

			subtasksString += this.getSpaces(this.taskSpaces) + subtask.getTask() + ", " + subtask.getPriority() + "\n";
		}

		return subtasksString;
	}

	public String toString() {
		String id = "";
		if (this.getId() != null) {
			id += this.getId();

			id = id + " - ";
		}

		final int INDENTATION = 4;

		String task = this.getSpaces(this.taskSpaces) + id + this.getTask() + ", " + this.getPriority() + ":\n";

		task += this.retrieveAllSubtasks(INDENTATION);

		return task;
	}
}
