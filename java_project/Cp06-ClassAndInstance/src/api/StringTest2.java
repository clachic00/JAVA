package api;

public class StringTest2 {

	public static void main(String[] args) {
		//1.
		StringBuffer str = new StringBuffer("ABCDEFGHIJKLMN");
		
		 str.reverse();
		
		System.out.println(str);
		
		//2.
		
		String str2 = "990929-1010123";
		
		String str3 = str2.replace("-", "");
		
		System.out.println(str3);
		
		
		
		
	}

}
