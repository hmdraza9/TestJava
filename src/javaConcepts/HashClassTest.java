package javaConcepts;

public class HashClassTest {
	
	String str;
	
	
	HashClassTest(String str2){
		System.out.println("hello "+str2);
		this.str="I am str";		
	}
	
	HashClassTest(){};
	
	@Override
	public int hashCode() {
		return 301;
	}
	
	public void testMethod() {
		System.out.println("Hi I am test function");
	}
	
	
	public static void main(String[] args) {
		HashClassTest hct = new HashClassTest("testParam");
		HashClassTest hct1 = new HashClassTest();
		System.out.println(hct);
		System.out.println(hct.toString());
		
		System.out.println(hct.equals(hct1));
		
		System.out.println(hct.str);
	}
}
