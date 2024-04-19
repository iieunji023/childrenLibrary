package book;

import book.container.BookContainer;
import book.services.impl.AllSearchBookConfirm;
import book.services.impl.BookSearchConfrimbyTitle;
import book.services.impl.BookSearchCountConfirmByTitle;
import book.services.impl.VanOverdueConfirm;
import utils.BookDto;

import java.util.List;

public class BookController {
    // 책 제목 검색
    public List<BookDto> bookSearchConfirmbyTitle(String title) {
        return BookContainer.getInstance().getBookService().BookSearchConfirmbyTitle(new BookSearchConfrimbyTitle(title));

    }

    // 책 전체 조회
    public void bookAllSearchConfirm() {
        BookContainer.getInstance().getBookService().AllSearchBookConfirm(new AllSearchBookConfirm());

    }

    // 책 제목 검색(대여가능 권수)
    public List<BookDto> bookSearchCountConfirmByTitle(String title) {
        return BookContainer.getInstance().getBookService().bookSearchCountConfirmByTitle(new BookSearchCountConfirmByTitle(title));

    }
    
    // 연체 목록 조회
    public void vanOverdue(){
        BookContainer.getInstance().getBookService().vanOverdueConfirm(new VanOverdueConfirm());

    };

}
