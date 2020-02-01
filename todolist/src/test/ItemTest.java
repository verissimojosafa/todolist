package test;

import java.util.Scanner;

import app.inventory.item.Item;

public class ItemTest {
	public static void main(String[] args) {
		Scanner stringInput = new Scanner(System.in);
		Scanner intInput = new Scanner(System.in);

		Item myItem = new Item("Academia", "Minha tarefa", 1);
		myItem.addSubTask("Minha Subtarefa 1", 2);
		myItem.addSubTask("Minha Subtarefa 2", 1);

		// System.out.println("Digite a nova tarefa e a sua prioridade: ");
		// String task = stringInput.nextLine();
		// int priority = intInput.nextInt();
		// myItem.setTask(priority);

		myItem.setSubTask("Minha Subtarefa 2", "Nova", 3);

		myItem.removeSubTask("Nova");

		System.out.println(myItem.toString(5));
	}
}