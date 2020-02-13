package app.userinterface.text.todolist;

import app.controller.TodolistController;
import app.todolist.Todolist;
import app.userinterface.text.Form;

public class TodolistForm extends Form {

	private TodolistController todolistController;

	public TodolistForm(TodolistMenu menu) {
		super(menu);

		this.todolistController = new TodolistController();
	}

	public Todolist getDataToCreate() {
		String name = this.getString("Digite o nome da todolist: ");
		int priority = this.getInt("Digite a prioridade: ");

		Todolist todolist = new Todolist(name, priority);
		return todolist;
	}

	public Todolist getDataToUpdate() {
		Long id = this.getLong("Digite o id da todolist:");
		String name = this.getString("Digite o novo nome da todolist:");
		int priority = this.getInt("Digite a nova prioridade:");

		Todolist todolist = todolistController.retrieve(id);
		todolist.setName(name);
		todolist.setPriority(priority);

		return todolist;
	}
}
