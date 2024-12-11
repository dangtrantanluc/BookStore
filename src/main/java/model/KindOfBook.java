package model;

public class KindOfBook {
	private String idKindOfBook;
	private String nameKindOfBook;

	public KindOfBook() {

	}

	public KindOfBook(String idKindOfBook, String nameKindOfBook) {
		super();
		this.idKindOfBook = idKindOfBook;
		this.nameKindOfBook = nameKindOfBook;
	}

	public String getIdKindOfBook() {
		return idKindOfBook;
	}

	public void setIdKindOfBook(String idKindOfBook) {
		this.idKindOfBook = idKindOfBook;
	}

	public String getNameKindOfBook() {
		return nameKindOfBook;
	}

	public void setNameKindOfBook(String nameKindOfBook) {
		this.nameKindOfBook = nameKindOfBook;
	}

}
