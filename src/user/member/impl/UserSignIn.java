package user.member.impl;

import user.container.UserContainer;
import user.member.UserController;
import user.member.UserDto;

import java.util.Scanner;

public class UserSignIn implements IUserMember{
    @Override
    public void execute(Scanner scanner) {
        UserController userController = UserContainer.getInstance().getUserController();
        scanner.nextLine();

        System.out.println("아이디를 입력해주세요.");
        String id = scanner.nextLine();
        System.out.println("비밀번호를 입력해주세요.");
        String pw = scanner.nextLine();

        UserDto userDto = new UserDto(id, pw);

        userController.signInConfirm(userDto);

    }
}
