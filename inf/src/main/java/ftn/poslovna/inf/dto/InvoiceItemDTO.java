package ftn.poslovna.inf.dto;

public class InvoiceItemDTO {

	private String catalogId;
	private String invoiceId;
	private String name;
	private int amount; // kolicina
	private float price; // cena
	private float discount; // iznos rabata - Vrednost * Procenat rabata / 100
	private int discountPercentage; // rabat u %
	private float value; // vrednost = kolicina * cena
	private float itemBase; // osnovica pdv-a = Vrednost – Iznos rabata
	private int taxRate; // stopa pdva u procentima
	private float tax; // iznos poreza - Osnovica PDV * Stopa PDV / 100
	private float totalAmount; // prodajna vrednost: Vrednost – Iznos rabata + Iznos poreza
	
	public InvoiceItemDTO() {
		
	}

	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
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
