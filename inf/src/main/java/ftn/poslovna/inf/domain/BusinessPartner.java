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
	@OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Invoice> buyerInvoices = new HashSet<Invoice>();
	
	@Column
	@OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Invoice> sellerInvoices = new HashSet<Invoice>();
	
	@Column
	@OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Order> buyerOrders = new HashSet<Order>();
	
	@Column
	@OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Order> sellerOrders = new HashSet<Order>();
	
	@Column 
	@OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<DeliveryNote> buyerDeliveryNotes = new HashSet<DeliveryNote>();
	
	@Column 
	@OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<DeliveryNote> sellerDeliveryNotes = new HashSet<DeliveryNote>();
	
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

	public Set<Invoice> getBuyerInvoices() {
		return buyerInvoices;
	}

	public void setBuyerInvoices(Set<Invoice> buyerInvoices) {
		this.buyerInvoices = buyerInvoices;
	}

	public Set<Invoice> getSellerInvoices() {
		return sellerInvoices;
	}

	public void setSellerInvoices(Set<Invoice> sellerInvoices) {
		this.sellerInvoices = sellerInvoices;
	}

	public Set<Order> getBuyerOrders() {
		return buyerOrders;
	}

	public void setBuyerOrders(Set<Order> buyerOrders) {
		this.buyerOrders = buyerOrders;
	}

	public Set<Order> getSellerOrders() {
		return sellerOrders;
	}

	public void setSellerOrders(Set<Order> sellerOrders) {
		this.sellerOrders = sellerOrders;
	}

	public Set<DeliveryNote> getBuyerDeliveryNotes() {
		return buyerDeliveryNotes;
	}

	public void setBuyerDeliveryNotes(Set<DeliveryNote> buyerDeliveryNotes) {
		this.buyerDeliveryNotes = buyerDeliveryNotes;
	}

	public Set<DeliveryNote> getSellerDeliveryNotes() {
		return sellerDeliveryNotes;
	}

	public void setSellerDeliveryNotes(Set<DeliveryNote> sellerDeliveryNotes) {
		this.sellerDeliveryNotes = sellerDeliveryNotes;
	}
	

	
	
	
	

}
