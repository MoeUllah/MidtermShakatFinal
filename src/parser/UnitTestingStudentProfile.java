package parser;

import org.testng.Assert;

public class UnitTestingStudentProfile {
	public static void main(String[] args) {
		// Apply Unit Test into all the methods in this package.
		String letter = XmlReader.convertIntToChar("70");
		String actual = "C";
		try {
			Assert.assertEquals(letter, actual, "Wrong calculation");
		} catch (Exception ex) {
			ex.getMessage();
		}

	}
}
