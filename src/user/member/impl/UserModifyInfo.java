package user.member.impl;

import user.container.UserContainer;
import user.member.UserController;
import user.member.UserDto;

import java.util.Scanner;

public class UserModifyInfo implements IUserMember{
    @Override
    public void execute(Scanner scanner) {
        UserController userController = UserContainer.getInstance().getUserController();

        scanner.nextLine();
        
        System.out.println("변경할 비밀번호를 입력해주세요.");
        String pw = scanner.nextLine();
        System.out.println("변경할 이름을 입력해주세요.");
        String name = scanner.nextLine();
        System.out.println("변경할 전화번호를 입력해주세요.");
        String phone = scanner.nextLine();
        System.out.println("변경할 주소를 입력해주세요.");
        String address = scanner.nextLine();

        UserDto userDto = new UserDto(pw, name, phone, address);

        userController.modifyConfirm(userDto);
        

    }
}
