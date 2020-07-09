package datastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UseArrayList {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use ArrayList that includes add,peek,remove,retrieve
		 * elements. Use For Each loop and while loop with Iterator to retrieve data.
		 * Store all the sorted data into one of the databases.
		 * 
		 */
		// no peek option for ArrayList
		List<Integer> arrayList = new ArrayList<Integer>();
		int i;
		for (i = 0; i < 100; i += 10) {

			arrayList.add(i);
		}

		arrayList.add(120);
		arrayList.add(55);
		arrayList.add(67);
		arrayList.add(8);
		arrayList.add(36);
		arrayList.add(206);
		arrayList.add(6);

		for (Integer number : arrayList) {
			System.out.println(number);
		}
		System.out.println("---------------------------------");

		Iterator<Integer> iterator = arrayList.listIterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			iterator.remove();
			;
		}
		System.out.println("The arrayList being empty is " + arrayList.isEmpty());
	}

}
