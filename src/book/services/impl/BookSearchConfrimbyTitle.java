package book.services.impl;

import admin.container.AdminContainer;
import book.container.BookContainer;
import utils.BookDto;

import java.util.List;

public class BookSearchConfrimbyTitle implements IBookSearchConfirmbyTitle {
    private String title;

    public BookSearchConfrimbyTitle(String title) {
        this.title = title;
    }

    @Override
    public List<BookDto> execute() {
        // null일 떄 기존의 값 저장하기 위해 DB에 저장된 값 가져오기(책 수정할 때 사용하기 위함)
        List<BookDto> bookDtos = BookContainer.getInstance().getBookDao().selectBookInfoByTitle(title);

        return bookDtos;

    }
}
