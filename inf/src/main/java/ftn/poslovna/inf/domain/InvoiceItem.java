package ftn.poslovna.inf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
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

	public void setId(Long id) {
		this.id = id;
	}

	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public int getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public float getItemBase() {
		return itemBase;
	}

	public void setItemBase(float itemBase) {
		this.itemBase = itemBase;
	}

	public int getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(int taxRate) {
		this.taxRate = taxRate;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	

}
