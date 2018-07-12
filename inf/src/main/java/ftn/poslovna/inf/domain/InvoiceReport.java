package ftn.poslovna.inf.domain;

import java.util.Date;

public class InvoiceReport {
	
	private int invoiceNum;
	private Date invoiceDate;
	private Date currencyDate;
	private String accountNum;
	private String buyerName;
	
	private String invoiceItemName;
	private int itemAmount;	
	private float price; //cena
	private float discount; //iznos rabata - Vrednost * Procenat rabata / 100
	private float value; //vrednost = kolicina * cena
	private float itemBase; //osnovica pdv-a = Vrednost – Iznos rabata
	private float tax; //iznos poreza - Osnovica PDV * Stopa PDV / 100
	private float totalAmount; //prodajna vrednost: Vrednost – Iznos rabata + Iznos poreza
	
	private float goodsTotal;
	private float discountTotal;
	private float taxTotal;
	private float total;
	
	public InvoiceReport() {
		
	}

	public int getInvoiceNum() {
		return invoiceNum;
	}

	public void setInvoiceNum(int invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Date getCurrencyDate() {
		return currencyDate;
	}

	public void setCurrencyDate(Date currencyDate) {
		this.currencyDate = currencyDate;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getInvoiceItemName() {
		return invoiceItemName;
	}

	public void setInvoiceItemName(String invoiceItemName) {
		this.invoiceItemName = invoiceItemName;
	}

	public int getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(int itemAmount) {
		this.itemAmount = itemAmount;
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

	public float getGoodsTotal() {
		return goodsTotal;
	}

	public void setGoodsTotal(float goodsTotal) {
		this.goodsTotal = goodsTotal;
	}

	public float getDiscountTotal() {
		return discountTotal;
	}

	public void setDiscountTotal(float discountTotal) {
		this.discountTotal = discountTotal;
	}

	public float getTaxTotal() {
		return taxTotal;
	}

	public void setTaxTotal(float taxTotal) {
		this.taxTotal = taxTotal;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
	

}
