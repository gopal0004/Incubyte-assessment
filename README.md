create interface of methods that is implemented by Book class 
create junit test file  of addBookTest and wrote cases to test
create library class for library system has meyhods addBook, borrowBook, returnBook, and viewAvailableBooks

for theose operations i used Set data structure because of its time complexity to add,remove, check 

define body of the method addBook in which write logic to test below given cases
test several cases like addBook with full details, addBook with missing title throws exception, addBook with duplicates ISBN throws exception, 
and at lasted tested TimeOut assertion to know time complexity and time to execute the operation to addBook.

create new test class for BorrowBookTest
write test cases of borrowBook like normaly borrow book with isbn, borrow book not in library, borrow book with null isbn, borror aalready borrowed book by isbn,
borrow multiplebooks, borrowBook from empty library, 
and also test assertTime to acknowledge the time it takes to perform operation

write logic in borrowBook method to test above cases


create test class for ReturnBook 
in which i write cases like : returnBook , return book that not borrowed, want to return book that not in library, return book without isbn,
return multiple books , and assertTime to know time it takes to perform
define logic of returnBook to test those cases


create test class for View Available books
in which i wrote cases like : view available books, view available books after borrow books, view books after returning book, 
and assertion timeout to know time duration. 
