package book.services.impl;

import book.RentalDto;
import book.container.BookContainer;
import user.session.UserSession;

import java.util.List;

public class VanOverdueConfirm implements IVanOverdueConfirm {
    @Override
    public void execute() {
        /*
         * 연체
         * 1. FINISHED_AT(실제 반납일) - FINISHED_DATE(반납 예정일) 시 양수면 그 기간만큼 연체
         * 2. FINISHED_DATE이 지났는데 FINISHED_AT = null인 경우 연체
         */
        int u_no = 0;
        if(UserSession.getInstance().getUserDto()!=null) {
            u_no = UserSession.getInstance().getUserDto().getNo();
        }

        // FINISHED_AT(실제 반납일) - FINISHED_DATE(반납 예정일) 구하기 - 양수일 경우 그 기간만큼 연체
        List<RentalDto> overDueDate = BookContainer.getInstance().getBookDao().selectOverdueDate(u_no);
        List<RentalDto> overDueDateByNull = BookContainer.getInstance().getBookDao().selectOverdueDateByNull(u_no);

            for (RentalDto dto : overDueDate) {
                // OVERDUE TABLE에 INSERT
                int r_no = dto.getNo();
                String overdueDate = dto.getOverDueDate();

                // 연체테이블 r_no 값 찾기
                boolean isRNo = BookContainer.getInstance().getBookDao().selectRNoForOverdue(r_no);

                if (overdueDate != null && Integer.parseInt(overdueDate) > 0 && !isRNo) {      // 연체가 되었을때만, 연체테이블에 r_no값이 존재하지 않을때만
                    String finisedAt = dto.getFinished_at();
                    int result = BookContainer.getInstance().getBookDao().insertOverdue(r_no, finisedAt, overdueDate);
                    if(result > 0) {
                        System.out.printf("%s일 연체되었습니다. \n", overdueDate);

                    }else {
                        System.out.println("연체목록에 이미 저장");

                    }
                }
            }

        // FINISHED_AT(실제반납일)이 null인 경우
        for(RentalDto dto : overDueDateByNull) {
            int r_no = dto.getNo();
            String overdueDate = dto.getOverDueDate();
            String finishedAt = dto.getFinished_at();

            // 연체테이블 r_no 값 찾기
            boolean isRNo = BookContainer.getInstance().getBookDao().selectRNoForOverdue(r_no);

            if (finishedAt == null && Integer.parseInt(overdueDate) > 0 && !isRNo) {
                int result = BookContainer.getInstance().getBookDao().insertOverdueByNull(r_no, overdueDate);
                if(result > 0) {
                    System.out.printf("%s일 연체되었습니다. \n", overdueDate);

                }else {
                    System.out.println("연체목록에 이미 저장");

                }
            } else{
                System.out.println("연체된 도서 목록이 존재하지 않습니다.");

            }
        }
    }
}
