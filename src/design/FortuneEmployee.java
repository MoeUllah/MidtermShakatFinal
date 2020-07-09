package design;

public class FortuneEmployee {

	/**
	 * FortuneEmployee class has a main methods where you will be able to create
	 * Object from EmployeeInfo class to use fields and attributes.Demonstrate as
	 * many methods as possible to use with proper business work flow.Think as a
	 * Software Architect, Product Designer and as a Software
	 * Developer.(employee.info.system) package is given as an outline,you need to
	 * elaborate more to design an application that will meet for fortune 500
	 * Employee Information Services.
	 *
	 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
	 *
	 **/
	public static void main(String[] args) {
		EmployeeInfo employee1 = new EmployeeInfo(Department.HUMAN_RESOURCES, "New York", "Jane", 234567,
				new Contract("Salary Employee", "05/20/2017"));
		employee1.calculateSalary(5000.00);
		boolean flag = true;
		while (flag) {
			try {
				employee1.benefitLayout();
				flag = false;
			} catch (Exception ex) {
				System.out.println("Wrong input,please try again.");
			}
		}
		System.out.println(employee1.employeeName() + " is from the " + employee1.getDepartment() + " department.");
		employee1.departmentDuties();
		double bonus = employee1.calculateEmployeeBonus(3, "Excellent");
		System.out.println(employee1.employeeName() + " your bonus is " + bonus + ".");
		System.out.println(employee1.toString());
		EmployeeInfo employee2 = new EmployeeInfo(Department.DISTRIBUTION, "Miami", "917-256-3050",
				"57 McKinley Street", "001256844", new Contract("Salary Employee", "05,23,2010"), 1309695, "Max", 100);
		System.out.println();
		System.out.println(employee2.getDepartment());
		System.out.println(employee2.toString());
		employee2.calculateSalary(5000.00);
		boolean flag1 = true;
		while (flag1) {
			try {
				employee2.benefitLayout();
				flag1 = false;
			} catch (Exception ex) {
				System.out.println("Wrong input,please try again.");
			}
		}
		System.out.println(employee2.employeeName() + " is from the " + employee2.getDepartment() + " department.");
		employee2.departmentDuties();
		double bonus1 = employee2.calculateEmployeeBonus(3, "Excellent");
		System.out.println(employee2.employeeName() + " your bonus is " + bonus + ".");

	}

}
