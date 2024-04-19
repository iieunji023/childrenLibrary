package user.book.services.impl;

import book.RentalDto;
import user.container.UserContainer;
import user.member.UserDto;
import user.session.UserSession;

import java.util.List;

public class UserSearchBookRank implements IUserSearchBookRank{

    @Override
    public void execute() {
        List<RentalDto> rentalDtoList = UserContainer.getInstance().getUserBookDao().selectUserBookRanking();
        int user_no = rentalDtoList.get(0).getUser_no();
        String u_name = UserContainer.getInstance().getUserBookDao().selectUserInfo(user_no);

        System.out.printf("""
                           ──────────────────────────────────────
                           🤴이달의 독서왕🤴
                           이름: %s
                           달성: %d권
                           ──────────────────────────────────────
                           """, u_name, rentalDtoList.get(0).getCount());

    }
}
