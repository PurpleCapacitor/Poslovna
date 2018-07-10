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
import javax.persistence.OneToMany;

@Entity
public class Tax {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String taxId;

	@Column
	private String taxName;

	@Column
	private boolean valid;

	@Column
	@OneToMany(mappedBy = "tax", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Group> groups;

	@Column
	@OneToMany(mappedBy = "tax", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<TaxRate> taxRates = new HashSet<TaxRate>();

	public Tax() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getTaxName() {
		return taxName;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	public Set<TaxRate> getTaxRates() {
		return taxRates;
	}

	public void setTaxRates(Set<TaxRate> taxRates) {
		this.taxRates = taxRates;
	}
	
	@SuppressWarnings("deprecation")
	public TaxRate getActiveTaxRate(){
		TaxRate returnTaxRate = new TaxRate();
		Date oldDate = new Date();
		oldDate.setYear(1900);
		returnTaxRate.setImplicationDate(oldDate);
		for(TaxRate taxRate : taxRates){
			if(taxRate.getImplicationDate().after(oldDate)){
				returnTaxRate=taxRate;
			}
		}
		return returnTaxRate; 
	}
	
	

}
