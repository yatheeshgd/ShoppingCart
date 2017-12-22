package EE;

public class MainDriverClass {

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		double tax = 0.0;
		Item item1 = new Item("Dove",39.99, 5, 12.5 );
		Item item2 = new Item("Dove",39.99, 2, 12.5 );
		Item item3 = new Item("Axe",99.99, 2, 12.5);
		
		cart.addItem(item1);
		cart.addItem(item2);
		cart.addItem(item3);
		
		System.out.println(cart.toString());
	}
}
