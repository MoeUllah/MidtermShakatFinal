package string.problems;

import java.util.Arrays;

/**
 * Created by mrahman on 04/22/17.
 */
public class Anagram {

	public static void main(String[] args) {
		// Write a Java Program to check if the two String are Anagram. Two String are
		// called Anagram when there is
		// same character but in different order.For example,"CAT" and "ACT", "ARMY" and
		// "MARY".

		String string1 = "cat";
		String string2 = "act";

		System.out.println("The two words being anagrams is " + isAnagram(string1, string2));

	}

	public static boolean isAnagram(String one, String two) {
		char[] array1 = one.toCharArray();
		char[] array2 = two.toCharArray();
		Arrays.sort(array1);
		Arrays.sort(array2);
		return Arrays.equals(array1, array2);
	}
}