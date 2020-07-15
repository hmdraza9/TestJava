package javaConcepts2;

import java.util.ArrayList;

public class TestGenerics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		List values = new ArrayList();
//		values.add(5);
//		values.add("Hello");
//		System.out.println(values.get(0));
//		System.out.println(values.get(1));
//		try {
//			System.out.println(Integer.parseInt(values.get(0).toString()));
//			System.out.println(Integer.parseInt(values.get(1).toString()));
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Exception: NumberFormatException");
//		}
		
		Container<Float> itemList = new Container<>();
//		itemList.item=9;
		itemList.show();
		itemList.demo(new ArrayList<Integer>());
		
		
	}

}


class Container<E extends Number>{
	
	E item;
	
	public void show() {
		System.out.println(item.getClass().getName());
	}
	public void demo(ArrayList<Integer> obj) {
		
	}
}

