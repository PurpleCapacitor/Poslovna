package ftn.poslovna.inf.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PriceTableDTO {

	private int PriceTableNum;
	private Date implicationDate;
	private long companyId;
	
	public PriceTableDTO() {
		
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

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	
	
	
}
