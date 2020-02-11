package app.userinterface.text.todolist;

import app.userinterface.Menu;

public class Main {
	public static void main(String[] args) {
		Menu menu = new TodolistMenu();

		menu.showMenu();
	}
}
