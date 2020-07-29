package javaConcepts2;

public class InnerClass_n_MethodExample {
	
	InnerClass_n_MethodExample ine = new InnerClass_n_MethodExample();
	nestedClass nc = new nestedClass();
	nestedClass2 nc2 = new nestedClass2();
	nestedClass3 nc3 = new nestedClass3();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InnerClass_n_MethodExample.outerClassMethod();
		nestedClass.innerClassMethod();//static class and static method
		nestedClass2.innerClassMethod2();//static method only
	}
	
	private static void outerClassMethod() {
		System.out.println("I am in outer class method");
	}

	
	private void nonStaticOuterClassMethod() {
		System.out.println("I am in outer class method");
		nc3.innerClassMethod3(); //non static class, non static method
	}

	public static class nestedClass{
		public static void innerClassMethod() {
			System.out.println("I am in inner class method");
			outerClassMethod();
		}
	}

	public static class nestedClass2{
		public static void innerClassMethod2() {
			System.out.println("I am in inner class method2");
			outerClassMethod();
		}
	}

	class nestedClass3{
		public void innerClassMethod3() {
			System.out.println("I am in inner class method3");
			nonStaticOuterClassMethod();
		}
	}
}
