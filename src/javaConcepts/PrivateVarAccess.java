package javaConcepts;

public class PrivateVarAccess extends accessByExtend{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		accessByObj obj = new accessByObj();
		accessByExtend obj1 = new accessByExtend();
		PrivateVarAccess obj2 = new PrivateVarAccess();
		int k = obj.prot1;
//		System.out.println(k);
		k=obj.getProt1();
//		System.out.println(k);
		k=obj.getVar1();
//		System.out.println(k);

//		System.out.println(pub1); //can't access, static reference to non-static field
//		System.out.println(prot1); //can't access, static reference to non-static field
//		System.out.println(pub1); //can't access, static reference to non-static field		
		obj2.accessVariables();
	}
	
	public void accessVariables() {
		System.out.println(getVar1());
	}
}

class accessByObj{

	private int var1=10; //private, not accessible either through class object or inheritance
	public int pub1=11;
	private int var2=12;
	private int var3=13;
	protected int prot1=13;
	private String var4= "test String";


	public int getVar1() {
		return var1;
	}
	
	public int getVar2() {
		return var2;
	}

	public int getVar3() {
		return var3;
	}

	public String getVar4() {
		return var4;
	}

	public int getProt1() {
		return prot1;
	}

	public int getPub1() {
		return pub1;
	}
}

class accessByExtend{

	private int var1=10;
	public int pub1=11;
	private int var2=12;
	private int var3=13;
	protected int prot1=13;
	private String var4= "test String";


	public int getVar1() {
		return var1;
	}
	
	public int getVar2() {
		return var2;
	}

	public int getVar3() {
		return var3;
	}

	public String getVar4() {
		return var4;
	}

	public int getProt1() {
		return prot1;
	}
}