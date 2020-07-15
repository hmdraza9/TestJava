package javaConcepts;

 class Jaanvar {
	 
	public void nAme() {
		System.out.println("Animal");
	}
}


class Fish extends Jaanvar{

	String colour="aaa";
	public void nAme() {
		
		System.out.println("Aquatic animal");
	}
}

public class finalClass{
	public static void main(String[] args) {
		Jaanvar a = new Jaanvar();
		a.nAme();
		Jaanvar b = new Fish();
		b.nAme();
		Fish c = new Fish();
		c.colour="White";	
		System.out.println("a.getClass()"+a.getClass());
	}
}