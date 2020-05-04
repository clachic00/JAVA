package arrayPractice;

public class InstanceArray {

	public static void main(String[] args) {


		String[] strArray = new String[3];
		
		strArray[0] = "JAVA";
		strArray[1] = "JS";
		strArray[2] = "Python";
		
		// String 타입의 참조변수 -> strArray[0]
		
		System.out.println("문자열의 길이  : " + strArray[0].length());
		System.out.println("문자열의 toString() : "+ strArray[2].toString());
		
		//배열의 순차적 참조: 반복문을 이용해서 순차 참조가능
		
		for(int i = 0; i<strArray.length; i++) {
			System.out.println(strArray[i]);
		}
		
		
		
	}

}
