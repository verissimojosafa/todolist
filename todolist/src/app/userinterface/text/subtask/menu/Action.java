package app.userinterface.text.subtask.menu;

import java.util.List;
import java.util.Scanner;

import app.controller.InventoryController;
import app.inventory.Inventory;
import app.userinterface.text.inventory.form.InventoryForm;

public class Action {
	private int[] actions;

	private int actionCreate;
	private int actionRetrieveAll;
	private int actionRetrieve;
	private int actionUpdate;
	private int actionDelete;

	private InventoryForm inventoryForm;
	private InventoryController inventoryController;

	public Action(Menu menu) {
		this.inventoryController = new InventoryController();
		this.inventoryForm = new InventoryForm();
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

	private Inventory doCreate() {
		inventoryForm.setFields();
		Inventory inventory = inventoryForm.getInventory();
		inventory = inventoryController.store(inventory);

		return inventory;
	}

	private void doRetrieveAll() {
		List<Inventory> inventories = inventoryController.retrieveAll();

		for (Inventory inventory : inventories) {
			System.out.println(inventory);
		}
	}

	public void doDelete() {
		int id = inventoryForm.getId();
		inventoryController.delete(id);
	}

	public void doUpdate() {
		int id = inventoryForm.getId();
		inventoryForm.setFields();
		Inventory inventory = inventoryForm.getInventory();

		inventoryController.update(id, inventory.getName(), inventory.getPriority());
	}

	public void doRetrieve() {
		String text = inventoryForm.getText();
		List<Inventory> inventories = inventoryController.retrieve(text);

		for (Inventory inventory : inventories) {
			System.out.println(inventory);
		}
	}
}
