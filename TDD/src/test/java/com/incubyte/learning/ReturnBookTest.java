package com.incubyte.learning;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

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
		Book book = new Book("978-0-5678-9101-1", "Artificial Intelligence: A Modern Approach", "Stuart Russell, Peter Norvig", 2010);
		library.addBook(book);
		library.borrowBook(book.getISBN());
		
		assertTrue(library.returnBook(book.getISBN()));
	}
	
	@Test
    void testReturnBookNotBorrowed() {
		Book book = new Book("978-1-2345-6789-0", "The Pragmatic Programmer: Your Journey to Mastery", "Andrew Hunt", 1999);
        library.addBook(book);
        assertFalse(library.returnBook(book.getISBN()));
    }
	
	@Test
    void testReturnBookNotInLibrary() {
        assertFalse(library.returnBook("1234567890"));
    }
	
	@Test
    void testReturnBookWithNullISBN() {
        assertThrows(NullPointerException.class, () -> library.returnBook(null));
    }
	
	@Test 
	void testReturnMultipleBooks() {
		Book book1 = new Book("978-0-1234-5678-9", "Introduction to Algorithms", "Thomas H. Cormen", 2009);
		Book book2 = new Book("978-0-9876-5432-1", "Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma", 1994);
		
		library.addBook(book1);
		library.addBook(book2);
		library.borrowBook(book1.getISBN());
		library.borrowBook(book2.getISBN());
		
		assertTrue(library.returnBook(book1.getISBN()));
		assertTrue(library.returnBook(book2.getISBN()));
	}
	
	@Test
	void testReturnBookTimeOut() {
		Book book = new Book("978-3-4567-8901-2", "Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin", 2008);
		assertTimeout(Duration.ofMillis(1), () -> library.addBook(book));
		assertTimeout(Duration.ofMillis(1), () -> library.borrowBook(book.getISBN()));
		assertTimeout(Duration.ofMillis(1), () -> library.returnBook(book.getISBN()));
	}
	

}
