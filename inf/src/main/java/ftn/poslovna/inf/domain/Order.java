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
	@JoinColumn(name = "buyer_id")
	private BusinessPartner buyer;
	
	@ManyToOne
	@JoinColumn(name = "seller_id")
	private BusinessPartner seller;	
	
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

	public Set<OrderItem> getOrdetItems() {
		return ordetItems;
	}

	public void setOrdetItems(Set<OrderItem> ordetItems) {
		this.ordetItems = ordetItems;
	}

	
	
	

}
