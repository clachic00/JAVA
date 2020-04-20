package fruit2;

public class FruitSeller {

	int numOfApple;
	int myMoney;
	int applePrice;
	FruitSeller() {
		this(50, 0,1000);
	}

	FruitSeller(int num, int money, int price) {

		numOfApple = num;
		myMoney = money;
		applePrice = price;
	}

	int saleApple(int money) {
		int num = money / applePrice;
		myMoney += money;
		numOfApple -= num;
		
		return num;
	}
	
	
	
	
	
	
}
