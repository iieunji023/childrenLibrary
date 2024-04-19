package admin.member.impl;

import admin.container.AdminContainer;
import admin.member.AdminController;

import java.util.Scanner;

public class AdminDeleteInfo implements IAdminMember{
    @Override
    public void execute(Scanner scanner) {
        AdminController adminController = AdminContainer.getInstance().getAdminController();

        System.out.println("정말 탈퇴하시겠습니까? (Y/N)");

        scanner.nextLine();

        /*
         * equalsIgnoreCase : 대소문자 구분없이 비교
         */
        if(scanner.nextLine().equalsIgnoreCase("Y")){
            adminController.deleteConfirm();

        }
    }
}
