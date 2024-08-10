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
	void test() {
		String isbn = "978-93-8067-432-2";
		assertEquals(isbn, library.borrowBook(isbn));
	}

}
