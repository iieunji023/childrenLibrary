package admin.member.impl;

import admin.container.AdminContainer;
import admin.member.AdminController;
import admin.member.AdminDto;
import admin.member.services.impl.AdminSignInConfirm;

import java.util.Scanner;

public class AdminSignIn implements IAdminMember{
    @Override
    public void execute(Scanner scanner) {
        AdminController adminController = AdminContainer.getInstance().getAdminController();
        scanner.nextLine();

        System.out.println("아이디를 입력하세요.");
        String id = scanner.nextLine();
        System.out.println("비밀번호를 입력하세요.");
        String pw = scanner.nextLine();

        AdminDto adminDto = new AdminDto(id, pw);

        adminController.signInConfirm(adminDto);

    }
}
