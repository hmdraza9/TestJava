package collectionClasses;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableClassExample {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		A a = new A(99, "newTextli58t2498tyi");
		A a1 = new A(100, "87ry4ohq8fujncoqiufh");
		A a2 = new A(101, "ioqurfp	2o;ijfkalk");
		A a3 = new A(102, "8ouiygoiuh9i34o2hri4913i2");
		A a4 = new A(103, "'l[e]qlwkf05oqu0go5iqr");
		FileOutputStream fos = new FileOutputStream(".//Data//SerializedObjectFile.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(a);
		oos.writeObject(a1);
		oos.writeObject(a2);
		oos.writeObject(a3);
		oos.writeObject(a4);
		oos.close();
		
		FileInputStream fis = new FileInputStream(".//Data//SerializedObjectFile.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		A b = (A)ois.readObject();
		A b1 = (A)ois.readObject();
		A b2 = (A)ois.readObject();
		A b3 = (A)ois.readObject();
		A b4 = (A)ois.readObject();
		System.out.println(b3.i+", "+b3.str);
		System.out.println(b2.i+", "+b3.str);
		System.out.println(b4.i+", "+b4.str);
		System.out.println(b1.i+", "+b1.str);
		System.out.println(b.i+", "+b.str);
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