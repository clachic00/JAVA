package method;

public class Boy2 {

	int numOfMarble;

	Boy2(int num) {
		numOfMarble = num;

	}

	void gameWin(Boy2 boy, int num) {

		numOfMarble += num;
		boy.numOfMarble -= num;

	}

	public static void main(String [ ] args) {
		
		Boy2 boy1 = new Boy2(15);
		Boy2 boy2 = new Boy2(9);
		
		System.out.println("1라운드");
		System.out.println("철수가 5개 승");
		boy1.gameWin(boy2, 5);
		System.out.println("철수의 구슬 갯수"+boy1.numOfMarble+"영희의 구슬갯수"+boy2.numOfMarble);
		System.out.println("---------------------------");
		
		System.out.println("1라운드");
		System.out.println("영희가 8개 승");
		boy2.gameWin(boy1, 8);
		System.out.println("철수의 구슬 갯수"+boy1.numOfMarble+"영희의 구슬갯수"+boy2.numOfMarble);
		System.out.println("---------------------------");
		
		
		
		
		
	}
	
}	

	
	

