package model;

public class Book {
	private String idBook;
	private String nameOfBook;
	private Author nameOfAuthor;
	private int yearOfManufacture;
	private double importPrice;// gia nhap
	private double price;// gia ban
	private double cost;// gia goc
	private int quatity;
	private String language;
	private String description;

	public Book() {

	}

	public Book(String idBook, String nameOfBook, Author nameOfAuthor, int yearOfManufacture, double importPrice,
			double price, double cost, int quatity, String language, String description) {
		super();
		this.idBook = idBook;
		this.nameOfBook = nameOfBook;
		this.nameOfAuthor = nameOfAuthor;
		this.yearOfManufacture = yearOfManufacture;
		this.importPrice = importPrice;
		this.price = price;
		this.cost = cost;
		this.quatity = quatity;
		this.language = language;
		this.description = description;
	}

	public String getIdBook() {
		return idBook;
	}

	public void setIdBook(String idBook) {
		this.idBook = idBook;
	}

	public String getNameOfBook() {
		return nameOfBook;
	}

	public void setNameOfBook(String nameOfBook) {
		this.nameOfBook = nameOfBook;
	}

	public Author getNameOfAuthor() {
		return nameOfAuthor;
	}

	public void setNameOfAuthor(Author nameOfAuthor) {
		this.nameOfAuthor = nameOfAuthor;
	}

	public int getYearOfManufacture() {
		return yearOfManufacture;
	}

	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuatity() {
		return quatity;
	}

	public void setQuatity(int quatity) {
		this.quatity = quatity;
	}

	public double getImportPrice() {
		return importPrice;
	}

	public void setImportPrice(double importPrice) {
		this.importPrice = importPrice;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
