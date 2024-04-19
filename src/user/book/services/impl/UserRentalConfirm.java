package user.book.services.impl;

import book.RentalDto;
import user.container.UserContainer;
import user.session.UserSession;

import java.util.List;

public class UserRentalConfirm implements IUserRentalConfirm{
    private String title;

    public UserRentalConfirm(String title) {
        this.title = title;

    }

    @Override
    public void execute() {
        // title로 검색 후, 가장 작은 no값을 가져온다.
        int book_no = UserContainer.getInstance().getUserBookDao().selectNoForRental(title);
        int loginedUserNo = UserSession.getInstance().getUserDto().getNo();

        // 한사람당 최대 2권 대여 가능
        int rentalTotal = UserContainer.getInstance().getUserBookDao().selectRentalCount(loginedUserNo);
        // 연체테이블 USER_NO 조회
        List<RentalDto> rentalDtos = UserContainer.getInstance().getUserBookDao().selectOverdue(loginedUserNo);

        if(rentalTotal < 2 && rentalDtos.size() <= 0) {
            int result = UserContainer.getInstance().getUserBookDao().updateBookingYn(book_no);

            if(result > 0) {
                int res = UserContainer.getInstance().getUserBookDao().insertRentalInfo(book_no, loginedUserNo);
                if(res > 0) {
                    System.out.println("대여가 완료되었습니다.");

                } else {
                    System.out.println("대여에 실패하였습니다.");

                }
            }

        } else if(rentalDtos.size() > 0) {
            for(RentalDto rentalDto : rentalDtos) {
                String overdue_date = rentalDto.getOverDueDate();

                UserContainer.getInstance().getUserBookDao().updateBookingYn(book_no);
                int r = UserContainer.getInstance().getUserBookDao().insertRentalInfoExistOverdue(book_no, loginedUserNo, overdue_date);

                if (r > 0) {
                    System.out.println("대여가 완료되었습니다. ");

                } else {
                    System.out.printf("[연체] %s까지 대여가 불가능합니다. \n", overdue_date);

                }
            }
        }else{
            System.out.println("최대 대여횟수를 초과하였습니다.");

        }
    }
}
