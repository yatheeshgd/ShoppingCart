package EE;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	List<Item> items;
	private int itemCount;
	private double totalPrice;

	public ShoppingCart(){
		this.items=new ArrayList<Item>();
	}

	public void addItem(Item item) {
		//check if the item already exists in the cart
		if(this.items != null && !this.items.isEmpty()) {
			for(Item itemCheck : items) {
				if(itemCheck.getName() == item.getName()) {
					this.totalPrice += (item.getPrice() * item.getQuantity());
					this.itemCount += item.getQuantity();
					itemCheck.setQuantity(this.itemCount);
				}
				else {
					this.totalPrice += (item.getPrice() * item.getQuantity());
					this.itemCount += item.getQuantity();
					this.items.add(item);
					break;
				}
			}
		}
		else {
			this.totalPrice += (item.getPrice() * item.getQuantity());
			this.itemCount += item.getQuantity();
			this.items.add(item);
		}
	}

	public void removeItem(Item item){
		this.items.remove(item);
	}

	public String toString()
	{
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		double tax = 0.0;
		String contents = "\nShopping Cart\n";
		contents += "\nItem\tUnitPrice\tCount\tTotal\t\tTax\n";

		for(Item item : items){
			contents += item.toString() + "\n";
			
			//get the tax rate for items
			if(tax == 0.0 && item.getTax() > 0.0)
				tax = item.getTax();
		}
		
		//calculate tax only if tax is applicable or passed for the items
		if(tax > 0.0) {
			contents += "\nTotal tax: \t\t\t" + fmt.format(totalPrice * (tax/100));
			totalPrice = totalPrice + (totalPrice * (tax/100));
		}
		
		contents += "\nTotal Price: \t\t\t" + fmt.format(totalPrice);
		contents += "\n";

		return contents;
	}
}
