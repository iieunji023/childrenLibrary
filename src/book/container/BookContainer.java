package book.container;

import book.BookController;
import book.BookDao;
import book.BookService;

public class BookContainer {
    private static BookContainer bookContainer;

    private BookController bookController;
    private BookService bookService;
    private BookDao bookDao;


    // CONSTRUCTOR
    private BookContainer() {

    }

    // METHOD
    public static BookContainer getInstance(){
        if(bookContainer == null) {
            bookContainer = new BookContainer();

        }
        return bookContainer;

    }

    public BookController getBookController() {
        return bookController;
    }

    public void setBookController(BookController bookController) {
        this.bookController = bookController;
    }

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public BookDao getBookDao() {
        return bookDao;
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
