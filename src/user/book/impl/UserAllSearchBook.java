package user.book.impl;

import book.BookController;
import book.container.BookContainer;

import java.util.Scanner;

public class UserAllSearchBook implements IUserBook{

    @Override
    public void execute(Scanner scanner) {
        BookController bookController = BookContainer.getInstance().getBookController();

        bookController.bookAllSearchConfirm();

    }


}
