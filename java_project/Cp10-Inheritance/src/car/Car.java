package car;

public class Car {

	
	
	String color;
	String door;
	void drive() {
		System.out.println("운전");
		
		
	}
	
	
	
	void stop() {
		System.out.println("멈춤");
	}
	
	public static void main(String[] args) {
		Car car = null;
		Fireengine fe1 = new Fireengine();
		Fireengine fe2 = null;
		Ambulance am = null;
		
		fe1.water();
		car = fe1;
		
		fe2 =(Fireengine)car;
		
		
		
		System.out.println(car instanceof Ambulance);
		if (car instanceof Ambulance) {
		am = (Ambulance)car;
		am.siren();
		}
		
	}

	
	
}
	class Fireengine extends Car{
		void water() {
			System.out.println("물뿌리기");
		}
	}
	
	class Ambulance extends Car{
		void siren() {
			System.out.println("~~~~~~~~~~~");
		}
	


}