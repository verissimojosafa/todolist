package app.userinterface.text.subtask;

import app.controller.SubtaskController;
import app.controller.TaskController;
import app.todolist.item.task.Task;
import app.todolist.item.task.subtask.Subtask;
import app.userinterface.text.Form;

public class SubtaskForm extends Form {
	private TaskController taskController;
	private SubtaskController subtaskController;

	public SubtaskForm(SubtaskMenu menu) {
		super(menu);

		this.taskController = new TaskController();
		this.subtaskController = new SubtaskController();
	}

	public Subtask getDataToCreate() {
		Long id = this.getLong("Digite o id da tarefa:");
		String activity = this.getString("Digite a subtarefa:");
		int priority = this.getInt("Digite a prioridade:");

		Task task = taskController.retrieve(id);
		Subtask subtask = new Subtask(task, activity, priority);

		return subtask;
	}

	public Subtask getDataToUpdate() {
		Long id = this.getLong("Digite o id da subtarefa:");
		String activity = this.getString("Digite o novo nome da subtarefa:");
		int priority = this.getInt("Digite a nova prioridade:");

		Subtask subtask = subtaskController.retrieve(id);
		subtask.setTask(activity);
		subtask.setPriority(priority);

		return subtask;
	}
}
