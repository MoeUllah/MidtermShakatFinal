package math.problems;

public class Fibonacci {
	public static void main(String[] args) {
		/*
		 * Write 40 Fibonacci numbers with java. 0,1,1,2,3,5,8,13
		 */
		int number = fibonacciEx(10);
		int number1 = fibonacciIter(10);
		System.out.println();
		System.out.println(number + " is Fib of 10.");
		System.out.println(number1 + " is Fib of 10.");
	}

	public static int fibonacciEx(int num) {
		if (num == 0)
			return 0;
		if (num <= 2)
			return 1;

		int fibonacciAnswer = fibonacciEx(num - 1) + fibonacciEx(num - 2);
		return fibonacciAnswer;
	}

	public static int fibonacciIter(int num) {
		int first = 0;
		int second = 1;
		int add;
		for (int i = 0; i < num; i++) {
			System.out.print(first + " ");
			add = first + second;
			first = second;
			second = add;
		}
		return first;

	}

}
