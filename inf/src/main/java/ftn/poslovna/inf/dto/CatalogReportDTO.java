package ftn.poslovna.inf.dto;

import java.util.Date;

public class CatalogReportDTO {
	
	private Date startingDate;
	private Date endingDate;
	
	public CatalogReportDTO() {
		
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public Date getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}
	
	

}
