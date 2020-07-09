package string.problems;

public class Palindrome {
	public static void main(String[] args) {
		/*
		 * If a String is reversed and it remains unchanged, that is called Palindrome.
		 * For example, MOM,DAD,MADAM are Palindrome. So write java code to check if a
		 * given String is Palindrome or not.
		 */
		String friend = "Maxixam";
		boolean isPalindrome = isPalindromeCheck(friend);
		System.out.println(isPalindrome);

	}

	public static boolean isPalindromeCheck(String friend) {
		int start = 0;
		int end = friend.length() - 1;
		boolean isPalindrome = true;

		while (start < end) {
			String starting = friend.substring(start, start + 1);
			String ending = friend.substring(end, end + 1);
			if (starting.equalsIgnoreCase(ending) == false) {
				isPalindrome = false;
				break;
			}
			start++;
			end--;
		}

		if (isPalindrome == true)
			System.out.println("It is a palindrome is " + isPalindrome);
		else
			System.out.println("Not a palindrome");
		return isPalindrome;
	}

}