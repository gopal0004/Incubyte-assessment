package com.incubyte.learning;

import java.util.HashSet;
import java.util.Set;

public class LibrarySystem implements Operations {
	
	// using set data structure because its time complexity to add, remove and check is O(1) 
	Set<Book> availableBooks;
	Set<Book> borrowedBooks;
	
	public LibrarySystem() {
		availableBooks = new HashSet<Book>();
		borrowedBooks = new HashSet<Book>();
	}

	@Override
	public boolean addBook(Book book) {
		if(availableBooks.contains(book)) {
			throw new IllegalArgumentException("Book already exist");
		}
		return availableBooks.add(book);
	}

	@Override
	public boolean borrowBook(String isbn) {
		
		return false;
	}

	@Override
	public void returnBook(String isbn) {
		
	}

	@Override
	public void viewBooks() {
		
	}

	

}
