package ex;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public static void main(String[] args)
	{
	//HashSet<String> hSet=new HashSet<String>();
	HashSet<String> hSet = new HashSet<>();
	
	hSet.add("First");
	hSet.add("Second");
	hSet.add("Third");
	hSet.add("First");
	System.out.println("저장된 데이터 수: "+hSet.size());
	
	Iterator<String> itr = hSet.iterator();
	
	while(itr.hasNext())
		System.out.println(itr.next());
	
	
	
	
	
	
	}


}
