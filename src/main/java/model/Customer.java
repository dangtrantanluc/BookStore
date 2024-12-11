package model;

import java.sql.Date;

public class Customer {
	private String idClient;
	private String username;
	private String password;
	private String fullName;
	private String sex;
	private String address;
	private String deliveryAddress;// dia chi nha hang
	private String invoiceAddress;// dia chi hoa don
	private Date dayOfBirth;
	private int number;
	private String email;
	private boolean signUpToReceiveEmail;// dang ki nhan email

	public Customer() {

	}

	public Customer(String idClient, String username, String password, String fullName, String sex, String address,
			String deliveryAddress, String invoiceAddress, Date dayOfBirth, int number, String email,
			boolean signUpToReceiveEmail) {
		super();
		this.idClient = idClient;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.sex = sex;
		this.address = address;
		this.deliveryAddress = deliveryAddress;
		this.invoiceAddress = invoiceAddress;
		this.dayOfBirth = dayOfBirth;
		this.number = number;
		this.email = email;
		this.signUpToReceiveEmail = signUpToReceiveEmail;
	}

	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getInvoiceAddress() {
		return invoiceAddress;
	}

	public void setInvoiceAddress(String invoiceAddress) {
		this.invoiceAddress = invoiceAddress;
	}

	public Date getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(Date dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getSignUpToReceiveEmail() {
		return signUpToReceiveEmail;
	}

	public void setSignUpToReceiveEmail(boolean signUpToReceiveEmail) {
		this.signUpToReceiveEmail = signUpToReceiveEmail;
	}

}