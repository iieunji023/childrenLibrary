package user.book;

import user.book.services.impl.*;

public interface IUserBookService {
    void rentalConfirm(IUserRentalConfirm userRentalConfirm);
    void SearchRentalList(IUserSearchRentalList userSearchRentalList);
    void SearchBookRank(IUserSearchBookRank userSearchBookRank);
}
