package app.userinterface.text.item;

import app.controller.ItemController;
import app.controller.TodolistController;
import app.todolist.Todolist;
import app.todolist.item.Item;
import app.userinterface.Form;

public class ItemForm extends Form {
	private ItemController itemController;
	private TodolistController todolistController;

	public ItemForm() {
		super();

		this.itemController = new ItemController();
		this.todolistController = new TodolistController();
	}

	public Item getDataToCreate() {
		Long id = this.getLong("Digite o id da todolist:");
		String name = this.getString("Digite o nome do item:");

		Todolist todolist = todolistController.retrieve(id);
		Item item = new Item(todolist, name);

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
