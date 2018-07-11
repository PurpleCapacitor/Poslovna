package ftn.poslovna.inf.dto;

import java.util.Date;

public class TaxRateDTO {

	private long id;
	private int taxRate;
	private Date implicationDate;
	private long taxId;
	private String taxName;

	public TaxRateDTO() {

	}

	public int getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(int taxRate) {
		this.taxRate = taxRate;
	}

	public Date getImplicationDate() {
		return implicationDate;
	}

	public void setImplicationDate(Date implicationDate) {
		this.implicationDate = implicationDate;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
