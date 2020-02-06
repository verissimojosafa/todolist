package app.userinterface.text.subtask.form;

import java.util.Scanner;

import app.inventory.Inventory;

public class InventoryForm {
	private Inventory inventory;

	public InventoryForm() {
		this.inventory = new Inventory();
	}

	public void setFields() {
		Scanner stringScanner = new Scanner(System.in);
		Scanner intScanner = new Scanner(System.in);

		System.out.println("Digite o nome do inventário: ");
		String nameValue = stringScanner.nextLine();

		System.out.println("Digite a prioridade do inventário: ");
		int priorityValue = intScanner.nextInt();

		this.inventory.setName(nameValue);
		this.inventory.setPriority(priorityValue);
	}

	public int getId() {
		Scanner intScanner = new Scanner(System.in);

		System.out.println("Digite o id do inventario");
		int inventoryId = intScanner.nextInt();

		return inventoryId;
	}

	public Inventory getInventory() {
		Inventory inventory = new Inventory(this.inventory.getName(), this.inventory.getPriority());

		return inventory;
	}

	public String getText() {
		Scanner stringScanner = new Scanner(System.in);

		System.out.println("Digite um texto para fazer a busca em inventários: ");
		String text = stringScanner.nextLine();

		return text;
	}
}
