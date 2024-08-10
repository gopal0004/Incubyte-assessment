package com.incubyte.learning;

public interface Operations {
	
	public boolean addBook(Book book);
	public boolean borrowBook(String isbn);
	public boolean returnBook(String isbn);
	public void viewBooks();
}
