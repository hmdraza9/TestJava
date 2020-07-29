package javaConcepts2;

public class LambdaClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewInterface ni = new NewInterface() { //calling class method through anonymous class
			@Override
			public String interfaceAbstractMethod(String str) {
				System.out.println(str);
				return str;
			}
		};
		
		String strNew = ni.interfaceAbstractMethod("Hello");
		System.out.println(strNew);

		NewInterface ni2 =					//calling through lambda
				(String str3) -> {return str3;};

				NewInterface ni3 =					//calling through lambda without any return value
						(String str3) -> {System.out.println("No value to return ni3");
											return "No Value ni3" ;};
				NewInterfaceNoReturnVal ni4 = 		//calling interface method with no input parameter(s)
						() -> {System.out.println("No Value for return/parameter ni4");};
				
			String lambdaString = ni2.interfaceAbstractMethod("Lambda String n2");
			System.out.println(lambdaString);
			
			lambdaString = ni3.interfaceAbstractMethod("Lambda String n3");
			System.out.println(lambdaString);
			
			ni4.interfaceAbstractMethod();
	}
}