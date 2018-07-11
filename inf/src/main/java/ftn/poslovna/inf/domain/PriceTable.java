package ftn.poslovna.inf.domain;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PriceTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private int PriceTableNum;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date implicationDate;
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;
	
	@Column
	@OneToMany(mappedBy = "priceTable", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<PriceTableItem> priceTableItems = new HashSet<PriceTableItem>();
	
	public PriceTable() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPriceTableNum() {
		return PriceTableNum;
	}

	public void setPriceTableNum(int priceTableNum) {
		PriceTableNum = priceTableNum;
	}

	public Date getImplicationDate() {
		return implicationDate;
	}

	public void setImplicationDate(Date implicationDate) {
		this.implicationDate = implicationDate;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<PriceTableItem> getPriceTableItems() {
		return priceTableItems;
	}

	public void setPriceTableItems(Set<PriceTableItem> priceTableItems) {
		this.priceTableItems = priceTableItems;
	}
	
	

}
