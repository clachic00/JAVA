package extest;

public class InstanceOf {

	public static void wrapBox(Box t) {

		t.wrap();
		
//		if (t instanceof GoldPaperBox)
//			((GoldPaperBox) t).goldWrap();
//
//		else if (t instanceof PaperBox)
//			((PaperBox) t).paperWrap();
//
//		else
//			t.simpleWrap();
	}

	public static void main(String[] args) {
		Box box1 = new Box();
		PaperBox box2 = new PaperBox();
		GoldPaperBox box3 = new GoldPaperBox();
		wrapBox(box1);
		wrapBox(box2);
		wrapBox(box3);
	}
}