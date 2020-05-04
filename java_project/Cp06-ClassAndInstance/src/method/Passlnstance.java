package method;

public class Passlnstance {

	public static void main(String[] args)
	{
	Number nInst=new Number();
	System.out.println("메소드 호출 전: "+nInst.getNumber());
	simpleMethod(nInst);
	System.out.println("메소드 호출 후: "+nInst.getNumber());
	}
	public static void simpleMethod(Number numb)
	{
	numb.addNum(12);
	}
	
	}


