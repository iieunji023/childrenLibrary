package user.member.services.impl;

import user.container.UserContainer;
import user.session.UserSession;

public class UserDeleteConfirm implements IUserDeleteConfirm{
    @Override
    public void execute() {
        int no = UserSession.getInstance().getUserDto().getNo();

        int result = UserContainer.getInstance().getUserDao().deleteUser(no);

        if(result > 0) {
            System.out.println("탈퇴되었습니다.");

        } else {
            System.out.println("탈퇴에 실패하였습니다.");

        }

    }
}
