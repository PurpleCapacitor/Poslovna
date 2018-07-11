package ftn.poslovna.inf.dto;


public class CatalogDTO {
	
	private long id;
	private long groupId;
	private String groupName;
	
	public CatalogDTO(){
		
	}
	
	public CatalogDTO(long id, long groupId,String groupName) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.groupName	= groupName;
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
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	

}
