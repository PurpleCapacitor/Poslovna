package ftn.poslovna.inf.dto;

import java.util.ArrayList;
import java.util.List;

public class TaxDTO {

	private long taxId;
	private String taxName;
	private boolean valid;

	public TaxDTO() {

	}

	public long getTaxId() {
		return taxId;
	}

	public void setTaxId(long taxId) {
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



}
