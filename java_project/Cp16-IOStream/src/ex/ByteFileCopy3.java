package ex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteFileCopy3 {

	public static void main(String[] args) throws FileNotFoundException {

		InputStream in = null;

		//
		OutputStream out = null;

		int copyByte = 0;
		int bData;
		byte buf []  = new byte[1024];
		
		try {

			in = new FileInputStream("test.txt");

			out = new FileOutputStream("copy.txt");
			
			
			
			while (true) {
				bData = in.read(buf);
				if (bData == -1) {
					break;

				}
				out.write(buf, 0, 10);
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
				in.close();
				out.close();
				System.out.println("복사된 바이트 크기" + copyByte);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

}
