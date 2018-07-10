package ftn.poslovna.inf.dto;


public class CompanyDTO {
	
	private long id;	
	private String name;
	private String accountNum;
	private String accountNumExtra;
	
	public CompanyDTO(){
		
	}
	
	public CompanyDTO(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getAccountNumExtra() {
		return accountNumExtra;
	}

	public void setAccountNumExtra(String accountNumExtra) {
		this.accountNumExtra = accountNumExtra;
	}	
	
	
	
}
