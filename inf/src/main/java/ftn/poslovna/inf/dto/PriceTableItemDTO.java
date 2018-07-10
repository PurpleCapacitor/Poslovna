package ftn.poslovna.inf.dto;

public class PriceTableItemDTO {

	private String priceTableId;
	private float itemPrice;
	private String itemName;
	private String catalogId;

	public PriceTableItemDTO() {

	}

	public String getPriceTableId() {
		return priceTableId;
	}

	public void setPriceTableId(String priceTableId) {
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

	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

}
