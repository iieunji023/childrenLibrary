package user.book;

import user.book.services.impl.IUserRentalConfirm;
import user.book.services.impl.IUserSearchBookRank;
import user.book.services.impl.IUserSearchRentalList;

public class UserBookService implements IUserBookService{
    @Override
    public void rentalConfirm(IUserRentalConfirm userRentalConfirm) {
        userRentalConfirm.execute();
    }

    @Override
    public void SearchRentalList(IUserSearchRentalList userSearchRentalList) {
        userSearchRentalList.execute();
    }

    // 이달의 독서왕 조회
    @Override
    public void SearchBookRank(IUserSearchBookRank userSearchBookRank) {
        userSearchBookRank.execute();
    }
}
