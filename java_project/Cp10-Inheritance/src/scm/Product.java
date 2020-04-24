package scm;

//상품 객체들의 상위클래스
public class Product {

	final int price; // 제품의 가격
	final int bonusPoint; // 제품구매 시 제공하는 보너스점수

	Product(int price) {
		this.price = price;
		this.bonusPoint = (int) (price / 10.0);

	}

}
