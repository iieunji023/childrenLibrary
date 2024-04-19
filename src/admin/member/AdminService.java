package admin.member;

import admin.member.services.impl.*;

public class AdminService implements IAdminService {
    /*
     * SERVICE단의 확장성을 위해서
     */
    // 회원가입
    @Override
    public void signUpConfirm(IAdminSignUpConfirm adminSignUpConfirm) {
        adminSignUpConfirm.excute();

    }

    // 로그인
    @Override
    public void signInConfirm(IAdminSignInConfirm adminSignInConfirm) {
        adminSignInConfirm.execute();

    }

    // 회원정보수정
    @Override
    public void modifyConfirm(IAdminModifyConfirm adminModifyConfirm) {
        adminModifyConfirm.execute();

    }

    // 회원탈퇴
    @Override
    public void deleteConfirm(IAdminDeleteConfirm adminDeleteConfirm) {
        adminDeleteConfirm.execute();
        
    }

    // 전체 유저 조회
    @Override
    public void searchAllUserConfirm(ISearchAllUserConfirm searchAllUserConfirm) {
        searchAllUserConfirm.execute();

    }


}