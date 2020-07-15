package javaConcepts;

public class TrimFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String str = "  >hello hi< .  ";
		System.out.print(TrimeFunction(str));
//		TrimeFunction(str).notify();
		TrimeFunction(str).intern();
		System.out.println(TrimeFunction(str).repeat(3));
		System.out.println("hi".lines());
		System.out.println("aa".getBytes());
		
		
		
	}
	
	public static String TrimeFunction(String rawString) {
		return rawString.trim();
	}
}