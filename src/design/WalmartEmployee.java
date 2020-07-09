package design;

public abstract class WalmartEmployee implements Employee {

	protected Department department;
	protected String location;
	

	public WalmartEmployee(Department department, String location) {
		
		this.department = department;
		this.location = location;
	}
	
	
	public Department getDepartment() {
		
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	@Override
	public void assignDepartment(Department department) {
		this.department=department;
	}	
	public void departmentDuties() {
		switch(department) {
			case HUMAN_RESOURCES:System.out.println("Recruiting,screening,interviewing, and placing workers"
				+ " for Walmart. Handling Walmart employee relations, payroll, benefits and training.");
			break;
			case MARKETING:System.out.println("Getting people interested in the retail services of Walmart.");
			break;
			case INVENTORY:System.out.println("Supervising flow of goods from manaufacturers t warehouses and from"
					+" these facilities t point of sale.");
			break;
			case DISTRIBUTION: System.out.println("Receiving items ordered from vendors and directing those items to the"
					+ " proper division within the company.");
			break;
			case FINANCE: System.out.println("Managing the finances of Walmart.");
			break;
			case MANAGEMENT: System.out.println("Overseeing that the business of Walmart is running smoothly"
					+ " in all aspects of business operations. Leading and motivating.");
			
			
		}
			
	}
	
	


	


		
		
	

}
