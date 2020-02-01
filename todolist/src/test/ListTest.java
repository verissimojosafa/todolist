package test;

import app.inventory.Inventory;

public class ListTest {
	public static void main(String[] args) {
		Inventory todoList = new Inventory("Academia", 2);

		for (int i = 0; i < 10; i++) {
			String nameItem = "Supino" + i;
			String task = "Tarefa" + i;
			int priority = i + 1;

			todoList.addItem(nameItem, task, priority);
			todoList.addSubTaskToItem(nameItem, "Sub" + task, priority);
			todoList.addSubTaskToItem(nameItem, "Sub" + task, priority);
			todoList.addSubTaskToItem(nameItem, "Sub" + task, priority);
		}
//		System.out.println(todoList.toString());
		
		System.out.println("Hello Git");

	}
}