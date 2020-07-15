package javaConcepts2;

public class ImmutableTesting {
	
	public static void main(String[] args) {
		String str = "first";
		System.out.println(str.hashCode());
		System.out.println(str.hashCode());
		str = str + " second";
		System.out.println(str.hashCode());
		System.out.println(str.hashCode());
		StringBuilder sb = new StringBuilder("first");
		System.out.println(sb.hashCode());
		sb = sb.append(" second");
		System.out.println(sb.hashCode());

//		privateConstructorClass obj = new privateConstructorClass();
		
	}
}


class privateConstructorClass{
	
	private privateConstructorClass() {
		int x = 10;
	}
}