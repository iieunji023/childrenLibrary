package admin.member;

import admin.member.services.impl.*;

public interface IAdminService {
    public void signUpConfirm(IAdminSignUpConfirm adminSignUpConfirm);
    public void signInConfirm(IAdminSignInConfirm adminSignInConfirm);
    public void modifyConfirm(IAdminModifyConfirm adminModifyConfirm);
    public void deleteConfirm(IAdminDeleteConfirm adminDeleteConfirm);
    public void searchAllUserConfirm(ISearchAllUserConfirm searchAllUserConfirm);

}
