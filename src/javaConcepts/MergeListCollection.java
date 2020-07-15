package javaConcepts;

import java.util.ArrayList;
import java.util.List;

public class MergeListCollection {


	objectClass obj1 = new objectClass();
	objectClass obj2 = new objectClass();
	objectClass obj3 = new objectClass();
	objectClass obj4 = new objectClass();
	objectClass obj5 = new objectClass();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		listMethod();
	}
	
	public static void listMethod() {

		
		List<Integer> listA = new ArrayList<Integer>();
		List<Integer> listB = new ArrayList<Integer>();
		List<Integer> listC = new ArrayList<Integer>();
		listA.add(1);
		listA.add(2);
		listA.add(3);
		listA.add(4);
		listA.add(5);
		listB.add(4);
		listB.add(5);
		listB.add(6);
		listB.add(7);
		listB.add(8);
		listB.add(9);
		listB.add(10);
		listB.add(11);
		listB.add(11);
		listB.add(12);
		listB.add(13);
		
		for(int i=0;i<listA.size();i++) {
			listC.add(listA.get(i));
		}
		
		for(int j=0;j<listB.size();j++) {
			if(listC.contains(listB.get(j))) {
				System.out.println("Duplicate found! : value-->"+listB.get(j));
				listC.remove(listB.get(j));
				}
			else {
				listC.add(listB.get(j));
				}
			}
		System.out.println("ListC: "+listC);
	}
}


class objectClass{
	
	public void objectMethod(String str) {
		System.out.println("String: "+str);
	}
}