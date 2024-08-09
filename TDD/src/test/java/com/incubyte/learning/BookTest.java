package com.incubyte.learning;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BookTest {
	
	LibrarySystem librarry;

	@BeforeAll
	static void beforeAll() {
		System.out.println("All Test are going to be executed");
	}
	
	@BeforeEach
	void init() {
		librarry = new LibrarySystem();
	}
	
	
	@Test
	void testAddBook() {
		Book book = new Book("978-93-8067-432-2", "Client Server Computing", "Lalit Kumar", 2012);
		assertTrue(librarry.addBook(book));
	}

}
