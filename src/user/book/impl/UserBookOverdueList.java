package user.book.impl;

import book.BookController;
import book.container.BookContainer;

import java.util.Scanner;

public class UserBookOverdueList implements IUserBook{
    @Override
    public void execute(Scanner scanner) {
        BookController bookController = BookContainer.getInstance().getBookController();
        // 연체목록
        bookController.vanOverdue();
        
    }
}
