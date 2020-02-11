package app.userinterface.text.task;

import java.util.List;

import app.controller.TaskController;
import app.todolist.item.task.Task;
import app.userinterface.Menu;

public class TaskMenu extends Menu {
	private TaskForm taskForm;
	private TaskController taskController;

	public TaskMenu() {
		super("Task");

		this.taskForm = new TaskForm();
		this.taskController = new TaskController();
	}

	protected void getMethod() {
		String method = this.action.doAction();

		if (method.equals("create")) {
			Task task = this.taskForm.getDataToCreate();

			this.taskController.store(task);

		} else if (method.equals("retrieve")) {
			String text = this.taskForm.getDataToRetrieve("Digite o nome do task para busca-lo:");

			List<Task> tasks = this.taskController.retrieve(text);

			for (Task task : tasks) {
				System.out.println(task);
			}

		} else if (method.equals("retrieve all")) {
			List<Task> tasks = this.taskController.retrieveAll();

			for (Task task : tasks) {
				System.out.println(task);
			}

		} else if (method.equals("update")) {
			Task task = this.taskForm.getDataToUpdate();

			taskController.update(task.getId(), task.getTask(), task.getPriority());

		} else if (method.equals("delete")) {
			Long id = this.taskForm.getDataToDelete("Digite o id da tarefa para deletar:");

			taskController.delete(id);
		}
	}
}
