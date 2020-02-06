package app.userinterface.text.task.menu;

public class Menu {
	private String title;
	private String[] options;
	private int[] validOptions;

	public Menu(String title, String[] options) {
		this.title = title;
		this.setOptions(options);
	}

	private void setOptions(String[] options) {
		this.options = options;
		this.validOptions = new int[options.length];

		for (int i = 0; i < options.length; i++) {
			this.validOptions[i] = i;
		}
	}

	public int[] getValidOptions() {
		int[] validActions = this.validOptions.clone();

		return validActions;
	}

	public String[] getOptions() {
		String[] options = this.options.clone();

		return options;
	}

	public String getMenu() {
		String menu = this.title + "\n\n";
		final int PENULTIMATE = this.options.length - 1;

		for (int i = 0; i < this.options.length; i++) {
			int action = this.validOptions[i];
			String option = this.options[i];

			menu += action + ". " + option;
			if (i < PENULTIMATE) {
				menu += "\n";
			}
		}

		return menu;
	}
}
