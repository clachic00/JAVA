package ex;

import javax.swing.JOptionPane;

public class ThreadMain4 {

	public static void main(String[] args) {

		
		CountThread ct = new CountThread();
		
		ct.start();
		
		
		String input = JOptionPane.showInputDialog("사용자의 이름을 입력하세요.");
		
		
		
		
		System.out.println("입력하신 값은 : "+input+"입니다.");
		
		System.out.println(input);
	
			
		
		
		
		
	}

}
