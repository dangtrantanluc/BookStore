package model;

public class OrderDetail {
	private String idOrderDetail;
	private Order order;
	private Book idOfBook;
	private int amount;
	private double coverPrice;// gia bia
	private double discoount;// giam gia;
	private double vat;// thue vat;
	private double total;

	public OrderDetail() {

	}

	public OrderDetail(String idOrderDetail, Order order, Book idOfBook, int amount, double coverPrice,
			double discoount, double vat, double total) {
		super();
		this.idOrderDetail = idOrderDetail;
		this.order = order;
		this.idOfBook = idOfBook;
		this.amount = amount;
		this.coverPrice = coverPrice;
		this.discoount = discoount;
		this.vat = vat;
		this.total = total;
	}

	public String getIdOrderDetail() {
		return idOrderDetail;
	}

	public void setIdOrderDetail(String idOrderDetail) {
		this.idOrderDetail = idOrderDetail;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Book getIdOfBook() {
		return idOfBook;
	}

	public void setIdOfBook(Book idOfBook) {
		this.idOfBook = idOfBook;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getCoverPrice() {
		return coverPrice;
	}

	public void setCoverPrice(double coverPrice) {
		this.coverPrice = coverPrice;
	}

	public double getDiscoount() {
		return discoount;
	}

	public void setDiscoount(double discoount) {
		this.discoount = discoount;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
