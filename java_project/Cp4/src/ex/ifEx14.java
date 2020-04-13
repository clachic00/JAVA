package ex;

public class ifEx14 {

	public static void main(String[] args) {

	//13.
		int i = 0;
		int j = 0;
		for (j = 2; j<=8; j++) {
			
			for(i=1; i<=9; i++ ) {
				if (!(j==2||j==4||j==8)) {
					continue;
				}
				if ((j+1==i)) {
					break;
				}
				
				
				
			System.out.println(j+"x"+i+"="+i*j);	
				
				
			}
		}
	
			
		
	}

}
