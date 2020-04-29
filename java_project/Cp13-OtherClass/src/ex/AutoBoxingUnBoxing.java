package ex;

public class AutoBoxingUnBoxing {

	public static void main(String[] args) {

		Integer iValue = 10; //new Integer(10); -> Auto Boxing
		
		Double dValue = 3.14; //new Double(3.14); -> Auto Boxing
		
		System.out.println(iValue.toString());
		System.out.println(dValue.toString());
	
		int num1 = iValue;
		Double num2 = dValue;
		
		System.out.println(num1);  	// -> Auto UnBoxing
		System.out.println(num2);	// -> Auto UnBoxing

		
		
		
	}

}
