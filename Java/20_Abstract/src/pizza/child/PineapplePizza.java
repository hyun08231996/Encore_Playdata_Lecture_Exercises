package pizza.child;

import pizza.parent.Pizza;

public class PineapplePizza extends Pizza {
	
	public PineapplePizza(int price, String storeName) {
		super(price, storeName);
	}
	
	@Override
	public void topping() {
		System.out.println("Pineapple Topping...Pizza");
	}
}
