package javaConcepts2;

public class CompareTwoStringsClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "Sea";
		String str2 = "Sea";
		
		System.out.println("String matches: "+CompareTwoStringsMethod(str1,str2));

	}

	public static boolean CompareTwoStringsMethod(String str1, String str2) {

		int j = str1.length();
		int k = str2.length();
		boolean isMatch = false;

		if (!(j == k)) {
			isMatch = false;
			return isMatch;
		}

		else {
			for (int m = 0; m < j; m++) {
				if (str1.charAt(m) == str2.charAt(m)) {
					isMatch = true;
				} else {
					System.out.println("Mismatch occured at: "+(m+1));
					isMatch = false;
					break;
				}
			}
		}

		return isMatch;

	}

}
