package user.member.impl;

import user.container.UserContainer;
import user.member.UserController;

import java.util.Scanner;

public class UserDeleteInfo implements IUserMember{
    @Override
    public void execute(Scanner scanner) {
        UserController userController = UserContainer.getInstance().getUserController();

        scanner.nextLine();
        System.out.printf("정말 삭제하시겠습니까? (Y/N)");


        if(scanner.nextLine().equalsIgnoreCase("Y")){
            userController.deleteConfirm();

        }

    }
}
