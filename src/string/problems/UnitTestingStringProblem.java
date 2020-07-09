package string.problems;

import org.testng.Assert;

public class UnitTestingStringProblem {
	public static void main(String[] args) {
		// Apply Unit Test into all the methods in this packag

		boolean isAnagram = Anagram.isAnagram("cat", "act");
		boolean answer = true;
		try {
			Assert.assertEquals(isAnagram, answer, "Not an anagram");
		} catch (Exception ex) {
			ex.getMessage();
		}
		System.out.println("Going to print word length.");
		String s = "Human brain is a biological learning machine";
		String experimental1 = DetermineLargestWord.findTheLargestWord(s);
		String actual1 = "biological";
		System.out.println("Going to print word length.");
		try {
			Assert.assertEquals(experimental1, actual1, "Wrong");
		} catch (Exception ex) {
			ex.getMessage();
		}
		System.out.println("Will print true for palindrome");
		boolean experimental3 = Palindrome.isPalindromeCheck("maxixam");
		boolean actual3 = true;
		System.out.println("Will print true for palindrome");
		try {
			Assert.assertEquals(experimental3, actual3, "Wrong");
		} catch (Exception ex) {
			ex.getMessage();
		}

	}

}
