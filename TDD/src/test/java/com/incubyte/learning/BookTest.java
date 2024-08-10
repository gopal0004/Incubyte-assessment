package com.incubyte.learning;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS) //because only once the object of library should be created
class BookTest {
	
	LibrarySystem library;

	@BeforeAll
	void init() {
		System.out.println("All Test cases of addBook are going to be executed");
		library = new LibrarySystem();
		System.out.println("object only created once");
	}
	
	
	@Test
	void testAddBook() {
		Book book = new Book("978-93-8067-432-2", "Client Server Computing", "Lalit Kumar", 2012);
		assertTrue(library.addBook(book));
	}
	
	@Test
	void testAddBookWithMissingTitle() {
		assertThrows(NullPointerException.class, () -> {
			new Book("978-93-5019-561-1", null, "Amit Garg", 2011);
		});
	}
	
	@Test
	void testAddBookWithDuplicateISBN() {
		Book book1 = new Book("978-93-5019-561-1", ".NET Framework & C#", "Sharad Kumar Verma", 2009);
		Book book2 = new Book("978-93-5019-561-1", "Publish News Letter", "Amit Garg", 2013);
		library.addBook(book1);
		assertThrows(IllegalArgumentException.class, ()-> library.addBook(book2));
	}
	
	@Test
	void testAddBookWithInvalidISBN() {

		assertThrows(IllegalArgumentException.class, () -> {
			new Book("InvalidISBN", "Publish News Letter", "Amit Garg", 2013);
		});	
	}
	
	@Test
	void testAddBookTimeOut() {
		Book book = new Book("999-22-1111-333-2", "Client Server Computing", "Sharad Kumar Verma", 2012);
		assertTimeout(Duration.ofMillis(1), () -> library.addBook(book));
	}
	
	@AfterAll
	void distroy() {
		System.out.println("All Test cases of addBook have been passed successfully");
	}
	

}
