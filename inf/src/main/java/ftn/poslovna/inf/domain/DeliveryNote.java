package ftn.poslovna.inf.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class DeliveryNote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "businessPartner_id")
	private BusinessPartner businessPartner;
	
	@ManyToOne
	@JoinColumn(name = "businessYear_id")
	private BusinessYear businessYear;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@Column
	@OneToMany(mappedBy = "deliveryNote", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<DeliveryNoteItem> deliveryNoteItems = new HashSet<DeliveryNoteItem>();
	
	@Column
	private Invoice invoice;
	
	public DeliveryNote() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BusinessPartner getBusinessPartner() {
		return businessPartner;
	}

	public void setBusinessPartner(BusinessPartner businessPartner) {
		this.businessPartner = businessPartner;
	}

	public BusinessYear getBusinessYear() {
		return businessYear;
	}

	public void setBusinessYear(BusinessYear businessYear) {
		this.businessYear = businessYear;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Set<DeliveryNoteItem> getDeliveryNoteItems() {
		return deliveryNoteItems;
	}

	public void setDeliveryNoteItems(Set<DeliveryNoteItem> deliveryNoteItems) {
		this.deliveryNoteItems = deliveryNoteItems;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
	
	
	
	

}
