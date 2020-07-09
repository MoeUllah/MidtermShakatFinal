package design;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class EmployeeInfo extends WalmartEmployee {

	/*
	 * This class can be implemented from Employee interface then add additional
	 * methods in EmployeeInfo class. Also, Employee interface can be implemented
	 * into an abstract class.So create an Abstract class then inherit that abstract
	 * class into EmployeeInfo class.Once you done with designing EmployeeInfo
	 * class, go to FortuneEmployee class to apply all the fields and attributes.
	 * 
	 * Important: YOU MUST USE the OOP(abstraction,Encapsulation, Inheritance and
	 * Polymorphism) concepts in every level possible. Use all kind of
	 * keywords(super,this,static,final........) Implement Nested class. Use
	 * Exception Handling.
	 *
	 */

	/*
	 * declare few static and final fields and some non-static fields
	 */
	private static String companyName = "Walmart";
	private static String SSN = "";
	private String phoneNumber;
	private String address = "Not Available";
	private String accountNumber = "No bank information";
	private Contract contract;
	private static String birthDate = "";
	private int employeeId;
	private String employeeName;
	private double salary;

	/*
	 * You must implement the logic for below 2 methods and following 2 methods are
	 * prototype as well for other methods need to be design, as you will come up
	 * with the new ideas.
	 */

	/*
	 * you must have multiple constructor. Must implement below constructor.
	 */

	public EmployeeInfo(Department department, String location, String employeeName, int employeeId,
			Contract contract) {
		this(department, location, "", "", contract, employeeId, employeeName, 0.0);
		this.accountNumber = "Not Available";
		this.phoneNumber = "Not Available";
		this.address = "Not Available";
		this.accountNumber = "No bank information";

	}

	public EmployeeInfo(Department department, String location, String phoneNumber, String address, Contract contract,
			int employeeId, String employeeName, double salary) {
		this(department, location, phoneNumber, address, "", contract, employeeId, employeeName, salary);
	}

	public EmployeeInfo(Department department, String location, String phoneNumber, String address,
			String accountNumber, Contract contract, int employeeId, String employeeName, double salary) {
		super(department, location);
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.accountNumber = accountNumber;
		this.contract = contract;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
	}

	public static String getCompanyName() {
		return companyName;
	}

	public static void setCompanyName(String companyName) {
		EmployeeInfo.companyName = companyName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public String getSsn() {
		return SSN;
	}

	public String getBirthdate() {
		return birthDate;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public int employeeId() {

		return employeeId;
	}

	public String employeeName() {

		return employeeName;
	}

	public double calculateSalary(double monthlyPay) {
		if (contract.getContractType() == "Salary Employee")
			salary = monthlyPay * 12;
		return salary;
	}

	public double calculateWages(double hourlyPay, int hoursWorked, int overtimeExtra) {
		double pay = 0;
		if (contract.getContractType() == "Waged-Employee") {
			pay = hourlyPay * hoursWorked;
			if (hoursWorked <= 40)
				System.out.println(employeeName + " makes " + hourlyPay + " dollars an hour and this week made " + pay
						+ " dollars.");
			else if (hoursWorked > 40) {
				int y;
				y = hoursWorked - 40;
				int overtime = y * 10;
				pay = (hoursWorked * hourlyPay) + overtime;
				System.out.println(employeeName + " makes " + hourlyPay + " dollars an hour and an additional "
						+ overtimeExtra + " dollars" + " an hour for hours worked over 40 and this week made " + pay
						+ " dollars.");
			}
		}
		return pay;

	}

	public void calculateCommission(double commissionAmount) {
		System.out.println("For this contract you'll get paid " + commissionAmount + ".");

	}

	public void benefitLayout() {
		double pension = calculateEmployeePension();
		System.out.println("Your pension is " + pension + ".");
		if (contract.getContractType() == "Waged-Employee" || contract.getContractType() == "Salary Employee")
			System.out.println("Your insurance for health,dental and vision is covered.You"
					+ " can also choose a retirement plan and life insurance program with us. You'll also get paid time off.");
		else
			System.out.println("Commissioned employees dont get benefits besides pension.");
	}

	public double getSalary() {
		return salary;
	}

	/*
	 * This methods should calculate Employee bonus based on salary and performance.
	 * Then it will return the total yearly bonus. So you need to implement the
	 * logic. Hints: 10% of the salary for best performance, 8% of the salary for
	 * average performance and so on. You can set arbitrary number for performance.
	 * So you probably need to send 2 arguments.
	 * 
	 */
	public int yearsWorked(Contract contract) {
		String hiredDate = contract.getHiredDate();
		PeriodWorked conversion = new PeriodWorked();
		Period period = PeriodWorked.PeriodOfTimeWorked(hiredDate);
		return period.getYears();
	}

	private double increaseSalary(int yearsWorked) {
		switch (yearsWorked) {
		case 5:
			salary += salary * .02;
			break;
		case 10:
			salary += salary * .05;
			break;
		case 20:
			salary += salary * .10;
			break;
		case 40:
			salary += salary * .20;
			break;
		default:
			System.out.println("You haven't worked long enough for the next salary increase.");

		}
		return salary;
	}

	public double calculateEmployeeBonus(int numberOfYearsWithCompany, String performance) {
		salary = increaseSalary(numberOfYearsWithCompany);
		double total = 0;
		switch (performance) {
		case "Excellent":
			total += salary * .10;
			System.out.println("Great job, you got a 10% bonus for this year!!! Keep up the good work.");
			break;
		case "Good":
			total += salary * .05;
			System.out.println("Good Job, you got a 5 % bonus, but try to work even harder!!!");
			break;
		case "Average":
			total += salary * .02;
			System.out.println(
					"Your work was average this year, so we only gave you a 2 % bonus. Try to be more productive.");
			break;
		default:
			if (contract.getContractType() == "Salary-Employee")
				System.out.println("Your performance was horrendous, you'll not receive a bonus this year."
						+ " If you don't do better in the upcoming months, you'll be terminated!!!");

			if (contract.getContractType() == "Waged-Employee")
				System.out.println("Waged-Employees Employees get hourly wages, no bonuses eligible.");
			if (contract.getContractType() == "Contract-Employee")
				System.out.println("Your performance wasn't great for us to give you a bonus. Please"
						+ " finish the task on time or we'll not renew your contract.");

		}

		return total;
	}

	/*
	 * This methods should calculate Employee Pension based on salary and numbers of
	 * years with the company. Then it will return the total pension. So you need to
	 * implement the logic. Hints: pension will be 5% of the salary for 1 year, 10%
	 * for 2 years with the company and so on.
	 * 
	 */
	public double calculateEmployeePension() {
		double total = 0;
		int i = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter start date in format (example: May,20,2015): ");
		String joiningDate = sc.nextLine();
		System.out.println("Please enter today's date in format (example: August,20,2017): ");
		String todaysDate = sc.nextLine();
		String convertedJoiningDate = DateConversion.convertDate(joiningDate); // 05/20/2015
		String convertedTodaysDate = DateConversion.convertDate(todaysDate); // 08/20/2017

		// implement numbers of year from above two dates
		// Calculate pension
		String[] date1 = convertedJoiningDate.split("/");
		int m = Integer.parseInt(date1[0]);
		int d = Integer.parseInt(date1[1]);
		int y = Integer.parseInt(date1[2]);
		String[] date2 = convertedTodaysDate.split("/");
		int m1 = Integer.parseInt(date2[0]);
		int d1 = Integer.parseInt(date2[1]);
		int y1 = Integer.parseInt(date2[2]);
		LocalDate dateHired = LocalDate.of(y, m, d);
		LocalDate dateCurrent = LocalDate.of(y1, m1, d1); // 2015/20/05
		Period period = Period.between(dateHired, dateCurrent); // 2017/20/2017
		int yearsBetween = period.getYears();

//        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MM/dd/YYYY");
//        LocalDate date1=LocalDate.parse(convertedJoiningDate, formatter);
//        LocalDate date2=LocalDate.parse(convertedTodaysDate, formatter);
//        long yearsBetween=ChronoUnit.YEARS.between(date1, date2);

		for (i = 0 + 1; i < yearsBetween; i++) {
			total = yearsBetween * .05 * salary;
		}
		return total;
	}

	private static class DateConversion {

		public DateConversion(Months months) {
		}

		public static String convertDate(String date) {
			String[] extractMonth = date.split(","); // May,20,1997
			String givenMonth = extractMonth[0];
			int monthDate = whichMonth(givenMonth);
			String actualDate = "0" + monthDate + "/" + extractMonth[1] + "/" + extractMonth[2]; // 05/20/1997
			return actualDate;
		}

		public static int whichMonth(String givenMonth) {
			Months months = Months.valueOf(givenMonth);
			int date = 0;
			switch (months) {
			case January:
				date = 1;
				break;
			case February:
				date = 2;
				break;
			case March:
				date = 3;
				break;
			case April:
				date = 4;
				break;
			case May:
				date = 5;
				break;
			case June:
				date = 6;
				break;
			case July:
				date = 7;
				break;
			case August:
				date = 8;
				break;
			case September:
				date = 9;
				break;
			case October:
				date = 10;
				break;
			case November:
				date = 11;
				break;
			case December:
				date = 12;
				break;
			default:
				date = 0;
				break;
			}
			return date;

		}

	}

	private static class PeriodWorked {
		public static Period PeriodOfTimeWorked(String hiredDate) {
			String[] date1 = hiredDate.split("/");

			int d = Integer.parseInt(date1[0]);
			int m = Integer.parseInt(date1[1]);
			int y = Integer.parseInt(date1[2]);

			LocalDate dateHired = LocalDate.of(y, m, d);
			LocalDate dateCurrent = LocalDate.now();
			return Period.between(dateHired, dateCurrent);
		}
	}

	@Override
	public String toString() {
		return "EmployeeInfo [phoneNumber=" + phoneNumber + ", address=" + address + ", accountNumber=" + accountNumber
				+ ", contract=" + contract + ", employeeId=" + employeeId + ", employeeName=" + employeeName
				+ ", salary=" + salary + ", department=" + department + ", location=" + location + "]";
	}

}
