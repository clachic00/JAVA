package personalNumberStorage;

public class AbstractInterfaceMain {

	public static void main(String[] args) {
	
		
		
	PersonalNumber storage =  new PersonalNumberStorageImpl(100);
		//PersonalNumber storage=new PersonalNumberStorageImpl(100);
		
		
		
		
		
		
		
		
				storage.addPersonalInfo("손흥민", "950000-1122333");
				storage.addPersonalInfo("박지성", "970000-1122334");
				System.out.println(storage.searchName("박지성"));
				System.out.println(storage.searchName("박지성"));
	}

}
