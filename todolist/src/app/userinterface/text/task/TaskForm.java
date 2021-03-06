package app.userinterface.text.task;

import app.controller.ItemController;
import app.controller.TaskController;
import app.todolist.item.task.Task;
import app.userinterface.text.Form;

public class TaskForm extends Form {
	private TaskController taskController;
	private ItemController itemController;

	public TaskForm(TaskMenu menu) {
		super(menu);

		this.taskController = new TaskController();
		this.itemController = new ItemController();
	}

	public Task getDataToCreate() {
		String activity = this.getString("Digite a tarefa:");
		int priority = this.getInt("Digite a prioridade:");

		Task task = new Task(activity, priority);

		return task;
	}

	public Task getDataToUpdate() {
		Long id = this.getLong("Digite o id da tarefa:");
		String activity = this.getString("Digite o novo nome da tarefa:");
		int priority = this.getInt("Digite a nova prioridade:");

		Task task = taskController.retrieve(id);
		task.setTask(activity);
		task.setPriority(priority);

		return task;
	}
}
