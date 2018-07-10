package ftn.poslovna.inf.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import ftn.poslovna.inf.domain.BusinessPartner;
import ftn.poslovna.inf.domain.BusinessYear;
import ftn.poslovna.inf.domain.DeliveryNote;
import ftn.poslovna.inf.domain.InvoiceType;

public class InvoiceDTO {

	private long id;	
	private int invoiceNum;
	private Date invoiceDate;
	private Date currencyDate;
	private Date accountingDate;
	private float goodsTotal;
	private float discount;
	private float tax;
	private float totalAmount;
	private String accountNum;
	private String accountNumExtra;
	private String invoiceType;	
	private long businessYearId;
	private long buyerId;
	private long sellerId;
	private long deliveryNoteId;
	
	public InvoiceDTO(){
		
	}
	
	public InvoiceDTO(long id, int invoiceNum, Date invoiceDate, Date currencyDate, Date accountingDate,
			float goodsTotal, float discount, float tax, float totalAmount, String accountNum, String accountNumExtra,
			String invoiceType, long businessYearId, long buyerId, long sellerId, long deliveryNoteId) {
		super();
		this.id = id;
		this.invoiceNum = invoiceNum;
		this.invoiceDate = invoiceDate;
		this.currencyDate = currencyDate;
		this.accountingDate = accountingDate;
		this.goodsTotal = goodsTotal;
		this.discount = discount;
		this.tax = tax;
		this.totalAmount = totalAmount;
		this.accountNum = accountNum;
		this.accountNumExtra = accountNumExtra;
		this.invoiceType = invoiceType;
		this.businessYearId = businessYearId;
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.deliveryNoteId = deliveryNoteId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public Date getAccountingDate() {
		return accountingDate;
	}
	public void setAccountingDate(Date accountingDate) {
		this.accountingDate = accountingDate;
	}
	public float getGoodsTotal() {
		return goodsTotal;
	}
	public void setGoodsTotal(float goodsTotal) {
		this.goodsTotal = goodsTotal;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
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
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public String getAccountNumExtra() {
		return accountNumExtra;
	}
	public void setAccountNumExtra(String accountNumExtra) {
		this.accountNumExtra = accountNumExtra;
	}
	public String getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	public long getBusinessYearId() {
		return businessYearId;
	}
	public void setBusinessYearId(long businessYearId) {
		this.businessYearId = businessYearId;
	}	
	public long getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(long buyerId) {
		this.buyerId = buyerId;
	}
	public long getSellerId() {
		return sellerId;
	}
	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}
	public long getDeliveryNoteId() {
		return deliveryNoteId;
	}
	public void setDeliveryNoteId(long deliveryNoteId) {
		this.deliveryNoteId = deliveryNoteId;
	}
	
	
	
	
}
