package admin.book;

import admin.book.service.impl.*;
import admin.container.AdminContainer;
import utils.BookDto;

import java.util.List;

public class AdminBookController {
    // 책 등록
    public void bookRegistConfirm(BookDto bookDto) {
        AdminContainer.getInstance().getAdminBookService().AdminRegistBookConfirm(new AdminRegistBookConfirm(bookDto));

    }

    // 책 수정
    public void bookModifyConfirm(BookDto bookDto) {
        AdminContainer.getInstance().getAdminBookService().AdminModifyBookConfirm(new AdminModifyBookConfirm(bookDto));

    }

    // 책 삭제
    public void bookDeleteConfirm(int no) {
        AdminContainer.getInstance().getAdminBookService().AdminDeleteBookConfirm(new AdminDeleteBookConfirm(no));

    }


}
