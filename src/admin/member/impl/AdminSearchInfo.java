package admin.member.impl;

import admin.container.AdminContainer;
import admin.member.AdminController;
import admin.member.AdminDto;
import admin.session.AdminSession;

import java.util.Scanner;

public class AdminSearchInfo implements IAdminMember{
    @Override
    public void execute(Scanner scanner) {
        // session 로그인 정보를 담아놨기 때문에 db에서 꺼내지 않아도 된다.
        AdminDto adminDto = AdminSession.getInstance().getAdminDto();

        System.out.printf("""
                           ===============================
                           <%s님의 정보>
                           NO: %d
                           ID: %s
                           NAME: %s
                           PHONE: %s
                           CREATED_AT: %s
                           ===============================
                           """, adminDto.getName(),
                                adminDto.getNo(),
                                adminDto.getId(),
                                adminDto.getName(),
                                adminDto.getPhone(),
                                adminDto.getCreated_at());
    }
}
