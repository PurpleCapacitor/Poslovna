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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private int invoiceNum;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date invoiceDate;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date currencyDate;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date accountingDate;
	
	@Column
	private float goodsTotal;
	
	@Column
	private float discount;
	
	@Column
	private float tax;
	
	@Column
	private float totalAmount;
	
	@Column
	private String accountNum;
	
	@Column
	private String accountNumExtra;
	
	@Column
	private InvoiceType invoiceType;
		
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

	@XmlElement
	public void setId(Long id) {
		this.id = id;
	}

	public int getInvoiceNum() {
		return invoiceNum;
	}
	
	@XmlElement
	public void setInvoiceNum(int invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	@XmlElement
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Date getCurrencyDate() {
		return currencyDate;
	}

	@XmlElement
	public void setCurrencyDate(Date currencyDate) {
		this.currencyDate = currencyDate;
	}

	public Date getAccountingDate() {
		return accountingDate;
	}

	@XmlElement
	public void setAccountingDate(Date accountingDate) {
		this.accountingDate = accountingDate;
	}

	public float getGoodsTotal() {
		return goodsTotal;
	}

	@XmlElement
	public void setGoodsTotal(float goodsTotal) {
		this.goodsTotal = goodsTotal;
	}

	public float getDiscount() {
		return discount;
	}

	@XmlElement
	public void setDiscount(float discount) {
		this.discount = discount;
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

	public String getAccountNum() {
		return accountNum;
	}

	@XmlElement
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getAccountNumExtra() {
		return accountNumExtra;
	}

	@XmlElement
	public void setAccountNumExtra(String accountNumExtra) {
		this.accountNumExtra = accountNumExtra;
	}

	public InvoiceType getInvoiceType() {
		return invoiceType;
	}

	@XmlElement
	public void setInvoiceType(InvoiceType invoiceType) {
		this.invoiceType = invoiceType;
	}
	
	public Set<InvoiceItem> getInvoiceItems() {
		return invoiceItems;
	}

	@XmlElement(name="invoiceItem")
	public void setInvoiceItems(Set<InvoiceItem> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}

	public BusinessYear getBusinessYear() {
		return businessYear;
	}

	@XmlTransient
	public void setBusinessYear(BusinessYear businessYear) {
		this.businessYear = businessYear;
	}
	
	public BusinessPartner getBuyer() {
		return buyer;
	}

	@XmlTransient
	public void setBuyer(BusinessPartner buyer) {
		this.buyer = buyer;
	}

	public BusinessPartner getSeller() {
		return seller;
	}

	@XmlTransient
	public void setSeller(BusinessPartner seller) {
		this.seller = seller;
	}

	public DeliveryNote getDeliveryNote() {
		return deliveryNote;
	}

	@XmlTransient
	public void setDeliveryNote(DeliveryNote deliveryNote) {
		this.deliveryNote = deliveryNote;
	}
	
}
