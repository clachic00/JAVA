package ex;

public class RuntimeExceptionCase {

	public static void main(String[] args) {

		
		try {
			
			int[] arr = new int[3];
			arr[-1]=20;
			
		} catch (ArrayIndexOutOfBoundsException e){{
			
			System.out.println(e.getMessage());
			
		}
		
		
		try {
			
			Object obj = new int[10];
			String str = (String)obj;
			
		} catch(ClassCastException e1) {
			System.out.println(e1.getMessage());
		}
		
		
		
		
		
		try { int[] arr = new int[-10];
		
		} catch(NegativeArraySizeException e1) {
			
			System.out.println(e1.getMessage());
		}
		
		
		try {
			String str =null;
					int len =str.length();
			
		} catch (NullPointerException e1) {
			System.out.println(e1.getMessage());
		}
	
	
	
	
	
	}
	}
}
