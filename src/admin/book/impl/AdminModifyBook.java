package admin.book.impl;

import admin.book.AdminBookController;
import book.container.BookContainer;
import book.BookController;
import utils.BookDto;
import admin.container.AdminContainer;
import utils.PrintInfoCollection;

import java.util.List;
import java.util.Scanner;

public class AdminModifyBook implements IAdminBook{
    @Override
    public void execute(Scanner scanner) {
        BookController bookController = BookContainer.getInstance().getBookController();
        AdminBookController adminBookController = AdminContainer.getInstance().getAdminBookController();

        scanner.nextLine();

        System.out.println("변경할 책 제목을 입력해주세요.");
        String title = scanner.nextLine();

        List<BookDto> bookDtos= bookController.bookSearchConfirmbyTitle(title);

        PrintInfoCollection.printBookList(bookDtos);

        System.out.println("변경할 책 번호를 입력해주세요.");
        int no = scanner.nextInt();
        scanner.nextLine();

        System.out.println("변경할 카테고리를 입력해주세요. (0. 총류 1. 철학 2. 종교 3. 사회과학 4. 순수과학 5. 기술과학 6. 예술 7. 언어 8. 문학 9. 역사 )");
        int category_no = scanner.nextInt();
        scanner.nextLine();
        System.out.println("변경할 제목을 입력해주세요.");
        title = scanner.nextLine();
        System.out.println("변경할 저자를 입력해주세요.");
        String author = scanner.nextLine();
        System.out.println("변경할 출판사를 입력해주세요.");
        String publisher = scanner.nextLine();

        BookDto bookDto = new BookDto(no, category_no, title, author, publisher);

        adminBookController.bookModifyConfirm(bookDto);

    }


}
