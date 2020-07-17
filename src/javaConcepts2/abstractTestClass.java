package javaConcepts2;

public class abstractTestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		testAbstract abs = new testAbstract();
		
	}

}

abstract class testAbstract{
	
	abstract public void methodWithoutBody();
	
	public void methodWithBody() {
		System.out.println("method with body");
	}
}


interface  testNewInterface{
	
	public void methodWithoutBody1();
	
	public void methodWithoutBody2();
}