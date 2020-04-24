package ex;

public class Friend{
	
	// 친구의 정보를 저장하기 위한 클래스
	// 
	
	
	
	
	
String myName;
public Friend(String name)
{
myName=name;
}

public String toString()
{
return "제 이름은 "+myName+"입니다.";
}
public static void main(String[] args)
{
Friend fnd1=new Friend("이종수");
Friend fnd2=new Friend("현주은");
System.out.println(fnd1);
System.out.println(fnd2);
}

}
