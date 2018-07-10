package ftn.poslovna.inf.dto;


public class DeliveryNoteDTO {
	
	private long id;
	private long buyerId;
	private long sellerId;
	private long businessYearId;
	private long invoiceId;
	
	public DeliveryNoteDTO(){
		
	}
	
	public DeliveryNoteDTO(long id, long buyerId, long sellerId, long businessYearId, long invoiceId) {
		super();
		this.id = id;
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.businessYearId = businessYearId;
		this.invoiceId = invoiceId;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public long getBusinessYearId() {
		return businessYearId;
	}
	public void setBusinessYearId(long businessYearId) {
		this.businessYearId = businessYearId;
	}
	public long getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}
	
	

}
