package app.userinterface.text.item.menu;

import java.util.List;
import java.util.Scanner;

import app.controller.ItemController;
import app.inventory.item.Item;
import app.userinterface.text.item.form.ItemForm;

public class Action {
	private int[] actions;

	private int actionCreate;
	private int actionRetrieveAll;
	private int actionRetrieve;
	private int actionUpdate;
	private int actionDelete;

	private ItemForm itemForm;
	private ItemController itemController;

	public Action(Menu menu) {
		this.itemController = new ItemController();
		this.itemForm = new ItemForm();
		this.setActions(menu);
	}

	private void setActions(Menu menu) {
		String[] options = menu.getOptions();
		int[] validOptions = menu.getValidOptions();

		this.actions = validOptions;

		for (int validOption : validOptions) {
			String option = options[validOption];

			if (option.indexOf("Cadastrar") != -1) {
				this.actionCreate = validOption;

			} else if (option.indexOf("Listar") != -1) {
				this.actionRetrieveAll = validOption;

			} else if (option.indexOf("Buscar") != -1) {
				this.actionRetrieve = validOption;

			} else if (option.indexOf("Editar") != -1) {
				this.actionUpdate = validOption;

			} else if (option.indexOf("Remover") != -1) {
				this.actionDelete = validOption;

			}
		}
	}

	public int getAction(String errorMessage) {

		Scanner intScanner = new Scanner(System.in);

		int action = 0;
		while (true) {
			action = intScanner.nextInt();

			boolean isActionValid = doValidAction(action);

			if (isActionValid) {
				break;
			}

			System.out.println(errorMessage);
		}

		return action;
	}

	private boolean doValidAction(int target) {
		for (int action : actions) {
			if (action == target) {
				return true;
			}
		}

		return false;
	}

	public void doAction(int action) {
		if (action == this.actionCreate) {
			this.doCreate();

		} else if (action == this.actionRetrieveAll) {
			this.doRetrieveAll();

		} else if (action == this.actionRetrieve) {
			this.doRetrieve();

		} else if (action == this.actionUpdate) {
			this.doUpdate();

		} else if (action == this.actionDelete) {
			this.doDelete();

		}
	}

	private Item doCreate() {
		itemForm.setFields();
		Item item = itemForm.getItem();
		item = itemController.store(item);

		return item;
	}

	private void doRetrieveAll() {
		List<Item> items = itemController.retrieveAll();

		for (Item item : items) {
			System.out.println(item);
		}
	}

	public void doDelete() {
		int id = itemForm.getId();
		itemController.delete(id);
	}

	public void doUpdate() {
		int id = itemForm.getId();
		itemForm.setFields();
		Item item = itemForm.getItem();

		itemController.update(id, item.getName());
	}

	public void doRetrieve() {
		String text = itemForm.getText();
		List<Item> inventories = itemController.retrieve(text);

		for (Item item : inventories) {
			System.out.println(item);
		}
	}
}
