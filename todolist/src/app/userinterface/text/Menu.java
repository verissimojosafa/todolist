package app.userinterface.text;

public abstract class Menu {
	private final int FLAG = 0;

	private String entity;
	private Form form;
	protected Action action;

	public Menu(String entity) {
		this.action = new Action();
		this.form = new Form(this);

		this.entity = entity;
	}

	public Menu(String entity, int actionNotAllowed) {
		this.action = new Action(actionNotAllowed);
		this.form = new Form(this);

		this.entity = entity;
	}

	public void showMenu() {
		int stop = 1;
		int action = 0;
		while (true) {
			System.out.println("Digite " + this.FLAG + " para parar");

			this.action.showActions(this.entity);

			action = this.form.getAction(this.FLAG);

			if (action == this.FLAG) {
				break;
			}

			this.action.setAction(action);

			this.doAction();
		}

		System.out.println("Saindo...");
	}

	public Action getAction() {
		return this.action;
	}

	protected abstract void doAction();
}
