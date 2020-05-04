package ex;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
			
		//HashMap<Integer, String> map = new HashMap<Integer, String>();
		//HashMap<Integer, String> map = new HashMap<>();
		Map<Integer, String> map = new HashMap<Integer, String>();

		
		//입력
		map.put(1, "일번");
		map.put(2, "이번");
		map.put(3, "삼번");
		map.put(2, "팔번");
		
		
		//참조
		System.out.println("1번 학생의 이름은 : "+map.get(1));
		System.out.println("2번 학생의 이름은 : "+map.get(2));
		System.out.println("3번 학생의 이름은 : "+map.get(3));
		System.out.println("8번 학생의 이름은 : "+map.get(8));
		
		
		//삭제
		
		map.remove(8);
		
		System.out.println("\n8번학생 삭제");
		System.out.println("8번 학생의 이름은 : "+map.get(8));
		

		//원래있던 값대신 들어감
		//key 값은 중복허용이 되지않는다.
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
