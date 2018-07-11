package ftn.poslovna.inf.dto;

public class GroupDTO {

	private long id;
	private String groupName;
	private long companyId;
	private String companyName;
	private long taxId;
	private int taxRate;
	
	public GroupDTO(){
		
	}
	
	public GroupDTO(long id, String groupName, long companyId, String companyName, long taxId, int taxRate) {
		super();
		this.id = id;
		this.groupName = groupName;
		this.companyId = companyId;
		this.companyName = companyName;
		this.taxId = taxId;
		this.taxRate = taxRate;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(int taxRate) {
		this.taxRate = taxRate;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public long getTaxId() {
		return taxId;
	}
	public void setTaxId(long taxId) {
		this.taxId = taxId;
	}

}
