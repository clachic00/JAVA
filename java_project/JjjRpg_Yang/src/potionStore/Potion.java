package potionStore;

public class Potion {

	
	
	String pName;

	int pAddHealth;

	int pNum;
	
	int price;
	
	
	public Potion(String pName, int pAddHealth, int pNum, int price) {

		this.pName = pName;
		this.pAddHealth = pAddHealth;
		this.pNum = pNum;
		this.price = price;
		

	}


	@Override
	public String toString() {
		return "Potion [" + pName + ", 회복량=" + pAddHealth + ", 개수=" + pNum + ", price=" + price + "]";
	}
	
}
