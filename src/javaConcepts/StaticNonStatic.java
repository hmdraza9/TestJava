package javaConcepts;

class demoOne {

	
	int num1 ;
	static int num2;
	
	public static void increment() {
		num2++;
	}
}

public class StaticNonStatic{
	
	public static void main(String[] args) {

		demoOne obj1 = new demoOne();
		demoOne obj2 = new demoOne();
		demoOne obj3 = new demoOne();
		demoOne obj4 = new demoOne();


//		System.out.println(obj4.num1);
		
		obj1.num1=2;
		obj2.num1=3;
		obj3.num1=4;

		System.out.println(++obj1.num1);
		System.out.println(obj2.num1);
		demoOne.increment();
		System.out.println(obj3.num1);
		System.out.println(obj4.num1);
		
		demoOne.num2=5;
		
		System.out.println(demoOne.num2++);
		System.out.println(obj1.num2*=2);
		System.out.println(obj2.num2);
		updateStatic();
		System.out.println(obj3.num2);
		System.out.println(obj4.num2);
		
	}
	
	public static void updateStatic() {
		demoOne.num2++;
//		System.out.println(demoOne.num2);
	}
	
}
