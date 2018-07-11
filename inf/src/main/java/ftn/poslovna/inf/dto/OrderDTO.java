package ftn.poslovna.inf.dto;


public class OrderDTO {

	private long id;
	private long businessYearId;
	private int yearNumber;
	private long buyerId;
	private String buyerName;
	private long sellerId;
	private String sellerName;

	public OrderDTO() {

	}
	
	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public long getBusinessYearId() {
		return businessYearId;
	}

	public void setBusinessYearId(long businessYearId) {
		this.businessYearId = businessYearId;
	}

	public long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(long buyerId) {
		this.buyerId = buyerId;
	}

	public long getSellerId() {
		return sellerId;
	}

	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
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
	

}
