package app.userinterface.text.task.form;

import java.util.List;
import java.util.Scanner;

import app.controller.ItemController;
import app.inventory.item.Item;
import app.inventory.item.task.Task;

public class TaskForm {
	private ItemController itemController;
	private Task task;
	
	public TaskForm() {
		this.itemController = new ItemController();
	}

	public void setFields() {
		Scanner stringScanner = new Scanner(System.in);
		Scanner intScanner = new Scanner(System.in);

		System.out.println("Digite o nome da task: ");
		String nameValue = stringScanner.nextLine();
		
		System.out.println("Digite a prioridade da task: ");
		int priorityValue = intScanner.nextInt();
		
		System.out.println("Digite um text para procurar pelo nome do item: ");
		String text = stringScanner.nextLine();
		
		Item item = this.getItem(text);

		this.task = new Task(item, nameValue, priorityValue);
	}
	
	public int setUpdateFields() {
		Scanner stringScanner = new Scanner(System.in);
		Scanner intScanner = new Scanner(System.in);
		
		System.out.println("Digite o id do task: ");
		int id = intScanner.nextInt();

		System.out.println("Digite o nome do task: ");
		String nameValue = stringScanner.nextLine();
		
		System.out.println("Digite o nome do task: ");
		int priorityValue = intScanner.nextInt();

		this.task = new Task(nameValue, priorityValue);
		
		return id;
	}

	public Item getItem(String text) {
		List<Item> items = itemController.retrieve(text);
		
		for(Item item : items) {
			System.out.println(item);
		}
		
		return null;
	}

	public int getId() {
		Scanner intScanner = new Scanner(System.in);

		System.out.println("Digite o id do inventario");
		int taskId = intScanner.nextInt();

		return taskId;
	}

	public Task getTask() {
		Task task = new Task(this.task.getTask(), this.task.getPriority());

		return task;
	}

	public String getText() {
		Scanner stringScanner = new Scanner(System.in);

		System.out.println("Digite um texto para fazer a busca em task por nome: ");
		String text = stringScanner.nextLine();

		return text;
	}
}
