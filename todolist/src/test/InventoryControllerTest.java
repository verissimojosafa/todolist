package test;

import java.util.List;

import app.inventory.Inventory;
import app.inventory.InventoryController;

public class InventoryControllerTest {
	public static void main(String[] args) {
//		JPA jpa = new JPA("todolist");
//		EntityManager manager = jpa.getManager();
//		
//		List list = new List("Minha Nova Lista", 2);
//		list.addItem("itemName", "favouriteTask", 1);
//		
//		manager.getTransaction().begin();
//		// cria um registro
//		manager.persist(list);
//		
//		// busca pela id
//		List minhaLista = manager.find(List.class, 1L);
//		manager.getTransaction().commit();
//		
//		System.out.println("Nome da lista: " + minhaLista.getName());
		
		Inventory list = new Inventory("Minha lista", 3);
		list.addItem("nome do item", "nome da task", 3);
		list.addSubTaskToItem("nome do item", "subtask", 3);
		
		InventoryController inventoryController = new InventoryController();
		inventoryController.store(list);
		
//		inventoryController.delete(1);
		
		List<Inventory> inventories = inventoryController.retrieveAll();
		
		for(Inventory inventory : inventories) 
			System.out.println(inventory.getId());
		
		inventoryController.close();
	}
}
