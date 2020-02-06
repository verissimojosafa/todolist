package app.userinterface.text.inventory;

import app.userinterface.text.inventory.menu.Action;
import app.userinterface.text.inventory.menu.Menu;

public class Interface {
	private String title;
	private String[] options;
	private Menu menu;
	private Action action;

	public Interface(String title, String[] options) {
		this.title = title;
		this.options = options;

		this.menu = new Menu(title, options);
		this.action = new Action(this.menu);
	}

	public void menu() {
		System.out.println(menu.getMenu());
		int actionValid = action.getAction("Insira uma acao valida");

		action.doAction(actionValid);
	}
}
