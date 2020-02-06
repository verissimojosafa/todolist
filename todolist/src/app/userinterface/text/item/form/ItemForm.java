package app.userinterface.text.item.form;

import java.util.List;
import java.util.Scanner;

import app.controller.InventoryController;
import app.inventory.Inventory;
import app.inventory.item.Item;

public class ItemForm {
	private InventoryController inventoryController;
	private Item item;
	
	public ItemForm() {
		this.inventoryController = new InventoryController();
	}

	public void setFields() {
		Scanner stringScanner = new Scanner(System.in);

		System.out.println("Digite o nome do item: ");
		String nameValue = stringScanner.nextLine();

		System.out.println("Digite um texto para procurar o inventario: ");
		String text = stringScanner.nextLine();
		
		Inventory inventory = this.getInventory(text);

		this.item = new Item(inventory, nameValue);
	}
	
	public int setUpdateFields() {
		Scanner stringScanner = new Scanner(System.in);
		Scanner intScanner = new Scanner(System.in);
		
		System.out.println("Digite o id do item: ");
		int id = intScanner.nextInt();

		System.out.println("Digite o nome do item: ");
		String nameValue = stringScanner.nextLine();

		this.item = new Item(nameValue);
		
		return id;
	}

	public Inventory getInventory(String text) {
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

		System.out.println("Digite um texto para fazer a busca em item por nome: ");
		String text = stringScanner.nextLine();

		return text;
	}
}
