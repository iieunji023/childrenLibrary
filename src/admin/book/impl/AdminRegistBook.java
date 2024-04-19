package admin.book.impl;

import admin.book.AdminBookController;
import utils.BookDto;
import admin.container.AdminContainer;

import java.util.Scanner;

public class AdminRegistBook implements IAdminBook{
    @Override
    public void execute(Scanner scanner) {
        AdminBookController adminBookController = AdminContainer.getInstance().getAdminBookController();

        scanner.nextLine();

        System.out.println("카테고리를 입력하세요.(0.총류 1.철학 2.종교 3.사회과학 4.순수과학 5.기술과학 6.예술 7.언어 8.문학 9.역사 )");
        int category_no = scanner.nextInt();

        scanner.nextLine();

        System.out.println("책 제목을 입력하세요.");
        String title = scanner.nextLine();

        System.out.println("책 저자를 입력하세요.");
        String author = scanner.nextLine();

        System.out.println("책 출판사를 입력하세요.");
        String publisher = scanner.nextLine();

        BookDto bookDto = new BookDto(category_no, title, author, publisher);


        adminBookController.bookRegistConfirm(bookDto);

    }
}
