package ftn.poslovna.inf.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@XmlElement
	@Column
	private int invoiceNum;
	
	@XmlElement
	@Column
	private Date invoiceDate;
	
	@XmlElement
	@Column
	private Date currencyDate;
	
	@XmlElement
	@Column
	private Date accountingDate;
	
	@XmlElement
	@Column
	private float goodsTotal;
	
	@XmlElement
	@Column
	private float discount;
	
	@XmlElement
	@Column
	private float tax;
	
	@XmlElement
	@Column
	private float totalAmount;
	
	@XmlElement
	@Column
	private String accountNum;
	
	@XmlElement
	@Column
	private String accountNumExtra;
	
	@XmlElement
	@Column
	private InvoiceType invoiceType;
	
	@XmlElementWrapper(name="invoiceItems")
	@XmlElement(name="invoiceItem")
	@Column
	@OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<InvoiceItem> invoiceItems = new HashSet<InvoiceItem>();
	
	@ManyToOne
	@JoinColumn(name = "businessYear_id")
	private BusinessYear businessYear;
	
	@ManyToOne
	@JoinColumn(name = "buyer_id")
	private BusinessPartner buyer;
	
	@ManyToOne
	@JoinColumn(name = "seller_id")
	private BusinessPartner seller;
	
	@OneToOne(mappedBy = "invoice", 
            fetch = FetchType.LAZY)
	private DeliveryNote deliveryNote;
	
	public Invoice() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public InvoiceType getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(InvoiceType invoiceType) {
		this.invoiceType = invoiceType;
	}

	public Set<InvoiceItem> getInvoiceItems() {
		return invoiceItems;
	}

	public void setInvoiceItems(Set<InvoiceItem> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}

	public BusinessYear getBusinessYear() {
		return businessYear;
	}

	public void setBusinessYear(BusinessYear businessYear) {
		this.businessYear = businessYear;
	}
	
	public BusinessPartner getBuyer() {
		return buyer;
	}

	public void setBuyer(BusinessPartner buyer) {
		this.buyer = buyer;
	}

	public BusinessPartner getSeller() {
		return seller;
	}

	public void setSeller(BusinessPartner seller) {
		this.seller = seller;
	}

	public DeliveryNote getDeliveryNote() {
		return deliveryNote;
	}

	public void setDeliveryNote(DeliveryNote deliveryNote) {
		this.deliveryNote = deliveryNote;
	}
	
}
