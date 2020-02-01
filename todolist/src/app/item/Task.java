package app.item;

public class Task {
	private String task;
	private int priority;

	public Task(String task, int priority) {
		this.setTask(task);
		this.setPriority(priority);
	}

	public Task() {
		this.task = "";
		this.priority = 0;
	}

	public String getTask() {
		return this.task;
	}

	public boolean setTask(String task) {
		if (this.isValidTask(task)) {
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
}