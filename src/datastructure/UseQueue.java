package datastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class UseQueue {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Queue that includes add,peek,remove,pool elements. Use
		 * For Each loop and while loop with Iterator to retrieve data.
		 * 
		 */
		Queue<Integer> queue = new PriorityQueue<Integer>();

		try (Scanner input = new Scanner(System.in)) {
			System.out.println(
					"Please enter a number representing the limit of the amount of numbers you wish to enter.");

			int limit = input.nextInt();
			System.out.println("Please enter " + limit + " numbers");

			for (int i = 0; i < limit; i++) {
				System.out.println("Adding folowing number: ");
				queue.add(input.nextInt());
			}
		}
		System.out.println("---------------------------------");

		for (Integer number : queue) {
			System.out.println("Retrieving following number: ");
			System.out.println(number);

		}
		System.out.println(queue);
		System.out.println("---------------------------------");

		Iterator<Integer> iterator = queue.iterator();

		while (!(queue.isEmpty())) {
			int n = queue.peek();
			System.out.println("The number i peek is " + n);
			int numbers = queue.poll();
			System.out.println(numbers);

		}

		System.out.println("The queue being empty is " + queue.isEmpty());

		List<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(5);
		list.add(6);
		queue.addAll(list);
		while (!(queue.isEmpty())) {
			int n = queue.peek();
			System.out.println("The number i peek is " + n);
			int numbers = queue.remove();
			System.out.println(numbers);
		}
		System.out.println(queue);

	}

}
