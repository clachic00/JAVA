package ex;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {

		// List<E> -> Arraylist<E>
		// List<E> : 저장순서를 가진다. 데이터의 중복 저장 가능
		// 순서 -> 일괄 처리(반복 적인 동일한 작업을 빠르게 처리)
	
		//인스턴스 생성 : Integer 타입의 객체만 저장
		ArrayList<Integer> list = new ArrayList<Integer>();
		//ArrayList<Integer> list = new ArrayList<>();     //뒤에 Integer생략가능
		//List<Integer> list = new ArrayList<>();			//다형성
		
		
		// List<E> 정의된 메서드 --> 
		// add(E) : 인스턴스의 저장,
		// remove(index) : 해당 index의 요소를 삭제
		// size() : List 요소의 개수를 반환
		// get(index) : 해당 index위치의 요소 반환
		
		// 데이터의 저장
		list.add(new Integer(10));
		list.add(new Integer(20));
		list.add(new Integer(30));
		list.add(40); //Auto Boxing
		list.remove(new Integer(10));
		System.out.println(list.get(1));
		System.out.println(list);
		System.out.println(list.size());
		
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		
		
		
		
		
		
	
	}

}
