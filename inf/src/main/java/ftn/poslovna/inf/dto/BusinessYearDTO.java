package ftn.poslovna.inf.dto;


public class BusinessYearDTO {

	private long id;
	private int yearNumber;
	private boolean finished;
	private long companyId;
	private String companyName;
	
	public BusinessYearDTO(){
		
	}

	public BusinessYearDTO(long id, int yearNumber, boolean finished, long companyId, String companyName) {
		super();
		this.id = id;
		this.yearNumber = yearNumber;
		this.finished = finished;
		this.companyId = companyId;
		this.setCompanyName(companyName);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getYearNumber() {
		return yearNumber;
	}

	public void setYearNumber(int yearNumber) {
		this.yearNumber = yearNumber;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
}
