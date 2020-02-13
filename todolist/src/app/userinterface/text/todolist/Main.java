package app.userinterface.text.todolist;

import app.userinterface.text.Menu;

public class Main {
	public static void main(String[] args) {
		Menu menu = new TodolistMenu();

		menu.showMenu();
	}
}
