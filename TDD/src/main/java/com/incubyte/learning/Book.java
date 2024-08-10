package com.incubyte.learning;

import java.util.Objects;

public class Book {
	
	String isbn;
	String title;
	String author;
	int year;
	
	public Book(String isbn, String title, String author, int year) {
		if (isbn == null || title == null || author == null) {
            throw new NullPointerException("ISBN, Title, and Author must not be null.");
        }
        if (year <= 0) { // Assuming year should be a positive integer
            throw new IllegalArgumentException("Year must be a positive integer.");
        }
        if (!isbn.matches("[0-9-]+")) {
            throw new IllegalArgumentException("ISBN must only contain digits and hyphens.");
        }
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.year = year;
	}
	
	public String getISBN() {
		return isbn;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getYear() {
		return year;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		Book book = (Book) o;
		return isbn.equals(book.isbn);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}
	
	
	
}
