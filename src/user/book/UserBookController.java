package user.book;

import user.book.services.impl.UserRentalConfirm;
import user.book.services.impl.UserSearchBookRank;
import user.book.services.impl.UserSearchRentalList;
import user.container.UserContainer;

public class UserBookController {
    // 대여
    public void rentalConfirm(String title) {
        UserContainer.getInstance().getUserBookService().rentalConfirm(new UserRentalConfirm(title));

    }

    // 대여 리스트 조회
    public void SearchRentalList() {
        UserContainer.getInstance().getUserBookService().SearchRentalList(new UserSearchRentalList());

    }

    // 이달의 독서왕 조회
    public void searchBookRank() {
        UserContainer.getInstance().getUserBookService().SearchBookRank(new UserSearchBookRank());
    }
}
