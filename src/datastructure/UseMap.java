package datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class UseMap {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Map that includes storing and retrieving elements. Add
		 * List<String> into a Map. Like, Map<String, List<string>> list = new
		 * HashMap<String, List<String>>(); Use For Each loop and while loop with
		 * Iterator to retrieve data.
		 *
		 */
		Map<String, List<String>> hashMap = new HashMap<>();
		List<String> names = new ArrayList<>();

		String deptName = "";

		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Please enter a number for the amount of departments there are.");
			int depts = input.nextInt();
			int i = 0;
			int h = 0;
			int k = 0;
			while (i < depts) {
				System.out.println("Please enter the department name");
				deptName = input.next();
				System.out.println(
						"Please enter a number for the limit of " + "names you wish to enter for this department.");
				int limit = input.nextInt();
				System.out.println("Please enter " + limit + " names.");

				while (h < limit) {
					names.add(input.next());
					hashMap.put(deptName, names);
					h++;
				}
				depts--;
				h = 0;
			}

			Set<Map.Entry<String, List<String>>> entrySet = hashMap.entrySet();
			Iterator<Entry<String, List<String>>> iterator = entrySet.iterator();
			for (Map.Entry<String, List<String>> entry : entrySet) {
				String j = entry.getKey();
				System.out.println(j + " " + entry.getValue());
			}

		}

	}

}
