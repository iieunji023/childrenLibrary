package admin.book.service.impl;

import utils.BookDto;
import admin.config.BookAdminConfig;
import admin.container.AdminContainer;

public class AdminRegistBookConfirm implements IAdminRegistBookConfirm{
    private BookDto bookDto;
    public AdminRegistBookConfirm(BookDto bookDto) {
        this.bookDto = bookDto;

    }

    @Override
    public void execute() {
        int result = AdminContainer.getInstance().getAdminBookDao().insertBookInfo(bookDto);

        switch (result) {
            case BookAdminConfig.ADMIN_BOOK_REGIST_SUCCESS:
                System.out.println("책이 정상적으로 등록되었습니다.");
                break;

            case BookAdminConfig.ADMIN_BOOK_REGIST_FAIL:
                System.out.println("책 등록에 실패하였습니다.");
                break;

            case BookAdminConfig.DB_CONNECTION_ERROR:
                System.out.println("DB 연결에 실패하였습니다.");
                break;

        }
    }
}
