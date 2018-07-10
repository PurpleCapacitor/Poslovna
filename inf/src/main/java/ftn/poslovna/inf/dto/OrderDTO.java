package ftn.poslovna.inf.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

	private String businessYearId;
	private String businessPartnerId;
	private List<String> deliveryNote = new ArrayList<String>();;
	private List<String> ordetItems = new ArrayList<String>();

	public OrderDTO() {

	}

	public String getBusinessYearId() {
		return businessYearId;
	}

	public void setBusinessYearId(String businessYearId) {
		this.businessYearId = businessYearId;
	}

	public String getBusinessPartnerId() {
		return businessPartnerId;
	}

	public void setBusinessPartnerId(String businessPartnerId) {
		this.businessPartnerId = businessPartnerId;
	}

	public List<String> getDeliveryNote() {
		return deliveryNote;
	}

	public void setDeliveryNote(List<String> deliveryNote) {
		this.deliveryNote = deliveryNote;
	}

	public List<String> getOrdetItems() {
		return ordetItems;
	}

	public void setOrdetItems(List<String> ordetItems) {
		this.ordetItems = ordetItems;
	}

}
