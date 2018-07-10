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
import javax.persistence.Table;

@Entity
@Table(name="Ordering")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "businessYear_id")
	private BusinessYear businessYear;
	
	@ManyToOne
	@JoinColumn(name = "businessPartner_id")
	private BusinessPartner businessPartner;
	
	@Column
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<DeliveryNote> deliveryNote = new HashSet<DeliveryNote>();
	
	@Column
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<OrderItem> ordetItems = new HashSet<OrderItem>();
	
	public Order() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BusinessYear getBusinessYear() {
		return businessYear;
	}

	public void setBusinessYear(BusinessYear businessYear) {
		this.businessYear = businessYear;
	}

	public BusinessPartner getBusinessPartner() {
		return businessPartner;
	}

	public void setBusinessPartner(BusinessPartner businessPartner) {
		this.businessPartner = businessPartner;
	}

	public Set<DeliveryNote> getDeliveryNote() {
		return deliveryNote;
	}

	public void setDeliveryNote(Set<DeliveryNote> deliveryNote) {
		this.deliveryNote = deliveryNote;
	}

	public Set<OrderItem> getOrdetItems() {
		return ordetItems;
	}

	public void setOrdetItems(Set<OrderItem> ordetItems) {
		this.ordetItems = ordetItems;
	}

	
	
	

}
