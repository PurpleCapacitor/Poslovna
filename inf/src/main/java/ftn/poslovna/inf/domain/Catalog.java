package ftn.poslovna.inf.domain;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Catalog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
	private Group group;

	@Column
	@OneToMany(mappedBy = "catalog", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<PriceTableItem> priceTableItems = new HashSet<PriceTableItem>();

	@Column
	@OneToMany(mappedBy = "catalog", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<InvoiceItem> invoiceItems = new HashSet<InvoiceItem>();

	@Column
	@OneToMany(mappedBy = "catalog", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();

	@Column
	@OneToMany(mappedBy = "catalog", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<DeliveryNoteItem> deliveryNoteItems = new HashSet<DeliveryNoteItem>();

	public Catalog() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Set<PriceTableItem> getPriceTableItems() {
		return priceTableItems;
	}

	public void setPriceTableItems(Set<PriceTableItem> priceTableItems) {
		this.priceTableItems = priceTableItems;
	}

	public Set<InvoiceItem> getInvoiceItems() {
		return invoiceItems;
	}

	public void setInvoiceItems(Set<InvoiceItem> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Set<DeliveryNoteItem> getDeliveryNoteItems() {
		return deliveryNoteItems;
	}

	public void setDeliveryNoteItems(Set<DeliveryNoteItem> deliveryNoteItems) {
		this.deliveryNoteItems = deliveryNoteItems;
	}

}
