package user.member.services.impl;

import book.IBookService;
import book.container.BookContainer;
import book.services.impl.IVanOverdueConfirm;
import user.container.UserContainer;
import user.member.UserDto;
import user.session.UserSession;

import java.util.List;

public class UserSignInConfirm implements IUserSignInConfirm{
    private UserDto userDto;

    public UserSignInConfirm(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public void execute(){
        List<UserDto> userDtos = UserContainer.getInstance().getUserDao().selectUser(userDto);

        try {
            if(!userDtos.isEmpty()) {
                System.out.println("로그인되었습니다.");
                UserSession.getInstance().setUserDto(userDtos.get(0));

            } else {
                System.out.println("로그인에 실패하였습니다.");


            }

        } catch (Exception e) {
            System.out.println("로그인에 실패하였습니다.");
        }

    }
}
