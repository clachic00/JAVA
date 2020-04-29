package version05;

public class Menu {

	public static void showMenu() {
		System.out.println("=============================");
		System.out.println("메뉴를 입력해주세요.");
		System.out.println(""+MenuInterface.INSERT+". 친구 정보 입력");
		System.out.println(""+MenuInterface.SEARCH+". 친구 정보 검색");
		System.out.println(""+MenuInterface.DELETE+". 친구 정보 삭제");
		System.out.println(""+MenuInterface.EDIT+". 친구 정보 수정");
		System.out.println(""+MenuInterface.SHOWALL+". 친구 정보 전체 보기");
		System.out.println(""+MenuInterface.EXIT+". 프로그램 종료");
		System.out.println("=============================");
		
	
	}
	
	
	
}
