package admin.book.impl;

import book.BookController;
import book.container.BookContainer;
import utils.BookDto;
import utils.PrintInfoCollection;

import java.util.List;
import java.util.Scanner;

public class AdminSearchBook implements IAdminBook {
    @Override
    public void execute(Scanner scanner) {
        BookController bookController = BookContainer.getInstance().getBookController();
        scanner.nextLine();

        System.out.println("조회할 책 제목을 입력해주세요.");
        String title = scanner.nextLine();

        List<BookDto> bookDtos = bookController.bookSearchConfirmbyTitle(title);
        PrintInfoCollection.printBookList(bookDtos);

    }
}
