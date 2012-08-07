package hibernate.dao;

import java.util.Set;

public class Person {
	private int id = -1;
	private String name = null;
	
	@SuppressWarnings("unchecked")
	private Set books = null;
	
	@SuppressWarnings("unchecked")
	public Set getBooks() {
		return books;
	}

	@SuppressWarnings("unchecked")
	public void setBooks(Set books) {
		this.books = books;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
