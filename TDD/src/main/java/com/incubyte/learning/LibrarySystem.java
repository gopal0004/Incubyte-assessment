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
		
		if(isbn == null) {
			throw new NullPointerException("without isbn you can't borrow book");
		}
		if(availableBooks.isEmpty()) {
			return false;
		}
		
		for(Book book : availableBooks) {
			if(book.getISBN().equals(isbn)) {
				availableBooks.remove(book);
				borrowedBooks.add(book);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean returnBook(String isbn) {
		
		if(isbn == null) {
			throw new NullPointerException("without isbn you can't borrow book");
		}
		if(borrowedBooks.isEmpty()) {
			return false;
		}
		
		for(Book book : borrowedBooks) {
			if(book.getISBN().equals(isbn)) {
				borrowedBooks.remove(book);
				availableBooks.add(book);
				return true;
			}
		}
		return false;
	}

	@Override
	public void viewBooks() {
		
	}

	

}
