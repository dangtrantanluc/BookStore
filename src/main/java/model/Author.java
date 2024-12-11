package model;

import java.sql.Date;

public class Author {
	private String idAuthor;
	private String name;
	private Date dateOfBirth;
	private String story;

	public Author() {

	}

	public Author(String idAuthor, String name, Date dateOfBirth, String story) {
		super();
		this.idAuthor = idAuthor;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.story = story;
	}

	public String getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(String idAuthor) {
		this.idAuthor = idAuthor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

}
