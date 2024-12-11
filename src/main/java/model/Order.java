package model;

import java.sql.Date;

public class Order {
	private String idOrder;
	private Customer client;
	private String purchaseAddress;// dia chi mua hang
	private String addressCline;
	private String status;// trang thai mua hang
	private String payments;
	private String statusPayments;// trang thai thanh toan
	private String paymentAmount;// so tien thanh toan
	private String amountOwed;// so tien con thieu
	private Date dateOrder;
	private Date dateDelivery;

	public Order() {

	}

	public Order(String idOrder, Customer client, String purchaseAddress, String addressCline, String status,
			String payments, String statusPayments, String paymentAmount, String amountOwed) {
		super();
		this.idOrder = idOrder;
		this.client = client;
		this.purchaseAddress = purchaseAddress;
		this.addressCline = addressCline;
		this.status = status;
		this.payments = payments;
		this.statusPayments = statusPayments;
		this.paymentAmount = paymentAmount;
		this.amountOwed = amountOwed;
	}

	public String getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}

	public Customer getClient() {
		return client;
	}

	public void setClient(Customer client) {
		this.client = client;
	}

	public String getPurchaseAddress() {
		return purchaseAddress;
	}

	public void setPurchaseAddress(String purchaseAddress) {
		this.purchaseAddress = purchaseAddress;
	}

	public String getAddressCline() {
		return addressCline;
	}

	public void setAddressCline(String addressCline) {
		this.addressCline = addressCline;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayments() {
		return payments;
	}

	public void setPayments(String payments) {
		this.payments = payments;
	}

	public String getStatusPayments() {
		return statusPayments;
	}

	public void setStatusPayments(String statusPayments) {
		this.statusPayments = statusPayments;
	}

	public String getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getAmountOwed() {
		return amountOwed;
	}

	public void setAmountOwed(String amountOwed) {
		this.amountOwed = amountOwed;
	}

}
