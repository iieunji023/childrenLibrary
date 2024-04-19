package admin.member.services.impl;

import admin.config.BookAdminConfig;
import admin.container.AdminContainer;
import admin.member.AdminDto;

public class AdminSignUpConfirm implements IAdminSignUpConfirm{
    private AdminDto adminDto;

    public AdminSignUpConfirm(AdminDto adminDto) {
        this.adminDto = adminDto;

    }

    @Override
    public void excute() {
        // 중복확인
        Boolean isAdmin = AdminContainer.getInstance().getAdminDao().isAdminExist(adminDto);

        // 회원가입
        if(!isAdmin) {      // 아이디 중복이 되지 않는 경우
            int result = AdminContainer.getInstance().getAdminDao().insertAdminSignUpInfo(adminDto);

            switch (result) {
                case BookAdminConfig.ADMIN_SIGN_UP_SUCCESS:
                    System.out.println("회원가입을 성공하였습니다.");

                    break;

                case BookAdminConfig.ADMIN_SIGN_UP_FAIL:
                    System.out.println("회원가입에 실패하였습니다.");

                    break;

                case BookAdminConfig.DB_CONNECTION_ERROR:
                    System.out.println("DB CONNECTION ERROR!!");        // DB 접속 실패

                    break;

            }

        } else {
            System.out.println("이미 존재하는 아이디입니다.");

        }

    }

}
