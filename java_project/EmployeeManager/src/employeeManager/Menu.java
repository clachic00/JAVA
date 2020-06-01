package employeeManager;

public class Menu {

	public static void showEmpMenu() {
	
		
		
		System.out.println("=============================");
		System.out.println("메뉴를 입력해주세요.");
		System.out.println(""+MenuInterface.INSERT+". 사원 정보 입력");
		System.out.println(""+MenuInterface.SEARCH+". 사원 정보 검색");
		System.out.println(""+MenuInterface.DELETE+". 사원 정보 삭제");
		System.out.println(""+MenuInterface.EDIT+". 사원 정보 수정");
		System.out.println(""+MenuInterface.SHOWALL+". 사원 정보 전체 보기");
		System.out.println(""+MenuInterface.EXIT+". 프로그램 종료");
		System.out.println("=============================");
		
	
	}
	
	
	public static void showDeptMenu() {
		System.out.println("=============================");
		System.out.println("메뉴를 입력해주세요.");
		System.out.println(""+MenuInterface.INSERT+". 부서 정보 입력");
		System.out.println(""+MenuInterface.SEARCH+". 부서 정보 검색");
		System.out.println(""+MenuInterface.DELETE+". 부서 정보 삭제");
		System.out.println(""+MenuInterface.EDIT+". 부서 정보 수정");
		System.out.println(""+MenuInterface.SHOWALL+". 부서 정보 전체 보기");
		System.out.println(""+MenuInterface.EXIT+". 프로그램 종료");
		System.out.println("=============================");
	}
	
	
	
	
	
	
	
	
}
