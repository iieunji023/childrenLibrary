package admin.book;

import admin.book.service.impl.*;
import utils.BookDto;

import java.util.List;

public class AdminBookService implements IAdminBookService{
    // 책 등록
    @Override
    public void AdminRegistBookConfirm(IAdminRegistBookConfirm adminRegistBookConfirm) {
        adminRegistBookConfirm.execute();
        
    }

    // 책 수정
    @Override
    public void AdminModifyBookConfirm(IAdminModifyBookConfirm adminModifyBookConfirm) {
        adminModifyBookConfirm.execute();
    }

    // 책 삭제
    @Override
    public void AdminDeleteBookConfirm(IAdminDeleteBookConfirm adminDeleteBookConfirm) {
        adminDeleteBookConfirm.execute();
    }




}
