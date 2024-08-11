package com.incubyte.learning;

import java.util.Set;

public interface Operations {
	
	public boolean addBook(Book book);
	public boolean borrowBook(String isbn);
	public boolean returnBook(String isbn);
	public Set<Book> viewBooks();
}
