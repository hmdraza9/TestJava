package uTilities;

import java.util.Arrays;

public class Asdsd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] array1 = System.getProperty("user.dir").split("\\\\");
		System.out.println(Arrays.asList(System.getProperty("user.dir").split("\\\\")).get(array1.length-1));
		
	}

}
