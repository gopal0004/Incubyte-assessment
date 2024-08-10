package com.incubyte.learning;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ReturnBookTest {

	LibrarySystem library;
	
	@BeforeAll
	void init() {
		library = new LibrarySystem();
	}
	
	@Test
	void testReturnBook() {
		Book book = new Book("978-93-8067-432-2", "Client Server Computing", "Lalit Kumar", 2012);
		library.addBook(book);
		library.borrowBook(book.getISBN());
		
		assertTrue(library.returnBook(book.getISBN()));
	}

}
