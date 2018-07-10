package ftn.poslovna.inf.dto;

public class PriceTableItemDTO {

	private long priceTableId;
	private float itemPrice;
	private String itemName;
	private long catalogId;

	public PriceTableItemDTO() {

	}

	public long getPriceTableId() {
		return priceTableId;
	}

	public void setPriceTableId(long priceTableId) {
		this.priceTableId = priceTableId;
	}

	public float getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public long getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(long catalogId) {
		this.catalogId = catalogId;
	}


}
