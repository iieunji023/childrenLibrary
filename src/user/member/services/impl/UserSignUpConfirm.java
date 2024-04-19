package user.member.services.impl;

import user.config.BookUserConfig;
import user.container.UserContainer;
import user.member.UserDto;

public class UserSignUpConfirm implements IUserSignUpConfirm{
    private UserDto userDto;

    public UserSignUpConfirm(UserDto userDto) {
        this.userDto = userDto;

    }

    // 회원가입
    @Override
    public void execute() {
        Boolean isUser = UserContainer.getInstance().getUserDao().isUserExist(userDto);

        if(!isUser) {
            int result = UserContainer.getInstance().getUserDao().insertUserSignUpInfo(userDto);

            switch (result) {
                case BookUserConfig.USER_SIGN_UP_SUCCESS:
                    System.out.println("회원가입이 완료되었습니다.");
                    break;

                case BookUserConfig.USER_SIGN_UP_FAIL:
                    System.out.println("회원가입에 실패하였습니다.");
                    break;

                case BookUserConfig.DB_CONNECTION_ERROR:
                    System.out.println("DB 연결 실패");
                    break;

            }
        } else {
            System.out.println("동일한 아이디가 존재합니다.");

        }
    }
}
