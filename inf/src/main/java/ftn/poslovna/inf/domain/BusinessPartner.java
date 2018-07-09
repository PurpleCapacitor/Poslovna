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
public class BusinessPartner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private PartnerType type;
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;
	
	@Column
	@OneToMany(mappedBy = "businessPartner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Invoice> invoices = new HashSet<Invoice>();
	
	@Column
	@OneToMany(mappedBy = "businessPartner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Order> orders = new HashSet<Order>();
	
	@Column 
	@OneToMany(mappedBy = "businessPartner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<DeliveryNote> deliveryNotes = new HashSet<DeliveryNote>();
	
	public BusinessPartner() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PartnerType getType() {
		return type;
	}

	public void setType(PartnerType type) {
		this.type = type;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(Set<Invoice> invoices) {
		this.invoices = invoices;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Set<DeliveryNote> getDeliveryNotes() {
		return deliveryNotes;
	}

	public void setDeliveryNotes(Set<DeliveryNote> deliveryNotes) {
		this.deliveryNotes = deliveryNotes;
	}
	
	
	

}
