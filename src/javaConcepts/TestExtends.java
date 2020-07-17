package javaConcepts;

import org.testng.annotations.Test;
import java.io.IOException;

public class TestExtends {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		class2 cl = new class2();
		cl.commonMethod();
		int a=1;
		int b=2;

		b=a+b;
		System.out.println("b=a+b: "+b);
		b+=a;
		System.out.println("b=a+b: "+b);
		b+=10;
		System.out.println("b=a+b: "+b);
		
	}

}

class class1{
	
	public void commonMethod() {
		System.out.println("class1 Method called...");
	}
	int a = 1000;
}

class class2 extends class1{


	int a = 1001;
	public void commonMethod() {
		System.out.println("class2 Method called...");
		System.out.println("a: "+a);
		System.out.println("super a: "+super.a);
	}
	
}


abstract class testAbstract {
	
	@Test
	public void test1() {
		
		System.out.println();
		
	}
}