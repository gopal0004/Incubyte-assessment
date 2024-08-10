package com.incubyte.learning;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BorrowBookTest {

	LibrarySystem library;
	
	@BeforeAll
	void init() {
		library = new LibrarySystem();
	}
	
	@Test
	void testBorrowAvailableBooks() {
		Book book = new Book("978-93-8067-432-2", "Client Server Computing", "Lalit Kumar", 2012);
		library.addBook(book);
		assertTrue(library.borrowBook(book.getISBN()));
	}
	
	@Test
	void testBorrowBookNotInLibrary() {
		String isbn = "1234567890";
		assertFalse(library.borrowBook(isbn));
	}
	
	@Test
	void testBorrowBookWithNullISBN() {
		assertThrows(NullPointerException.class, () -> library.borrowBook(null));
	}
	
	@Test
	void testAlreadyBorrowedBook() {
		Book book = new Book("999-22-1111-333-2", "Client Server Computing", "Sharad Kumar Verma", 2012);
		library.addBook(book);
		library.borrowBook(book.getISBN());
		assertFalse(library.borrowBook(book.getISBN()));
	}
	
	@Test
	void testBorrowMultipleBooks() {
		Book book1 = new Book("978-93-5163-389-1", "Gunjan Verma", "CBOT", 2014);
		Book book2 = new Book("978-93-5019-561-1", "Publish News Letter", "Amit Garg", 2013);
		
		library.addBook(book1);
		library.addBook(book2);
		assertTrue(library.borrowBook(book1.getISBN()));
		assertTrue(library.borrowBook(book2.getISBN()));
	}
	
	@Test
	void testBorrowFromEmptyLibrary() {
		assertFalse(library.borrowBook("1234567890"));
	}
	
}
