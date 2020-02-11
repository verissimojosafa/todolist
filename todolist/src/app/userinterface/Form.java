package app.userinterface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Form {
	private Action action;

	public Form() {
		this.action = new Action();
	}

	public int getAction() {
		Scanner intInput = new Scanner(System.in);

		int action = 0;

		do {
			System.out.println("Digite um numero: ");

			try {
				action = intInput.nextInt();

			} catch (InputMismatchException ime) {
				System.out.println("Não insira strings >:(");

				intInput = new Scanner(System.in);
			}

		} while (!this.action.doValidAction(action));

		return action;
	}

	public String getDataToRetrieve(String msg) {
		String text = this.getString(msg);

		return text;
	}

	public Long getDataToDelete(String msg) {
		Long id = this.getLong(msg);

		return id;
	}

	protected String getString(String msg) {
		Scanner stringInput = new Scanner(System.in);

		System.out.println(msg);
		String string = stringInput.nextLine();

		return string;
	}

	protected int getInt(String msg) {
		Scanner intInput = new Scanner(System.in);

		boolean isNumber = true;

		int number = 0;
		do {
			try {
				System.out.println(msg);
				number = intInput.nextInt();

				isNumber = true;
			} catch (InputMismatchException ime) {
				System.out.println("Não insira strings >:(");

				intInput = new Scanner(System.in);

				isNumber = false;
			}
		} while (!isNumber);

		return number;
	}

	protected Long getLong(String msg) {
		Scanner intInput = new Scanner(System.in);

		boolean isNumber = true;

		Long number = null;
		do {
			try {
				System.out.println(msg);
				number = intInput.nextLong();

				isNumber = true;
			} catch (InputMismatchException ime) {
				System.out.println("Não insira strings >:(");

				intInput = new Scanner(System.in);

				isNumber = false;
			}
		} while (!isNumber);

		return number;
	}

}
