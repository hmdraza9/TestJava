package javaConcepts2;

interface testInterface {

	void myAbstractMethod(int x);
	
	default void someMethod() {
		System.out.println("Hello");
	}
	
	
}

public class LambdaLearnTesting{
	
	public static void main(String[] args) {
		testInterface obj = (int y)->System.out.println(2*y);
		obj.someMethod();
		obj.myAbstractMethod(5);
	}
}
