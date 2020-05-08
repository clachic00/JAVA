package ex;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteFileCopy4 {

	public static void main(String[] args) throws FileNotFoundException {

		InputStream in = null;

		//
		OutputStream out = null;

		
		
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		int copyByte = 0;
		int bData;

		
		
		try {
		
		
		in = new FileInputStream("test.txt");

		out = new FileOutputStream("copy.txt");
		
		
		 bin = new BufferedInputStream(in);
		 bout = new BufferedOutputStream(out);
		
		
		
		

			while (true) {
				bData = in.read();
				if (bData == -1) {
					break;

				}
				out.write(bData);
				copyByte++;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				
				bin.close();
				bout.close();
				
				System.out.println("복사된 바이트 크기" + copyByte);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

}
