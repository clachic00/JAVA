package PotionStore;

public class Potion {

	
	
	String pName;

	int pAddHealth;

	int pNum;
	
	
	public Potion(String pName, int pAddHealth, int pNum) {

		this.pName = pName;
		this.pAddHealth = pAddHealth;
		this.pNum = pNum;


	}


	@Override
	public String toString() {
		return "Potion [pName=" + pName + ", pAddHealth=" + pAddHealth + ", pNum=" + pNum + "]";
	}
	
}
