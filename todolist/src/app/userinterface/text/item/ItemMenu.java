package app.userinterface.text.item;

import java.util.List;

import app.controller.ItemController;
import app.todolist.item.Item;
import app.userinterface.text.Menu;
import app.userinterface.text.todolist.TodolistMenu;

public class ItemMenu extends Menu {
	private ItemForm itemForm;
	private ItemController itemController;

	private TodolistMenu todolistMenu;

	public ItemMenu() {
		super("Item");

		this.itemForm = new ItemForm(this);
		this.itemController = new ItemController();

		this.todolistMenu = new TodolistMenu();
	}

	protected void doAction() {
		String method = this.action.getMethod();

		if (method.equals("create")) {
			this.todolistMenu.retrieveAll();

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
		Item item = this.itemForm.getDataToCreate();

		this.itemController.store(item);
	}

	public void retrieve() {
		String text = this.itemForm.getDataToRetrieve("Digite o nome do item para busca-lo:");

		List<Item> items = this.itemController.retrieve(text);

		for (Item item : items) {
			System.out.println(item);
		}
	}

	public void retrieveAll() {
		List<Item> items = this.itemController.retrieveAll();

		for (Item item : items) {
			System.out.println(item);
		}
	}

	public void update() {
		Item item = this.itemForm.getDataToUpdate();

		itemController.update(item.getId(), item.getName());
	}

	public void delete() {
		Long id = this.itemForm.getDataToDelete("Digite o id do item para deletar:");

		itemController.delete(id);
	}
}
