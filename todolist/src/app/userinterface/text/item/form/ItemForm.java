package app.userinterface.text.item.form;

import java.util.List;
import java.util.Scanner;

import app.controller.InventoryController;
import app.inventory.Inventory;
import app.inventory.item.Item;

public class ItemForm {
	private Item item;

	public void setFields() {
		Scanner stringScanner = new Scanner(System.in);

		System.out.println("Digite o nome do item: ");
		String nameValue = stringScanner.nextLine();

		System.out.println("Digite um texto para procurar o inventario: ");
		String text = stringScanner.nextLine();

		Inventory inventory = this.getInventory(text);

		this.item = new Item(inventory, nameValue);
	}

	public Inventory getInventory(String text) {
		InventoryController inventoryController = new InventoryController();
		List<Inventory> inventories = inventoryController.retrieve(text);

		return inventories.get(0);
	}

	public int getId() {
		Scanner intScanner = new Scanner(System.in);

		System.out.println("Digite o id do inventario");
		int itemId = intScanner.nextInt();

		return itemId;
	}

	public Item getItem() {
		Item item = new Item(this.item.getName());

		return item;
	}

	public String getText() {
		Scanner stringScanner = new Scanner(System.in);

		System.out.println("Digite um texto para fazer a busca em inventários: ");
		String text = stringScanner.nextLine();

		return text;
	}
}
