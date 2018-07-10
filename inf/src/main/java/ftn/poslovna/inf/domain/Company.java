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
import javax.persistence.OneToMany;

@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<BusinessYear> businessYear = new HashSet<BusinessYear>();
	
	@Column
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Group> groups = new HashSet<Group>();
	
	@Column
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<BusinessPartner> businessPartners = new HashSet<BusinessPartner>();
	
	@Column
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<PriceTable> priceTables = new HashSet<PriceTable>();
	
	public Company() {
		
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

	public Set<BusinessYear> getBusinessYear() {
		return businessYear;
	}

	public void setBusinessYear(Set<BusinessYear> businessYear) {
		this.businessYear = businessYear;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	public Set<BusinessPartner> getBusinessPartners() {
		return businessPartners;
	}

	public void setBusinessPartners(Set<BusinessPartner> businessPartners) {
		this.businessPartners = businessPartners;
	}

	public Set<PriceTable> getPriceTables() {
		return priceTables;
	}

	public void setPriceTables(Set<PriceTable> priceTables) {
		this.priceTables = priceTables;
	}
	
	
}
