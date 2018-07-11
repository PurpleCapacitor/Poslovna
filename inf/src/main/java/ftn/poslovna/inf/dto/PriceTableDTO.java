package ftn.poslovna.inf.dto;

import java.util.Date;

public class PriceTableDTO {

	private long id;
	private int priceTableNum;
	private Date implicationDate;
	private long companyId;
	private String companyName;
	
	public PriceTableDTO() {
		
	}

	public Date getImplicationDate() {
		return implicationDate;
	}

	public void setImplicationDate(Date implicationDate) {
		this.implicationDate = implicationDate;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public int getPriceTableNum() {
		return priceTableNum;
	}

	public void setPriceTableNum(int priceTableNum) {
		this.priceTableNum = priceTableNum;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	
	
	
}
