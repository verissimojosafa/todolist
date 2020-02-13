package app.userinterface.text.subtask;

import java.util.List;

import app.controller.SubtaskController;
import app.todolist.item.task.subtask.Subtask;
import app.userinterface.text.Menu;
import app.userinterface.text.task.TaskMenu;

public class SubtaskMenu extends Menu {
	private SubtaskForm subtaskForm;
	private SubtaskController subtaskController;

	private TaskMenu taskMenu;

	public SubtaskMenu() {
		super("Subtask");

		this.subtaskForm = new SubtaskForm(this);
		this.subtaskController = new SubtaskController();

		this.taskMenu = new TaskMenu();
	}

	protected void doAction() {
		String method = this.action.getMethod();

		if (method.equals("create")) {
			this.taskMenu.retrieveAll();

			this.create();

		} else if (method.equals("retrieve")) {
			this.retrieve();

		} else if (method.equals("retrieve all")) {
			this.retrieveAll();

		} else if (method.equals("update")) {
			this.retrieveAll();

			this.update();

		} else if (method.equals("delete")) {
			this.retrieveAll();

			this.delete();

		}
	}

	public void create() {
		Subtask subtask = this.subtaskForm.getDataToCreate();

		this.subtaskController.store(subtask);
	}

	public void retrieve() {
		String text = this.subtaskForm.getDataToRetrieve("Digite o nome do subtask para busca-lo:");

		List<Subtask> subtasks = this.subtaskController.retrieve(text);

		for (Subtask subtask : subtasks) {
			System.out.println(subtask);
		}

	}

	public void retrieveAll() {
		List<Subtask> subtasks = this.subtaskController.retrieveAll();

		for (Subtask subtask : subtasks) {
			System.out.println(subtask);
		}

	}

	public void update() {
		Subtask subtask = this.subtaskForm.getDataToUpdate();

		subtaskController.update(subtask.getId(), subtask.getTask(), subtask.getPriority());

	}

	public void delete() {
		Long id = this.subtaskForm.getDataToDelete("Digite o id da tarefa para deletar:");

		subtaskController.delete(id);
	}
}
