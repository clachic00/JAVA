package ex;

import javax.swing.JOptionPane;

public class ThreadMain3 {

	public static void main(String[] args) {

		String input = JOptionPane.showInputDialog("사용자의 이름을 입력하세요.");
		
		System.out.println("입력하신 값은 : "+input+"입니다.");
		
		System.out.println(input);
	
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
		for(int i=10; i>0; i--) {
			System.out.println(i);
		}
		
		System.out.println(input);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
