package user.member;

import user.member.services.impl.IUserDeleteConfirm;
import user.member.services.impl.IUserModifyConfirm;
import user.member.services.impl.IUserSignInConfirm;
import user.member.services.impl.IUserSignUpConfirm;

public interface IUserService {
    public void signUpConfirm(IUserSignUpConfirm userSignUpConfirm);
    public void signInConfrim(IUserSignInConfirm userSignInConfirm);

    void modifyConfirm(IUserModifyConfirm userModifyConfirm);

    void deleteConfrim(IUserDeleteConfirm userDeleteConfirm);
}
