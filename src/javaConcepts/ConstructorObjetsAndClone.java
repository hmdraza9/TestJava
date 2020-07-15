package javaConcepts;

public class ConstructorObjetsAndClone {
	
	int x, y;
	
	ConstructorObjetsAndClone(int x, int y){
		this.x = x =10;
		this.y = y =20;
	}
	

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		
		//refer URL https://www.geeksforgeeks.org/clone-method-in-java-2/

//		Constructor2 c2 = new Constructor2(1,2);
//		System.out.println(c2.x); //10
//		System.out.println(c2.y); //20
		
//		classB clB = new classB();
//		clB.clA.x=10;
//		System.out.println("clB.clA.x:     "+clB.clA.x); //10
//		classC clC = new classC();
//		clC.clB.clA.x=30;
//		System.out.println("clC.clB.clA.x: "+clC.clB.clA.x); //30
//		System.out.println("clB.clA.x:     "+clB.clA.x); //10
//		clB.clA.x=40;
//		System.out.println("clB.clA.x:     "+clB.clA.x); //40
		
		classC c1 = new classC();
		c1.x=10;
		c1.y=20;
		c1.clB.x=11;
		c1.clB.y=21;
		c1.clB.clA.x=12;
		c1.clB.clA.y=22;
		

		classC c2 = (classC)c1.clone();

		c2.x=80;
//		c2.y=90;
		c2.clB.x=81;
		c2.clB.y=91;
//		c2.clB.clA.x=82;
		c2.clB.clA.y=92;

		classC c3 = new classC();

		c3.x=40;
		c3.y=50;
		c3.clB.x=41;
		c3.clB.y=51;
		c3.clB.clA.x=42;
		c3.clB.clA.y=52;
		

		System.out.println("C1:");
		System.out.println("c1.x: "+c1.x);
		System.out.println("c1.y: "+c1.y);
		System.out.println("c1.clB.x: "+c1.clB.x);
		System.out.println("c1.clB.y: "+c1.clB.y);
		System.out.println("c1.clB.clA.x: "+c1.clB.clA.x);
		System.out.println("c1.clB.clA.y: "+c1.clB.clA.y+"\n\n");

		System.out.println("C1:");
		System.out.println("c1.x: "+c1.x);
		System.out.println("c1.y: "+c1.y);
		System.out.println("c1.clB.x: "+c1.clB.x);
		System.out.println("c1.clB.y: "+c1.clB.y);
		System.out.println("c1.clB.clA.x: "+c1.clB.clA.x);
		System.out.println("c1.clB.clA.y: "+c1.clB.clA.y+"\n\n");

		System.out.println("c2 clone of c1:");
		System.out.println("c2.x: "+c2.x);
		System.out.println("c2.y: "+c2.y);
		System.out.println("c2.clB.x: "+c2.clB.x);
		System.out.println("c2.clB.y: "+c2.clB.y);
		System.out.println("c2.clB.clA.x: "+c2.clB.clA.x);
		System.out.println("c2.clB.clA.y: "+c2.clB.clA.y+"\n\n");

		System.out.println("c3:");
		System.out.println("c3.x: "+c3.x);
		System.out.println("c3.y: "+c3.y);
		System.out.println("c3.clB.x: "+c3.clB.x);
		System.out.println("c3.clB.y: "+c3.clB.y);
		System.out.println("c3.clB.clA.x: "+c3.clB.clA.x);
		System.out.println("c3.clB.clA.y: "+c3.clB.clA.y+"\n\n");

		
	}

}


class classA{

	int x,y;
}

class classB{

	int x,y;
	
	classA clA = new classA();
}

class classC implements Cloneable{

	int x,y;
	
	classB clB = new classB();
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}