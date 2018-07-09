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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class BusinessYear {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private int yearNumber;

	@Column
	private boolean finished;

	@Column
	@OneToMany(mappedBy = "businessYear", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Invoice> invoices = new HashSet<Invoice>();;

	@Column
	@OneToMany(mappedBy = "businessYear", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Order> orders = new HashSet<Order>();

	@Column
	@OneToMany(mappedBy = "businessYear", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<DeliveryNote> deliveryNotes = new HashSet<DeliveryNote>();

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	public BusinessYear() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getYearNumber() {
		return yearNumber;
	}

	public void setYearNumber(int yearNumber) {
		this.yearNumber = yearNumber;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public Set<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(Set<Invoice> invoices) {
		this.invoices = invoices;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Set<DeliveryNote> getDeliveryNotes() {
		return deliveryNotes;
	}

	public void setDeliveryNotes(Set<DeliveryNote> deliveryNotes) {
		this.deliveryNotes = deliveryNotes;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
