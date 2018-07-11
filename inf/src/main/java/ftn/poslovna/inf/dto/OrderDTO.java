package ftn.poslovna.inf.dto;


public class OrderDTO {

	private long id;
	private long businessYearId;
	private long buyerId;
	private long sellerId;

	public OrderDTO() {

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
	

}
