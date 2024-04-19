package admin.member.impl;

import admin.container.AdminContainer;
import admin.member.AdminController;
import admin.member.AdminDto;

import java.util.Scanner;

public class AdminModifyInfo implements IAdminMember{
    @Override
    public void execute(Scanner scanner) {
        AdminController adminController = AdminContainer.getInstance().getAdminController();

        scanner.nextLine();

        System.out.println("변경할 비밀번호를 입력하세요.");
        String pw = scanner.nextLine();

        System.out.println("변경할 이름을 입력하세요.");
        String name = scanner.nextLine();

        System.out.println("변경할 전화번호를 입력하세요.");
        String phone = scanner.nextLine();

        AdminDto adminDto = new AdminDto(pw, name, phone);

        adminController.modifyConfirm(adminDto);

    }
}
