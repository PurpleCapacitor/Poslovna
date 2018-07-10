package ftn.poslovna.inf.dto;


public class DeliveryNoteDTO {
	
	private long id;
	private long businessPartnerId;
	private long businessYearId;
	private long orderId;	
	private long invoiceId;
	
	public DeliveryNoteDTO(){
		
	}
	
	public DeliveryNoteDTO(long id, long businessPartnerId, long businessYearId, long orderId, long invoiceId) {
		super();
		this.id = id;
		this.businessPartnerId = businessPartnerId;
		this.businessYearId = businessYearId;
		this.orderId = orderId;
		this.invoiceId = invoiceId;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getBusinessPartnerId() {
		return businessPartnerId;
	}
	public void setBusinessPartnerId(long businessPartnerId) {
		this.businessPartnerId = businessPartnerId;
	}
	public long getBusinessYearId() {
		return businessYearId;
	}
	public void setBusinessYearId(long businessYearId) {
		this.businessYearId = businessYearId;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}
	
	

}
