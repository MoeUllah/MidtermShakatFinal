package design;

public class Contract {
	private String contractType;
	private String hiredDate;
	
	public Contract(String contractType,String hiredDate) {
		super();
		this.contractType = contractType;
		this.hiredDate = hiredDate;
		
	}
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getHiredDate() {
		return hiredDate;
	}
	@Override
	public String toString() {
		return "[contractType=" + contractType + ", hiredDate=" + hiredDate + "]";
	}
	
	
	
}
