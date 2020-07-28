package javaConcepts2;

public class TestStringFunctions {

	public static void main(String[] args) {
		String[] newWords = reverseSentenceByWord("My name is Hamid Raza");
		for (String str : newWords) {
			System.out.print(str + " ");
		}
	}

	public static String[] reverseSentenceByWord(String sentense) {
		String[] words = sentense.split(" ");

		for (int i = 0; i < words.length; i++) {
			int k = words[i].length();
			String str = "";
			for (int m = k - 1; m >= 0; m--) {
				str = str + words[i].charAt(m);
			}
			words[i] = str;
		}
		return words;
	}
}
