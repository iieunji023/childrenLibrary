package admin.book;

import admin.book.service.impl.*;
import utils.BookDto;

import java.util.List;

public interface IAdminBookService {
    public void AdminRegistBookConfirm(IAdminRegistBookConfirm adminRegistBookConfirm);
    public void AdminModifyBookConfirm(IAdminModifyBookConfirm adminModifyBookConfirm);
    public void AdminDeleteBookConfirm(IAdminDeleteBookConfirm adminDeleteBookConfirm);

}
