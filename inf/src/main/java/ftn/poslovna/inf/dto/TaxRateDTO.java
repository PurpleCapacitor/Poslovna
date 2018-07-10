package ftn.poslovna.inf.dto;

import java.util.Date;

public class TaxRateDTO {

	private float taxRate;
	private Date implicationDate;
	private String taxId;

	public TaxRateDTO() {

	}

	public float getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(float taxRate) {
		this.taxRate = taxRate;
	}

	public Date getImplicationDate() {
		return implicationDate;
	}

	public void setImplicationDate(Date implicationDate) {
		this.implicationDate = implicationDate;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

}
