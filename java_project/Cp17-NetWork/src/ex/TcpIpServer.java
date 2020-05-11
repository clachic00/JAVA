package ex;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpIpServer {

	public static void main(String[] args) {

		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("소켓 서버가 준비되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (true) {
			System.out.println("연결 요청을 기다립니다.");

			try {
				// 요청이 들어오면 연결 소켓 생성
				Socket socket = serverSocket.accept();
				System.out.println(socket.getInetAddress() + "로 부터 연결 요청이 들어왔습니다.");

				// 출력스트림을 socket 로부터 받는다.
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);

				// 클라이언트 소켓으로 데이터 전송
				dos.writeUTF("[Notice] Test Messege from Server");
				System.out.println("데이터를 전송했습니다.");

				dos.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
