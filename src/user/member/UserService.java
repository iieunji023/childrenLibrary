package user.member;

import user.member.services.impl.IUserDeleteConfirm;
import user.member.services.impl.IUserModifyConfirm;
import user.member.services.impl.IUserSignInConfirm;
import user.member.services.impl.IUserSignUpConfirm;

public class UserService implements IUserService{
    // 회원가입
    @Override
    public void signUpConfirm(IUserSignUpConfirm userSignUpConfirm) {
        userSignUpConfirm.execute();

    }

    // 로그인
    @Override
    public void signInConfrim(IUserSignInConfirm userSignInConfirm) {
        userSignInConfirm.execute();

    }

    // 회원정보수정
    @Override
    public void modifyConfirm(IUserModifyConfirm userModifyConfirm) {
        userModifyConfirm.execute();
        
    }

    // 회원탈퇴
    @Override
    public void deleteConfrim(IUserDeleteConfirm userDeleteConfirm) {
        userDeleteConfirm.execute();

    }

}
