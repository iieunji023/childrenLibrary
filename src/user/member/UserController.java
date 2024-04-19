package user.member;

import book.container.BookContainer;
import book.services.impl.VanOverdueConfirm;
import user.container.UserContainer;
import user.member.services.impl.UserDeleteConfirm;
import user.member.services.impl.UserModifyConfirm;
import user.member.services.impl.UserSignInConfirm;
import user.member.services.impl.UserSignUpConfirm;

public class UserController {

    // 회원가입
    public void signUpConfirm(UserDto userDto) {
        UserContainer.getInstance().getUserService().signUpConfirm(new UserSignUpConfirm(userDto));

    }

    // 로그인
    public void signInConfirm(UserDto userDto) {
        UserContainer.getInstance().getUserService().signInConfrim(new UserSignInConfirm(userDto));
        BookContainer.getInstance().getBookService().vanOverdueConfirm(new VanOverdueConfirm());

    }

    // 정보수정
    public void modifyConfirm(UserDto userDto) {
        UserContainer.getInstance().getUserService().modifyConfirm(new UserModifyConfirm(userDto));

    }

    // 회원탈퇴
    public void deleteConfirm() {
        UserContainer.getInstance().getUserService().deleteConfrim(new UserDeleteConfirm());

    }
}
