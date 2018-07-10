package ftn.poslovna.inf.dto;

import java.util.ArrayList;
import java.util.List;

public class TaxDTO {

	private String taxId;
	private String taxName;
	private boolean valid;
	private List<String> groups = new ArrayList<String>();
	private List<String> taxRates = new ArrayList<String>();

	public TaxDTO() {

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

	public List<String> getGroups() {
		return groups;
	}

	public void setGroups(List<String> groups) {
		this.groups = groups;
	}

	public List<String> getTaxRates() {
		return taxRates;
	}

	public void setTaxRates(List<String> taxRates) {
		this.taxRates = taxRates;
	}

}
