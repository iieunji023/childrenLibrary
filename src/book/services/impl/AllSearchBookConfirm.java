package book.services.impl;

import admin.container.AdminContainer;
import book.container.BookContainer;
import utils.BookDto;
import utils.PrintInfoCollection;

import java.util.List;

public class AllSearchBookConfirm implements IAllSearchBookConfirm {
    @Override
    public void execute() {
        List<BookDto> bookDtos = BookContainer.getInstance().getBookDao().selectAllBookInfo();

        PrintInfoCollection.printBookList(bookDtos);

    }
}
