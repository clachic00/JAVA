package phonenumber;

public class MachineOfPhoneNumber {

	
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

	void Save(MachineOfPhoneNumber inf){
		
		String nameInfo="";
		String numberInfo="";
		String birthInfo="";
		int i = 0;
		while(true) {
			
			
			nameInfo = inf.name;
			numberInfo = inf.phoneNumber;
			birthInfo = inf.birthday;
			
			PhoneInfor[i][0] = nameInfo;
			PhoneInfor[i][1] = numberInfo;
			PhoneInfor[i][2] = birthInfo;
			
			
			
			
			if (i==99) {
				break;
			}
			
			
		}
	}
		String ShowInfor( int a, int b){
			
			
			String result = PhoneInfor[a][b];
		
			return result;
		}
		
		
	}
	
	

