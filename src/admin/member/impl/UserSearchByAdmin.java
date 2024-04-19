package admin.member.impl;

import admin.container.AdminContainer;
import admin.member.AdminController;

import java.util.Scanner;

public class UserSearchByAdmin implements IAdminMember{

    @Override
    public void execute(Scanner scanner) {
        AdminController adminController = AdminContainer.getInstance().getAdminController();
        System.out.println("전체 유저를 조회합니다.");

        adminController.searchAllUserInfoByAdmin();

    }
}
