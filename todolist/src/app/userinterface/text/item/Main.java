package app.userinterface.text.item;

public class Main {
	public static void main(String[] args) {
		String title = "CRUD";
		String[] options = { "Listar Itens", "Buscar Item", "Cadastrar Item", "Editar Item", "Remover Item" };

		Interface userinterface = new Interface(title, options);

		userinterface.menu();
	}
}
