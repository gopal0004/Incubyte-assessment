package com.incubyte.learning;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ViewAvailableBooksTest {

	LibrarySystem library;
	
	@BeforeAll
	void init() {
		library = new LibrarySystem();
		System.out.println("All test cases of viewAvailableBooks are going to be executed");
	}
	
	
	@Test
	void testViewAvailableBooks() {
		Book book1 = new Book("978-0-1234-5678-9", "Introduction to Algorithms", "Thomas H. Cormen", 2009);
		Book book2 = new Book("978-0-9876-5432-1", "Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma", 1994);
		library.addBook(book1);
		library.addBook(book2);
		
		Set<Book> availableBooks = library.viewBooks();
		assertTrue(availableBooks.contains(book1));
		assertTrue(availableBooks.contains(book2));
	}
	
	@Test
	void testViewAvailableBookInEmptyLibrary() {
		LibrarySystem library1 = new LibrarySystem();
		Set<Book> availableBooks = library1.viewBooks(); 
		assertTrue(availableBooks.isEmpty());
	}
	
	@Test
	void testViewAvailableBooksAfterBorrowingBook() {
		Book book1 = new Book("978-3-4567-8901-2", "Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin", 2008);
		Book book2 = new Book("978-0-5678-9101-1", "Artificial Intelligence: A Modern Approach", "Stuart Russell, Peter Norvig", 2010);
		
		assertTrue(library.addBook(book1));
		assertTrue(library.addBook(book2));
		assertTrue(library.borrowBook(book1.getISBN()));
		
		Set<Book> availableBooks = library.viewBooks();
		assertFalse(availableBooks.contains(book1)); 
	}
	
	
	@Test
	void testViewAvailableBooksAfterReturningBook() {
		Book book = new Book("978-93-5019-561-1", ".NET Framework & C#", "Sharad Kumar Verma", 2009);
		
		library.addBook(book);
		library.borrowBook(book.getISBN());
		library.returnBook(book.getISBN());
		
		Set<Book> availableBooks = library.viewBooks();
		assertTrue(availableBooks.contains(book));
	}
	
	@Test
    void testViewAvailableBooksTimeOut() {
		Book book1 = new Book("978-93-8067-432-2", "Client Server Computing", "Lalit Kumar", 2012);
		Book book2 = new Book("978-1-2345-6789-0", "The Pragmatic Programmer: Your Journey to Mastery", "Andrew Hunt", 1999);
        library.addBook(book1);
        library.addBook(book2);

        assertTimeout(Duration.ofMillis(100), () -> {
            Set<Book> availableBooks = library.viewBooks();
            assertTrue(availableBooks.contains(book1));
            assertTrue(availableBooks.contains(book2));
        });
    }
	
	@AfterAll
	void distroy() {
		System.out.println("All test cases of viewAvailableBooks have been passed successfully");
	}
	
	

}
 