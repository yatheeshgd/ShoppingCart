package EE;

import java.text.NumberFormat;

public class Item {
	private String name;
	private double price;
	private int quantity;
	private double tax;

	public Item(String name, double cost, int quantity){
		this.name=name;
		this.price=cost;
		this.quantity=quantity;
	}

	public Item(String name, double cost, int quantity, double tax){
		this.name=name;
		this.price=cost;
		this.quantity=quantity;
		this.tax= tax;
	}
	
	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String toString ()
	{
		NumberFormat fmt = NumberFormat.getCurrencyInstance();

		if(tax > 0.0) {
			return (name + "\t" + fmt.format(price) + "\t" + quantity + "\t"
				+ fmt.format(price*quantity) + "\t" + tax);
		}
		else {
			return (name + "\t" + fmt.format(price) + "\t" + quantity + "\t"
					+ fmt.format(price*quantity));
		}
	}
}
