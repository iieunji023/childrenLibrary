package user.book.impl;

import book.BookController;
import book.container.BookContainer;
import user.book.UserBookController;
import user.container.UserContainer;
import utils.BookDto;
import utils.PrintInfoCollection;

import java.util.List;
import java.util.Scanner;

public class UserBookRental implements IUserBook{
    @Override
    public void execute(Scanner scanner) {
        BookController bookController = BookContainer.getInstance().getBookController();
        UserBookController userBookContrller = UserContainer.getInstance().getUserBookContrller();

        // 책 조회
        scanner.nextLine();
        System.out.println("대여하실 책을 조회해주세요.");
        String title = scanner.nextLine();

        List<BookDto> bookDtos = null;
        if (!title.equals("")) {
            bookDtos = bookController.bookSearchCountConfirmByTitle(title);

            PrintInfoCollection.printBookListIncludeCount(bookDtos);

        }

        if(bookDtos != null && !bookDtos.isEmpty()) {
            // 대여
            System.out.println("대여하시겠습니까? (Y/N)");
            if(scanner.nextLine().equalsIgnoreCase("Y")){
                userBookContrller.rentalConfirm(title);

            }

        } else {
            System.out.println("대여가능한 책이 없습니다.");

        }

    }
}
