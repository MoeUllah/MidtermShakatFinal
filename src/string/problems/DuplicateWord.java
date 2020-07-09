package string.problems;

/**
 * Created by mrahman on 04/22/17.
 */
public class DuplicateWord {

	public static void main(String[] args) {
		/*
		 * Write a java program to find the duplicate words and their number of
		 * occurrences in the string. Also Find the average length of the words.
		 */

		String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";
		duplicateWord(st);

	}

	public static void duplicateWord(String st) {
		st.toLowerCase();
		int count;
		int letterCount = 0;

		String[] words = st.split(" ");

		for (String word : words) {
			letterCount += word.length();
		}
		System.out.println("The average length of a word is: " + letterCount / words.length);

		for (int i = 0; i < words.length; i++) {
			count = 1;
			for (int j = i + 1; j < words.length; j++) {
				if (words[i].equals(words[j])) {
					count++;
					words[j] = "0";
				}
			}
			if (count > 1 && words[i] != "0")
				System.out.println(words[i] + " " + count);
		}

	}

}
