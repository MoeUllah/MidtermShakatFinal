package string.problems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DetermineLargestWord {

	public static void main(String[] args) {
		String s = "Human brain is a biological learning machine";
		// Map<Integer, String> wordNLength = findTheLargestWord(s);
		// implement
		System.out.println(findTheLargestWord(s));

	}

	public static String findTheLargestWord(String wordGiven) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		String st = "";
		// implement

		String[] array = wordGiven.split(" ");
		Integer number = 0;
		for (String s : array) {

			map.put(number, s);
			number++;

		}
		System.out.println(map);
		Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
		int count = 0;
		String maxWord = "";
		Iterator iterator = entrySet.iterator();
		for (Entry<Integer, String> entry : entrySet) {
			String word = entry.getValue();

			if (word.length() > count) {
				count = word.length();
				maxWord = word;
			}
		}
		System.out.println(count);
		return maxWord;
	}
}