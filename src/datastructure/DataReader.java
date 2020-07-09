package datastructure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import databases.ConnectToSqlDB;

public class DataReader {

	public static void main(String[] args) {
		/*
		 * User API to read the below textFile and print to console. Use BufferedReader
		 * class. Use try....catch block to handle Exception.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 * After reading from file using BufferedReader API, store each word into Stack
		 * and LinkedList. So each word should construct a node in LinkedList.Then
		 * iterate/traverse through the list to retrieve as FIFO order from LinkedList
		 * and retrieve as FILO order from Stack.
		 *
		 * Demonstrate how to use Stack that includes push,peek,search,pop elements. Use
		 * For Each loop/while loop/Iterator to retrieve data.
		 */

		// String textFile = System.getProperty("user.dir") +
		// "/src/data/self-driving-car.txt";
		// System.out.println(System.getProperty("user.dir"));
		BufferedReader reader = null;
		String line;
		List<String> list = new LinkedList<>();
		Stack<String> stack = new Stack<>();
		List<String> dbList = new ArrayList<>();

		try {
			reader = new BufferedReader(new FileReader(
					"C:\\Users\\Shakat\\eclipse-workspace\\FirstJava\\Test\\src\\data\\self-driving-car.txt"));

			try {

				while ((line = reader.readLine()) != null) {
					System.out.println(line);
					String[] words = line.split(" ");
					list.addAll(Arrays.asList(words));
					stack.addAll(Arrays.asList(words));

				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} finally {
			System.out.println();
			System.out.println("In the finally block.");
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {

					e.printStackTrace();
				}

		}
		System.out.println("Above fetched data from BufferedReader");

		ConnectToSqlDB.insertDataListStringToSqlTable(list, "Table LinkedList", "wordsList");
		try {
			dbList = ConnectToSqlDB.readDataBase("Table LinkedList", "wordsList");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<String> iterator1 = dbList.iterator();
		while (iterator1.hasNext()) {
			System.out.println("Retrieved from SQL DB the word: " + iterator1.next());

		}

		System.out.println("FIFO---------------------------------------------");
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println(("List being empty is " + list.isEmpty()));
		System.out.println("-----------------------------------------------");

		System.out.println("LIFO-----------------------------");
		for (int i = stack.size() - 1; i >= 0; i--) {
			System.out.println("The top of the stack is: " + stack.peek());
			System.out.println("Node being removed is: " + stack.pop());
		}

	}
}
