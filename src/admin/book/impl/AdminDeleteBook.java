package admin.book.impl;

import admin.book.AdminBookController;
import book.container.BookContainer;
import book.BookController;
import utils.BookDto;
import admin.container.AdminContainer;
import utils.PrintInfoCollection;

import java.util.List;
import java.util.Scanner;

public class AdminDeleteBook implements IAdminBook{
    @Override
    public void execute(Scanner scanner) {
        BookController bookController = BookContainer.getInstance().getBookController();
        AdminBookController adminBookController = AdminContainer.getInstance().getAdminBookController();

        scanner.nextLine();
        System.out.printf("삭제할 책 제목을 입력해주세요.");
        String title = scanner.nextLine();

        List<BookDto> bookDtos= bookController.bookSearchConfirmbyTitle(title);

        PrintInfoCollection.printBookList(bookDtos);

        System.out.println("삭제할 책 번호를 입력해주세요.");
        int no = scanner.nextInt();
        scanner.nextLine();

        adminBookController.bookDeleteConfirm(no);


    }
}
