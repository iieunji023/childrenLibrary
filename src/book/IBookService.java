package book;

import book.services.impl.IAllSearchBookConfirm;
import book.services.impl.IBookSearchConfirmbyTitle;
import book.services.impl.IBookSearchCountConfirmByTitle;
import book.services.impl.IVanOverdueConfirm;
import utils.BookDto;

import java.util.List;

public interface IBookService {
    public List<BookDto> BookSearchConfirmbyTitle(IBookSearchConfirmbyTitle bookSearchConfirmbyTitle);
    public void AllSearchBookConfirm(IAllSearchBookConfirm AllSearchBookConfirm);
    public List<BookDto> bookSearchCountConfirmByTitle(IBookSearchCountConfirmByTitle bookSearchCountConfirmByTitle);
    public void vanOverdueConfirm(IVanOverdueConfirm userVanOverdueConfirm);
}
