package phonenumber;

public class MachineOfPhoneNumber {

	int i = 0;
	String name;
	String phoneNumber;
	String birthday;
	String  PhoneInfor[][] = new String[100][3];
	MachineOfPhoneNumber(String n, String num) {
		name = n;
		phoneNumber = num;
		birthday = "000000";

	}

	MachineOfPhoneNumber(String n, String num, String birth) {
		name = n;
		phoneNumber = num;
		birthday = birth;

	}
	
	
	void Save(MachineOfPhoneNumber info){

			
			PhoneInfor[i][0] = info.name;
			PhoneInfor[i][1] = info.phoneNumber;
			PhoneInfor[i][2] = info.birthday;
			
			i=i+1;
			
			

			
			
		}
	
		String ShowInfor( int a, int b){
			
			
			String result = PhoneInfor[a][b];
		
			return result;
		}
		
		
	}
	
	

