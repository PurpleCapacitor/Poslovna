package ftn.poslovna.inf.dto;


public class BusinessPartnerDTO {

	private long id;	
	private String name;
	private String type;
	private long companyId;
	
	public BusinessPartnerDTO(){
		
	}

	public BusinessPartnerDTO(long id, String name, String type, long companyId) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.companyId = companyId;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	
	
	
}
