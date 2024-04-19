package admin.member.services.impl;

import admin.container.AdminContainer;
import admin.session.AdminSession;

public class AdminDeleteConfirm implements IAdminDeleteConfirm{
    @Override
    public void execute() {
        int no =AdminSession.getInstance().getAdminDto().getNo();

        int result = AdminContainer.getInstance().getAdminDao().DeleteAdmin(no);

        if(result > 0) {
            AdminSession.getInstance().setAdminDto(null);       // 로그인 세션 날려주기
            System.out.println("탈퇴되었습니다.");

        } else {
            System.out.println("탈퇴에 실패하였습니다.");

        }
    }
}
