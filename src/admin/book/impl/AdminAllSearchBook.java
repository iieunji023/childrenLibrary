package admin.book.impl;

import admin.book.AdminBookController;
import admin.container.AdminContainer;
import book.BookController;
import book.container.BookContainer;

import java.util.Scanner;

public class AdminAllSearchBook implements IAdminBook{
    @Override
    public void execute(Scanner scanner) {
        BookController bookController = BookContainer.getInstance().getBookController();

        bookController.bookAllSearchConfirm();

    }
}
