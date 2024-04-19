package user.member.impl;

import user.container.UserContainer;
import user.member.UserController;
import user.member.UserDto;

import java.util.Scanner;

public class UserSignUp implements IUserMember{
    @Override
    public void execute(Scanner scanner) {
        UserController userController = UserContainer.getInstance().getUserController();
        scanner.nextLine();

        System.out.println("아이디를 입력하세요.");
        String id = scanner.nextLine();

        System.out.println("비밀번호를 입력하세요.");
        String pw = scanner.nextLine();

        System.out.println("이름을 입력하세요.");
        String name = scanner.nextLine();

        System.out.println("전화번호를 입력하세요.");
        String phone = scanner.nextLine();

        System.out.println("주소를 입력하세요.");
        String address = scanner.nextLine();

        UserDto userDto = new UserDto(id, pw, name, phone, address);

        userController.signUpConfirm(userDto);

    }
}
