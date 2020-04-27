package leePhoneBook;
import java.util.Scanner;

public class PhoneBookManager {
   PhoneInfor infor;
   PhoneInfor[] pBooks;
   int cnt;
   Scanner sc;

   PhoneBookManager() {
      infor = new PhoneInfor();
      sc = new Scanner(System.in);

      pBooks = new PhoneInfor[100];
   }

   PhoneInfor createInstance() {

      System.out.println("이름을 입력하세요 : ");
      String name = sc.nextLine();
      System.out.println("전화번호를 입력하세요 : ");
      String phoneNumber = sc.nextLine();
      System.out.println("생년월일을 입력하세요 : ");
      String birthday = sc.nextLine();

      if (birthday.equals("") || birthday.trim().isEmpty()) {
         infor = new PhoneInfor(name, phoneNumber);

      } else {
         infor = new PhoneInfor(name, phoneNumber, birthday);
      }

      return infor;
   }

   void addInfo(PhoneInfor infor) {
      pBooks[cnt] = infor;
      cnt++;
      System.out.println("저장되었습니다.");

   }

   void addInfo() {
      pBooks[cnt] = createInstance();
      cnt++;
      System.out.println("저장되었습니다.");

   }

   void showAllData() {
      for (int i = 0; i < cnt; i++) {
         pBooks[i].showInfo();
         System.out.println("----------------------------");
      }

   }

   void searchInfo() {

      System.out.println("검색하시고자 하는 이름을 입력해주세요.");
      
      String searchingName = sc.nextLine();
      int searchIndex = -1;
      for (int i = 0; i < cnt; i++) {

         if (pBooks[i].checkName(searchingName)) {

            
            searchIndex = i;
            break;

         }

      }

      if (searchIndex >= 0) {
         pBooks[searchIndex].showInfo();
      }

      else {
         System.out.println("찾으시는 정보가 없습니다.");
      }

   }

   void deleteData() {
      System.out.println("삭제하시고자 하는 이름을 입력해주세요.");
      String searchName = sc.nextLine();
   
     

      int searchIndex = -1;
      for (int i = 0; i < cnt; i++) {

         if (pBooks[i].checkName(searchName)) {
            searchIndex = i;

            break;
         }
      }
      
      System.out.println("=================>   "+searchIndex);

      if (searchIndex < 0) {
         System.out.println("찾으시는 이름이 없습니다");

      } else {

         for (int deleteIndex = cnt-1; deleteIndex >= searchIndex; deleteIndex--) {

            pBooks[deleteIndex] = pBooks[deleteIndex + 1];

            if (deleteIndex == searchIndex) {
               System.out.println("삭제되었습니다");
               break;
            }

         }

         cnt--;

      }

   }

}