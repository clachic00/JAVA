package PhoneBookVer7;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PhoneBookManager {

	PhoneBookDao dao = new PhoneBookDao();
	Scanner sc = new Scanner(System.in);
	
	
	public void PhoneBookManager() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("PhoneBook Manager Menu");
		System.out.println("=========================================");
		System.out.println("1. List  2. Insert  3. Search  4. Delete  5. Edit 6. Exit ");
		System.out.println("=========================================");

		int select = sc.nextInt();

		switch (select) {
		case 1:
			System.out.println("리스트 출력");
			pbList();
			break;
		case 2:
			System.out.println("연락처 정보를 입력합니다");
			pbInsert();
			break;
		case 3:
			System.out.println("연락처 정보를 검색합니다.");
			pbSearch();
			break;
		case 4:
			System.out.println("연락처 정보를 삭제합니다.");
			pbDelete();
			break;
		case 5:
			System.out.println("연락처 정보를 수정합니다.");
			pbEdit();
			break;

		case 6:
			System.out.println("종료합니다.");
			System.exit(0);
		}

	}
	
	
	public void pbEdit() {

		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();

			conn.setAutoCommit(false); // 기본값은 true : 자동 커밋

			// 1. 수정하고자 하는 데이터 유무 확인 -> 2.사용자로부터 데이터 받아서 전달

			// 사용자 입력정보 변수

			System.out.println("수정하고자 하는 부서 이름 : ");
		//	sc.nextLine();
			String searchName = sc.nextLine();

			// 1. 수정하고자 하는 데이터 유무 확인
			int rowCnt = dao.pbSearchCount(searchName, conn);
			// System.out.println(rowCnt);

			if (rowCnt > 0) {

				PhoneBook pb = dao.pbSearchName(searchName, conn);

				if (pb == null) {
					System.out.println("찾으시는 이름의 정보가 존재하지않습니다.");
					return;
				}

				// 사용자 입력정보 변수
				System.out.println("부서 정보를 입력해주세요.");

				System.out.println("인덱스 번호 : " + pb.getPidx());
				System.out.println("인덱스 번호는 수정되지 않습니다.");

				System.out.println("부서 이름 ( " + pb.getPbname() + "  ) : ");
				String pbname = sc.nextLine();
				System.out.println("부서 이름 ( " + pb.getPbnumber() + "  ) : ");
				String pbnumber = sc.nextLine();
				System.out.println("지역 ( " + pb.getPbaddr() + "  ) : ");
				String pbaddr = sc.nextLine();
				System.out.println("부서 이름 ( " + pb.getPbemail() + "  ) : ");
				String pbemail = sc.nextLine();
				System.out.println("부서 이름 ( " + pb.getPbmajor() + "  ) : ");
				String pbmajor = sc.nextLine();
				System.out.println("부서 이름 ( " + pb.getPbyear() + "  ) : ");
				int pbyear = sc.nextInt();
				sc.nextLine();
				System.out.println("부서 이름 ( " + pb.getPbcompany() + "  ) : ");
				String pbcompany = sc.nextLine();
				System.out.println("부서 이름 ( " + pb.getPbjob() + "  ) : ");
				String pbjob = sc.nextLine();
				System.out.println("부서 이름 ( " + pb.getPbcafename() + "  ) : ");
				String pbcafename = sc.nextLine();
				System.out.println("부서 이름 ( " + pb.getPbnickname() + "  ) : ");
				String pbnickname = sc.nextLine();

				// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

				PhoneBook newPb = new PhoneBook(pb.getPidx(), pbname, pbnumber, pbaddr,  pbemail,  pbmajor,
						 pbyear,  pbcompany,  pbjob,  pbcafename,  pbnickname);

				int resultCnt = dao.pbEdit(newPb, conn);

				if (resultCnt > 0) {
					System.out.println("정상적으로 수정 되었습니다.");
					System.out.println(resultCnt + "행이 수정되었습니다.");
				} else {
					System.out.println("수정이 되지않았습니다. 확인후 재 시도해주세요.");
				}

			} else {
				System.out.println("찾으시는 이름의 정보가 존재하지않습니다.");
			}
			


			conn.commit();
			
			

		} catch (SQLException e) {
			
			if(conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.println("conn.close()");
					e1.printStackTrace();
				}
			}
			
			
			
			e.printStackTrace();
		}

	}

	public void pbInsert() {

		// 사용자 입력정보 변수
		System.out.println("부서 정보를 입력해주세요.");

		System.out.println("부서번호 : ");
		int deptno = sc.nextInt();
		System.out.println("부서이름 : ");
		sc.nextLine();
		String dname = sc.nextLine();
		System.out.println("지역 : ");
		String loc = sc.nextLine();

		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

		PhoneBook pb = new PhoneBook();

		int resultCnt = dao.pbInsert(pb);

		if (resultCnt > 0) {
			System.out.println("정상적으로 입력 되었습니다.");
			System.out.println(resultCnt + "행이 입력되었습니다.");
		} else {
			System.out.println("입력이 되지않았습니다. 확인후 재 시도해주세요.");
		}

	}

	public void pbDelete() {

		// 사용자 입력정보 변수

		System.out.println("삭제하고자 하는 부서이름 : ");
		sc.nextLine();
		String searchName = sc.nextLine();

		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

		int resultCnt = dao.pbDelete(searchName);

		if (resultCnt < 1) {
			System.out.println("삭제할 정보가 검색 결과가 없습니다.");
		} else {
			System.out.println(resultCnt + "행이 삭제 되었습니다.");
		}

		System.out.println("=================================");

	}

	public void pbSearch() {

		// 사용자 입력정보 변수

		System.out.println("검색하고자 하는 부서이름 : ");
		sc.nextLine();
		String searchName = sc.nextLine();

		List<PhoneBook> list = dao.pbSearch(searchName);

		System.out.println("검색 결과");
		System.out.println("======================================");
		for (PhoneBook pb : list) {
			System.out.printf("%12s", pb.getPidx() + "\t");
			System.out.printf("%12s", pb.getPbname() + "\t");
			System.out.printf("%12s", pb.getPbnumber() + "\t");
			System.out.printf("%12s", pb.getPbaddr() + "\t");
			System.out.printf("%12s", pb.getPbemail() + "\t");
			System.out.printf("%12s", pb.getPbmajor() + "\t");
			System.out.printf("%12s", pb.getPbyear() + "\t");
			System.out.printf("%12s", pb.getPbcompany() + "\t");
			System.out.printf("%12s", pb.getPbjob() + "\t");
			System.out.printf("%12s", pb.getPbcafename() + "\t");
			System.out.printf("%12s", pb.getPbnickname() + "\n");
		}
		System.out.println("======================================");

	}

	public void pbList() {

		List<PhoneBook> pbList = dao.pbList();

		if (pbList != null && !pbList.isEmpty()) {

			for (int i = 0; i < pbList.size(); i++) {
				
				
				
				System.out.printf("%12s", pbList.get(i).getPidx() + "\t");
				System.out.printf("%12s", pbList.get(i).getPbname() + "\t");
				System.out.printf("%12s", pbList.get(i).getPbnumber() + "\t");
				System.out.printf("%12s", pbList.get(i).getPbaddr() + "\t");
				System.out.printf("%12s", pbList.get(i).getPbemail() + "\t");
				System.out.printf("%12s", pbList.get(i).getPbmajor() + "\t");
				System.out.printf("%12s", pbList.get(i).getPbyear() + "\t");
				System.out.printf("%12s", pbList.get(i).getPbcompany() + "\t");
				System.out.printf("%12s", pbList.get(i).getPbjob() + "\t");
				System.out.printf("%12s", pbList.get(i).getPbcafename() + "\t");
				System.out.printf("%12s", pbList.get(i).getPbnickname() + "\n");
				
	
				
				

			}
		} else {
			System.out.println("입력된 데이터가 없습니다.");
		}

	}

	
	
	
}
