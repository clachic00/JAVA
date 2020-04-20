package method;

public class Boy3 {

	int numOfMarble;
		
	Boy3(int num) {
		numOfMarble = num;
	}
		
	void gameWin(Boy3 boy, int num) {
		numOfMarble += num;
		boy.numOfMarble -= num;
	}
	
	public static void main(String[] args) {
		Boy3 boy1 = new Boy3(50);
		Boy3 boy2 = new Boy3(40);
		
	}
	
	
	
		
		
	
	
}	

	
	

