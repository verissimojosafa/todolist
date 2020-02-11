package app.userinterface.text.subtask;

import java.util.List;

import app.controller.SubtaskController;
import app.todolist.item.task.subtask.Subtask;
import app.userinterface.Menu;

public class SubtaskMenu extends Menu {
	private SubtaskForm subsubtaskForm;
	private SubtaskController subtaskController;

	public SubtaskMenu() {
		super("Subtask");

		this.subsubtaskForm = new SubtaskForm();
		this.subtaskController = new SubtaskController();
	}

	protected void getMethod() {
		String method = this.action.doAction();

		if (method.equals("create")) {
			Subtask subtask = this.subsubtaskForm.getDataToCreate();

			this.subtaskController.store(subtask);

		} else if (method.equals("retrieve")) {
			String text = this.subsubtaskForm.getDataToRetrieve("Digite o nome do subtask para busca-lo:");

			List<Subtask> subtasks = this.subtaskController.retrieve(text);

			for (Subtask subtask : subtasks) {
				System.out.println(subtask);
			}

		} else if (method.equals("retrieve all")) {
			List<Subtask> subtasks = this.subtaskController.retrieveAll();

			for (Subtask subtask : subtasks) {
				System.out.println(subtask);
			}

		} else if (method.equals("update")) {
			Subtask subtask = this.subsubtaskForm.getDataToUpdate();

			subtaskController.update(subtask.getId(), subtask.getTask(), subtask.getPriority());

		} else if (method.equals("delete")) {
			Long id = this.subsubtaskForm.getDataToDelete("Digite o id da tarefa para deletar:");

			subtaskController.delete(id);
		}
	}
}
