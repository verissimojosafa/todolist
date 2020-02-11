package app.userinterface.text.todolist;

import java.util.List;

import app.controller.TodolistController;
import app.todolist.Todolist;
import app.userinterface.Menu;

public class TodolistMenu extends Menu {
	private TodolistForm todolistForm;
	private TodolistController todolistController;

	public TodolistMenu() {
		super("Todolist");

		this.todolistForm = new TodolistForm();
		this.todolistController = new TodolistController();
	}

	protected void getMethod() {
		String method = this.action.doAction();

		if (method.equals("create")) {
			Todolist todolist = this.todolistForm.getDataToCreate();

			this.todolistController.store(todolist);

		} else if (method.equals("retrieve")) {
			String text = this.todolistForm.getDataToRetrieve("Digite o nome da lista:");

			List<Todolist> todolists = this.todolistController.retrieve(text);

			for (Todolist todolist : todolists) {
				System.out.println(todolist);
			}

		} else if (method.equals("retrieve all")) {
			List<Todolist> todolists = this.todolistController.retrieveAll();

			for (Todolist todolist : todolists) {
				System.out.println(todolist);
			}

		} else if (method.equals("update")) {
			Todolist todolist = this.todolistForm.getDataToUpdate();

			todolistController.update(todolist.getId(), todolist.getName(), todolist.getPriority());

		} else if (method.equals("delete")) {
			Long id = this.todolistForm.getDataToDelete("Digite o id da lista:");

			todolistController.delete(id);
		}
	}
}
