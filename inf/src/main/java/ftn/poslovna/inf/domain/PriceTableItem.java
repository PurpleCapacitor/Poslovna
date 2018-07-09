package ftn.poslovna.inf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PriceTableItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "priceTable_id")
	private PriceTable priceTable;
	
	@Column
	private float itemPrice;
	
	@Column
	private String itemName;
	
	@ManyToOne
	@JoinColumn(name = "catalog_id")
	private Catalog catalog;
	
	public PriceTableItem() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PriceTable getPriceTable() {
		return priceTable;
	}

	public void setPriceTable(PriceTable priceTable) {
		this.priceTable = priceTable;
	}

	public float getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}
	
	

}
