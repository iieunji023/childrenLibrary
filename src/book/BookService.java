package book;

import book.services.impl.IAllSearchBookConfirm;
import book.services.impl.IBookSearchConfirmbyTitle;
import book.services.impl.IBookSearchCountConfirmByTitle;
import book.services.impl.IVanOverdueConfirm;
import user.session.UserSession;
import utils.BookDto;

import java.util.List;

public class BookService implements IBookService{
    // 책 제목 검색(수정하기 위함)
    @Override
    public List<BookDto> BookSearchConfirmbyTitle(IBookSearchConfirmbyTitle bookSearchConfirmbyTitle) {
        return bookSearchConfirmbyTitle.execute();

    }

    // 책 전체 조회
    @Override
    public void AllSearchBookConfirm(IAllSearchBookConfirm AllSearchBookConfirm) {
        AllSearchBookConfirm.execute();

    }

    // 책 제목 검색(대여가능권수)
    @Override
    public List<BookDto> bookSearchCountConfirmByTitle(IBookSearchCountConfirmByTitle bookSearchCountConfirmByTitle){
        return bookSearchCountConfirmByTitle.execute();

    }

    // 연체 목록 조회
    @Override
    public void vanOverdueConfirm(IVanOverdueConfirm userVanOverdueConfirm) {
        userVanOverdueConfirm.execute();

    }
}
