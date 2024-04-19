package book.services.impl;

import book.container.BookContainer;
import utils.BookDto;

import java.util.List;

public class BookSearchCountConfirmByTitle implements IBookSearchCountConfirmByTitle{
    private String title;

    public BookSearchCountConfirmByTitle(String title) {
        this.title = title;
    }

    @Override
    public List<BookDto> execute() {
        return BookContainer.getInstance().getBookDao().selectBookCountByTitle(title);

    }
}
