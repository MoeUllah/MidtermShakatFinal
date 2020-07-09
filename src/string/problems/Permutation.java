package string.problems;

/**
 * Created by mrahman on 04/22/17.
 */
public class Permutation {

	public static void main(String[] args) {

		/*
		 * Permutation of String "ABC" is "ABC" "BAC" "BCA" "ACB" "CAB" "CBA". Write
		 * Java program to compute all Permutation of a String
		 *
		 */

		String word = "cat";
		permutation("", "cat");

	}

	public static void permutation(String permutation, String input) {
		if (input.length() == 0)
			System.out.print(permutation + " ");
		else {
			for (int i = 0; i < input.length(); i++) {
				permutation(permutation + input.charAt(i),
						input.substring(0, i) + input.substring(i + 1, input.length()));
			}
		}
	}
}
