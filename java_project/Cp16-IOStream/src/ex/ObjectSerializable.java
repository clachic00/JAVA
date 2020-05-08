package ex;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectSerializable {

	public static void main(String[] args) throws IOException {
		//기본스트림
		FileOutputStream fo = new FileOutputStream("Object.ser");
		//객체저장 필터 스트림
		ObjectOutputStream out = new ObjectOutputStream(fo);
		
	
		
		out.writeObject(new Circle(1, 2, 1.2));
		out.writeObject(new Circle(3, 6, 3.6));
		out.writeObject(new String("String implements Serializable"));
		out.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
