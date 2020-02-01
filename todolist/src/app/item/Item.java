package app.item;

import app.item.Task;
import java.util.ArrayList;

public class Item {
	private String name;
	private Task task;
	private ArrayList<Task> subTasks;

	/**
	 * Constructor
	 * 
	 * @param task
	 * @param priority
	 */
	public Item(String name, String task, int priority) {
		this.name = name;
		this.task = new Task(task, priority);

		this.subTasks = new ArrayList<Task>();
	}

	public Item(String name) {
		this.name = name;
		this.task = new Task();

		this.subTasks = new ArrayList<Task>();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * To update task and priority
	 * 
	 * @param task
	 * @param priority
	 * @return value of success
	 */
	public boolean setTask(String task, int priority) {
		if (!Task.isValidTask(task))
			return false;

		Task newTask = new Task(task, priority);

		this.task = newTask;

		return true;
	}

	/**
	 * To update only task
	 * 
	 * @param task
	 * @return value of success
	 */
	public boolean setTask(String task) {
		if (this.task == null)
			return false;

		return this.task.setTask(task);
	}

	/**
	 * Top update only priority
	 * 
	 * @param priority
	 */
	public void setTask(int priority) {
		this.task.setPriority(priority);
	}

	/**
	 * Add sub task to main task
	 * 
	 * @param task
	 * @param priority
	 * @return
	 */
	public boolean addSubTask(String task, int priority) {
		if (Task.isValidTask(task)) {
			Task subTask = new Task(task, priority);

			this.subTasks.add(subTask);

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
	public boolean setSubTask(String text, String subTask, int priority) {
		if (Task.isValidTask(subTask)) {
			Task oldSubTask = this.getSubTask(text);

			if (oldSubTask == null) {
				return false;
			} else {
				oldSubTask.setTask(subTask);
				oldSubTask.setPriority(priority);

				return true;
			}
		}

		return false;
	}

	/**
	 * Remove subTask by content
	 * 
	 * @param text
	 * @return
	 */
	public boolean removeSubTask(String text) {
		Task subTaskToRemove = this.getSubTask(text);

		if (subTaskToRemove != null) {
			this.subTasks.remove(subTaskToRemove);

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
	private Task getSubTask(String text) {
		if (this.textIsValid(text)) {
			int counter = 0;
			Task target = null;
			for (int i = 0; i < subTasks.size(); i++) {
				Task subTask = subTasks.get(i);

				if (subTask.getTask().indexOf(text) != -1) {
					counter++;
					target = subTask;
				}
			}
			return counter > 1 ? null : target;
		}

		return null;
	}

	/**
	 * To String method
	 * 
	 * @param position
	 * @return String representation of item (task and subtasks)
	 */
	public String toString(int position) {
		String item = position + ". " + this.getName() + " - " + this.task.getTask() + ", " + this.task.getPriority()
				+ "\n";

		for (Task subTask : this.subTasks) {
			if (subTask == null)
				break;
			item += "    " + subTask.getTask() + ", " + subTask.getPriority() + "\n";
		}

		return item;
	}
	
	public String toString() {
		String item = this.getName() + ":\n";
		item += "  " + this.task.getTask() + ", " + this.task.getPriority() + "\n";

		for (Task subTask : this.subTasks) {
			if (subTask == null)
				break;

			item += "    " + subTask.getTask() + ", " + subTask.getPriority() + "\n";
		}

		return item;
	}
}