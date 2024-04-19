package user.book.impl;

import user.book.UserBookController;
import user.container.UserContainer;

import java.util.Scanner;

public class UserBookRentalList implements IUserBook{
    @Override
    public void execute(Scanner scanner) {
        UserBookController userBookContrller = UserContainer.getInstance().getUserBookContrller();
        // 대여 리스트 조회
        userBookContrller.SearchRentalList();

    }
}
