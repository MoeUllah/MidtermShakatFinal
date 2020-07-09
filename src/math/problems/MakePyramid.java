package math.problems;

public class MakePyramid {
	public static void main(String[] args) {

		/*
		 * Implement a large Pyramid of stars in the screen with java.
		 *
		 * 
		 * * * * * * * * * * * * * * * *
		 * 
		 */
		makePyramid();
	}

	public static void makePyramid() {
		for (int i = 1; i <= 10; i++) {
			for (int j = i; j < 10; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k < (i * 2); k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
