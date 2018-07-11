package ftn.poslovna.inf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
public class InvoiceItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "catalog_id")
	private Catalog catalog;
	
	@ManyToOne
	@JoinColumn(name = "invoice_id")
	private Invoice invoice;
	
	@Column
	private String name; //opis
	
	@Column
	private int amount; //kolicina
	
	@Column
	private float price; //cena
	
	@Column
	private float discount; //iznos rabata - Vrednost * Procenat rabata / 100
	
	@Column
	private int discountPercentage; //rabat u % 
	
	@Column
	private float value; //vrednost = kolicina * cena
	
	@Column
	private float itemBase; //osnovica pdv-a = Vrednost – Iznos rabata
	
	@Column
	private int taxRate; //stopa pdva u procentima
	
	@Column
	private float tax; //iznos poreza - Osnovica PDV * Stopa PDV / 100
	
	@Column
	private float totalAmount; //prodajna vrednost: Vrednost – Iznos rabata + Iznos poreza
	
	public InvoiceItem() {
		
	}

	public Long getId() {
		return id;
	}

	@XmlElement
	public void setId(Long id) {
		this.id = id;
	}

	public Catalog getCatalog() {
		return catalog;
	}

	@XmlTransient
	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	@XmlTransient
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	@XmlElement
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getPrice() {
		return price;
	}

	@XmlElement
	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	@XmlElement
	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public int getDiscountPercentage() {
		return discountPercentage;
	}

	@XmlElement
	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public float getValue() {
		return value;
	}

	@XmlElement
	public void setValue(float value) {
		this.value = value;
	}

	public float getItemBase() {
		return itemBase;
	}

	@XmlElement
	public void setItemBase(float itemBase) {
		this.itemBase = itemBase;
	}

	public int getTaxRate() {
		return taxRate;
	}

	@XmlElement
	public void setTaxRate(int taxRate) {
		this.taxRate = taxRate;
	}

	public float getTax() {
		return tax;
	}

	@XmlElement
	public void setTax(float tax) {
		this.tax = tax;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	@XmlElement
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	

}
