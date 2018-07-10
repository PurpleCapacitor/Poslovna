package ftn.poslovna.inf.dto;


public class CatalogDTO {
	
	private long id;
	private long groupId;
	
	public CatalogDTO(){
		
	}
	
	public CatalogDTO(long id, long groupId) {
		super();
		this.id = id;
		this.groupId = groupId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	
	

}
