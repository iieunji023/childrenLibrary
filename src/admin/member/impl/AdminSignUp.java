package admin.member.impl;

import admin.member.AdminController;
import admin.container.AdminContainer;
import admin.member.AdminDto;

import java.util.Scanner;

public class AdminSignUp implements IAdminMember {

    @Override
    public void execute(Scanner scanner) {
        AdminController adminController = AdminContainer.getInstance().getAdminController();
        scanner.nextLine();

        System.out.println("아이디를 입력하세요.");
        String id = scanner.nextLine();

        System.out.println("비밀번호를 입력하세요.");
        String pw = scanner.nextLine();

        System.out.println("이름을 입력하세요.");
        String name = scanner.nextLine();

        System.out.println("전화번호를 입력하세요.");
        String phone = scanner.nextLine();

        AdminDto adminDto = new AdminDto(id, pw, name, phone);
        adminController.signUpConfirm(adminDto);

    }
}