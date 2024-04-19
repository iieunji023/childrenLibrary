package admin.member.services.impl;

import admin.container.AdminContainer;
import admin.member.AdminDto;
import admin.session.AdminSession;

import java.util.ArrayList;

public class AdminSignInConfirm implements IAdminSignInConfirm{
    private AdminDto adminDto;

    public AdminSignInConfirm(AdminDto adminDto) {
        this.adminDto = adminDto;

    }

    @Override
    public void execute() {
        ArrayList<AdminDto> adminDtos;

        // 유효성 검사
        adminDtos = AdminContainer.getInstance().getAdminDao().selectAdmin(adminDto);

        try{
            if(!adminDtos.isEmpty()) {
                System.out.println("로그인되었습니다.");

                // Session에 로그인 정보를 담는다. adminDtos에는 한사람의 정보만 저장되어 있기 때문에 인덱스 0으로 가져온다.
                AdminSession.getInstance().setAdminDto(adminDtos.get(0));

            } else {
                System.out.println("로그인에 실패하였습니다.");

            }

        } catch (Exception e) {
            System.out.println("로그인에 실패하였습니다.");

        }


    }

}
