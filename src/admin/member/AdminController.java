package admin.member;

import admin.container.AdminContainer;
import admin.member.services.impl.*;

public class AdminController {
    
    // 회원가입
    public void signUpConfirm(AdminDto adminDto) {
        AdminContainer.getInstance().getAdminService().signUpConfirm(new AdminSignUpConfirm(adminDto));

    }

    // 로그인
    public void signInConfirm(AdminDto adminDto) {
        AdminContainer.getInstance().getAdminService().signInConfirm(new AdminSignInConfirm(adminDto));

    }

    // 회원정보수정
    public void modifyConfirm(AdminDto adminDto) {
        AdminContainer.getInstance().getAdminService().modifyConfirm(new AdminModifyConfirm(adminDto));

    }

    // 회원탈퇴
    public void deleteConfirm() {
        AdminContainer.getInstance().getAdminService().deleteConfirm(new AdminDeleteConfirm());

    }

    // 전체 유저 조회
    public void searchAllUserInfoByAdmin() {
        AdminContainer.getInstance().getAdminService().searchAllUserConfirm(new SearchAllUserConfirm());

    }
}
