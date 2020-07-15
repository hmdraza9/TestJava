package javaConcepts;

interface Animal {

	void Child();
//	void Legs() {}
}

abstract class Brick{
	void LargeBuilding() {
		System.out.println("Palace");
	}
	abstract void SmallBuilding();
}

class m1 extends Brick{

	void SmallBuilding() {
		System.out.println("House");
	}
	void LargeBuilding() {
		System.out.println("Villa");
	}
	
}


class m2 extends Brick{

	void SmallBuilding() {
		System.out.println("Apartment");
	}
	void LargeBuilding() {
		System.out.println("Estate");
	}
	
}

class Cat implements Animal {

	public void Child() {
		System.out.println("Kitten");
	}
	
}

class Dog implements Animal{

	@Override
	public void Child() {
		System.out.println("Puppy");
	}
}

class Lion implements Animal{

//	@Override
	public void Child() {
		System.out.println("Cub");
	}
}


public class looseCoupling {
	
	public static void main(String[] args) {

		Animal obj = new Cat();
		obj.Child();
		obj = new Dog();
		obj.Child();
		obj = new Lion();
		obj.Child();
		
		Brick obj2 = new m1();
		obj2.LargeBuilding();
		obj2.SmallBuilding();
		obj2=new m2();
		obj2.LargeBuilding();
		obj2.SmallBuilding();
	}
}