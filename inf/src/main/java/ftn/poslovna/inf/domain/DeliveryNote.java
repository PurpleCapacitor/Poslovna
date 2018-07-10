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
import javax.persistence.OneToOne;

@Entity
public class DeliveryNote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "buyer_id")
	private BusinessPartner buyer;
	
	@ManyToOne
	@JoinColumn(name = "seller_id")
	private BusinessPartner seller;
	
	@ManyToOne
	@JoinColumn(name = "businessYear_id")
	private BusinessYear businessYear;	
	
	@Column
	@OneToMany(mappedBy = "deliveryNote", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<DeliveryNoteItem> deliveryNoteItems = new HashSet<DeliveryNoteItem>();
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id")
	private Invoice invoice;
	
	public DeliveryNote() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BusinessPartner getBuyer() {
		return buyer;
	}

	public void setBuyer(BusinessPartner buyer) {
		this.buyer = buyer;
	}

	public BusinessPartner getSeller() {
		return seller;
	}

	public void setSeller(BusinessPartner seller) {
		this.seller = seller;
	}

	public BusinessYear getBusinessYear() {
		return businessYear;
	}

	public void setBusinessYear(BusinessYear businessYear) {
		this.businessYear = businessYear;
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
