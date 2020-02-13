package app.userinterface.text.task;

import java.util.List;

import app.controller.TaskController;
import app.todolist.item.task.Task;
import app.userinterface.text.Menu;

public class TaskMenu extends Menu {
	private TaskForm taskForm;
	private TaskController taskController;

	public TaskMenu() {
		super("Task", 1);

		this.taskForm = new TaskForm(this);
		this.taskController = new TaskController();
	}

	protected void doAction() {
		String method = this.action.getMethod();

		if (method.equals("create")) {
			this.create();

		} else if (method.equals("retrieve")) {
			this.retrieve();

		} else if (method.equals("retrieve all")) {
			this.retrieveAll();

		} else if (method.equals("update")) {
			this.update();

		} else if (method.equals("delete")) {
			this.delete();
		}
	}

	public Task create() {
		Task task = this.taskForm.getDataToCreate();

		task = this.taskController.store(task);

		return task;
	}

	public void retrieve() {
		String text = this.taskForm.getDataToRetrieve("Digite o nome do task para busca-lo:");

		List<Task> tasks = this.taskController.retrieve(text);

		for (Task task : tasks) {
			System.out.println(task);
		}
	}

	public void retrieveAll() {
		List<Task> tasks = this.taskController.retrieveAll();

		for (Task task : tasks) {
			System.out.println(task);
		}
	}

	public void update() {
		Task task = this.taskForm.getDataToUpdate();

		taskController.update(task.getId(), task.getTask(), task.getPriority());
	}

	public void delete() {
		Long id = this.taskForm.getDataToDelete("Digite o id da tarefa para deletar:");

		taskController.delete(id);
	}
}
