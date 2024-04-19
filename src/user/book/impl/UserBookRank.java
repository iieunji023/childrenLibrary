package user.book.impl;

import user.book.UserBookController;
import user.container.UserContainer;

import java.util.Scanner;

public class UserBookRank implements IUserBook{
    @Override
    public void execute(Scanner scanner) {
        UserBookController userBookController = UserContainer.getInstance().getUserBookContrller();
        System.out.println("이달의 독서왕을 조회하시겠습니까? (Y/N)");
        scanner.nextLine();
        String ans = scanner.nextLine();

        if(ans.equalsIgnoreCase("Y")) {
            userBookController.searchBookRank();

        }

    }
}
