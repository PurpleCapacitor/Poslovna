package ftn.poslovna.inf.dto;

public class ItemDTO {

	private long catalogId;
	private String itemName;
	
	public ItemDTO(){
		
	}
	
	public ItemDTO(long catalogId, String itemName) {
		super();
		this.catalogId = catalogId;
		this.itemName = itemName;
	}
	public long getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(long catalogId) {
		this.catalogId = catalogId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	
}
