package extest;

public class Car {
	int gasolinegauge;

	Car() {
		gasolinegauge = 1;
	}

}

class HybridCar extends Car {
	int electronicGauge;

	HybridCar() {
		super();
		electronicGauge = 2;
		

	}

}

class HybridWaterCar extends HybridCar {
	int waterGauge;

	HybridWaterCar(){
		super();
		
		waterGauge=3;
	}
	
	
	
	
	
	
	
	public void showCurrentGauge() {
		System.out.println("잔여 가솔린 : " + gasolinegauge);
		System.out.println("잔여 가솔린 : " + electronicGauge);
		System.out.println("잔여 가솔린 : " + waterGauge);
	}
	
	public void maon() {
		showCurrentGauge();
	}
	
	
	
	
}