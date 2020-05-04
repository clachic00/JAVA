package ex;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest2 {

	public static void main(String[] args) {
		// HashSet<String> hSet=new HashSet<String>();
		HashSet<SimpleNumber> hSet = new HashSet<>();

		hSet.add(new SimpleNumber(10));
		hSet.add(new SimpleNumber(20));
		hSet.add(new SimpleNumber(10));

		System.out.println("저장된 데이터 수: " + hSet.size());

		Iterator<SimpleNumber> itr = hSet.iterator();

		while (itr.hasNext())
			System.out.println(itr.next());

	}

}

class SimpleNumber {
	int num;

	public SimpleNumber(int num) {
		this.num = num;
	}

	public String toString() {
		return String.valueOf(num);

	}

	// HashSet 의 동등 비교 과정
	// 1. hash 코드를 비교해서 같은 hash 코드를 가진 객체를 기반으로 비교
	// 2. equals 메서드로 비교

	@Override
	public int hashCode() {

		return num % 3;

	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;

		if (obj instanceof SimpleNumber) {
			SimpleNumber sm = (SimpleNumber) obj;

			result = this.num == sm.num;
		}

		return result;
	}

}