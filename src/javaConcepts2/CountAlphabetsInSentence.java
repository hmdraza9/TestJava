package javaConcepts2;

import java.util.HashSet;
import java.util.Iterator;

public class CountAlphabetsInSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String str = "There are following two ways to iterate through HashSet:";
//		String str = "There are following two ways to iterate through HashSet:".toLowerCase();
		String str = "There are following two ways to iterate through HashSet:".toUpperCase();
		HashSet<String> newHS = new HashSet<String>();
		newHS = countUniqueChars(str.replace(" ", ""));
		System.out.println(newHS);
		CountAlphabetsMethod(str, newHS);
	}

	public static HashSet<String> countUniqueChars(String str) {

		HashSet<String> charSet = new HashSet<String>();
		for (int i = 0; i < str.length(); i++) {
			String temp = str.substring(i, i + 1);
			charSet.add(temp);
		}
//		System.out.println(charSet);
		return charSet;
	}

	public static void CountAlphabetsMethod(String str, HashSet<String> hSet) {

		Iterator<String> it = hSet.iterator();
		while (it.hasNext()) {
			String currentSetVal = it.next();
			int count = 0;
			for (int i = 0; i < str.length(); i++) {
				if (currentSetVal.equalsIgnoreCase(str.substring(i, i + 1))) {
					count++;
				}
			}
			System.out.print(currentSetVal + "=" + count+" :: ");
		}

	}
}
