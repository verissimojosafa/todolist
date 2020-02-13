package app.userinterface.text.item;

import app.controller.ItemController;
import app.controller.TaskController;
import app.controller.TodolistController;
import app.todolist.Todolist;
import app.todolist.item.Item;
import app.todolist.item.task.Task;
import app.userinterface.text.Form;
import app.userinterface.text.task.TaskMenu;

public class ItemForm extends Form {
	private ItemController itemController;
	private TodolistController todolistController;
	private TaskController taskController;

	private TaskMenu taskMenu;

	public ItemForm(ItemMenu menu) {
		super(menu);

		this.itemController = new ItemController();
		this.todolistController = new TodolistController();
		this.taskController = new TaskController();

		this.taskMenu = new TaskMenu();
	}

	public Item getDataToCreate() {
		Long id = this.getLong("Digite o id da todolist:");
		String name = this.getString("Digite o nome do item:");

		Todolist todolist = todolistController.retrieve(id);

		Task task = taskMenu.create();

		Item item = new Item(todolist, task, name);

		return item;
	}

	public Item getDataToUpdate() {
		Long id = this.getLong("Digite o id da todolist:");
		String name = this.getString("Digite o novo nome do item:");

		Item item = itemController.retrieve(id);

		item.setName(name);

		return item;
	}
}
