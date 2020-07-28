package collectionClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SerializableClassExample {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		File file = new File(".//Data//SerializedObjectStoreFile.txt");
		
		List<String> list = new ArrayList<String>();
		for(int i=0;i<100;i++) {
			list.add("String"+i);
		}
		
		B B1 = new B(list);

		A a = new A(99, "newTextli58t2498tyi");
		A a1 = new A(100, "87ry4ohq8fujncoqiufh");
		A a2 = new A(101, "ioqurfp	2o;ijfkalk");
		A a3 = new A(102, "8ouiygoiuh9i34o2hri4913i2");
		A a4 = new A(103, "'l[e]qlwkf05oqu0go5iqr");
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(a);
		oos.writeObject(a1);
		oos.writeObject(a2);
		oos.writeObject(a3);
		oos.writeObject(a4);
		oos.writeObject(B1);
		fos.close();
		oos.close();
		
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		A b = (A)ois.readObject();
		A b1 = (A)ois.readObject();
		A b2 = (A)ois.readObject();
		A b3 = (A)ois.readObject();
		A b4 = (A)ois.readObject();
		B c1 = (B)ois.readObject();
		System.out.println(b3.i+", "+b3.str);
		System.out.println(b2.i+", "+b3.str);
		System.out.println(b4.i+", "+b4.str);
		System.out.println(b1.i+", "+b1.str);
		System.out.println(b.i+", "+b.str);
		for(String str:c1.list) {
			System.out.println(str);
		}
		
		fis.close();
		ois.close();
	}

}

class A implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int i;
	String str;
	public A(int a, String str) {
		this.i=a;
		this.str=str;
	}
}


class B implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<String> list;
	public B(List<String> list) {
		this.list = list;
	}
}