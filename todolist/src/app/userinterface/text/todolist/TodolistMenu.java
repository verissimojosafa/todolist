package app.userinterface.text.todolist;

import java.util.List;

import app.controller.TodolistController;
import app.todolist.Todolist;
import app.userinterface.text.Menu;

public class TodolistMenu extends Menu {
	private TodolistForm todolistForm;
	private TodolistController todolistController;

	public TodolistMenu() {
		super("Todolist");

		this.todolistForm = new TodolistForm(this);
		this.todolistController = new TodolistController();
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

	public void create() {
		Todolist todolist = this.todolistForm.getDataToCreate();

		this.todolistController.store(todolist);
	}

	public void retrieve() {
		String text = this.todolistForm.getDataToRetrieve("Digite o nome da lista:");

		List<Todolist> todolists = this.todolistController.retrieve(text);

		for (Todolist todolist : todolists) {
			System.out.println(todolist);
		}
	}

	public void retrieveAll() {
		List<Todolist> todolists = this.todolistController.retrieveAll();

		for (Todolist todolist : todolists) {
			System.out.println(todolist);
		}
	}

	public void update() {
		Todolist todolist = this.todolistForm.getDataToUpdate();

		todolistController.update(todolist.getId(), todolist.getName(), todolist.getPriority());
	}

	public void delete() {
		Long id = this.todolistForm.getDataToDelete("Digite o id da lista:");

		todolistController.delete(id);
	}
}
