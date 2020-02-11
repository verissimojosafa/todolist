package app.userinterface.text.item;

import java.util.List;

import app.controller.ItemController;
import app.todolist.item.Item;
import app.userinterface.Menu;

public class ItemMenu extends Menu {
	private ItemForm itemForm;
	private ItemController itemController;

	public ItemMenu() {
		super("Item");

		this.itemForm = new ItemForm();
		this.itemController = new ItemController();
	}

	protected void getMethod() {
		String method = this.action.doAction();

		if (method.equals("create")) {
			Item item = this.itemForm.getDataToCreate();

			this.itemController.store(item);

		} else if (method.equals("retrieve")) {
			String text = this.itemForm.getDataToRetrieve("Digite o nome do item para busca-lo:");

			List<Item> items = this.itemController.retrieve(text);

			for (Item item : items) {
				System.out.println(item);
			}

		} else if (method.equals("retrieve all")) {
			List<Item> items = this.itemController.retrieveAll();

			for (Item item : items) {
				System.out.println(item);
			}

		} else if (method.equals("update")) {
			Item item = this.itemForm.getDataToUpdate();

			itemController.update(item.getId(), item.getName());

		} else if (method.equals("delete")) {
			Long id = this.itemForm.getDataToDelete("Digite o id do item para deletar:");

			itemController.delete(id);
		}
	}
}
