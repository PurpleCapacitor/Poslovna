package ftn.poslovna.inf.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PriceTableDTO {

	private int PriceTableNum;
	private Date implicationDate;
	private String companyId;
	private List<String> priceTableItems = new ArrayList<String>();
	
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

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public List<String> getPriceTableItems() {
		return priceTableItems;
	}

	public void setPriceTableItems(List<String> priceTableItems) {
		this.priceTableItems = priceTableItems;
	}
	
	
	
}
