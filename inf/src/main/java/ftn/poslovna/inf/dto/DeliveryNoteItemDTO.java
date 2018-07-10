package ftn.poslovna.inf.dto;

public class DeliveryNoteItemDTO {

	private long id;	
	private long deliveryNoteId;
	private long catalogId;
	private String name;
	private float price;
	private int amount;
	
	public DeliveryNoteItemDTO(){
		
	}
	
	public DeliveryNoteItemDTO(long id, long deliveryNoteId, long catalogId, String name, float price, int amount) {
		super();
		this.id = id;
		this.deliveryNoteId = deliveryNoteId;
		this.catalogId = catalogId;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getDeliveryNoteId() {
		return deliveryNoteId;
	}
	public void setDeliveryNoteId(long deliveryNoteId) {
		this.deliveryNoteId = deliveryNoteId;
	}
	public long getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(long catalogId) {
		this.catalogId = catalogId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
