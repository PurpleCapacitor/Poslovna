package ftn.poslovna.inf.dto;

public class GroupDTO {

	private long id;
	private String groupName;
	private long companyId;
	private long taxId;
	
	public GroupDTO(){
		
	}
	
	public GroupDTO(long id, String groupName, long companyId, long taxId) {
		super();
		this.id = id;
		this.groupName = groupName;
		this.companyId = companyId;
		this.taxId = taxId;
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
