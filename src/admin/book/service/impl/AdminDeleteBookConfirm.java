package admin.book.service.impl;

import admin.container.AdminContainer;

public class AdminDeleteBookConfirm implements IAdminDeleteBookConfirm{
    private int no;
    public AdminDeleteBookConfirm(int no) {
        this.no = no;
    }

    @Override
    public void execute() {
        int result = AdminContainer.getInstance().getAdminBookDao().deleteBookInfo(no);

        if(result > 0) {
            System.out.printf("책이 정상적으로 삭제되었습니다. \n");

        }else {
            System.out.printf("삭제에 실패하였습니다. \n");

        }

    }
}
