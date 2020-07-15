package javaConcepts;

class A {

	
	public void m1() {
		System.out.println("******A******");
	}
}

class B extends A {
	
	public void m1() {
		System.out.println("******B******");
	}
}

class C extends A {
	
	public void m1() {
		System.out.println("******C******");
	}
}

public class DynPolymorph {
	
	public static void main(String[] args) {
		A a = new A();
		a.m1();
		a = new B();
		a.m1();
		a = new C();
		a.m1();
	}
}