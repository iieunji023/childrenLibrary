package admin.member.services.impl;

import admin.config.BookAdminConfig;
import admin.container.AdminContainer;
import admin.member.AdminDto;
import admin.session.AdminSession;

public class AdminModifyConfirm implements IAdminModifyConfirm{
    private AdminDto adminDto;

    public AdminModifyConfirm(AdminDto adminDto) {
        this.adminDto = adminDto;

    }

    @Override
    public void execute() {
        // console에서 사용자에게 받은 값들
        String pw = adminDto.getPw();       
        String name = adminDto.getName();
        String phone = adminDto.getPhone();

        // 수정할 정보가 없을 때는 기존의 정보를 넣는다.
        if(pw.equals("")) {
            adminDto.setPw(AdminSession.getInstance().getAdminDto().getPw());   // 로그인한 회원의 정보

        }
        if(name.equals("")){
            adminDto.setName(AdminSession.getInstance().getAdminDto().getName());

        }
        if(phone.equals("")) {
            adminDto.setPhone(AdminSession.getInstance().getAdminDto().getPhone());

        }

        // sql 조건절에서 no값 필요
        int no = AdminSession.getInstance().getAdminDto().getNo();

        adminDto.setNo(no);

        int result = AdminContainer.getInstance().getAdminDao().updateAdmin(adminDto);

        if(result > 0) {
            System.out.println("회원정보가 수정되었습니다.");

        } else {
            System.out.println("회원정보 수정에 실패하였습니다.");

        }
    }
}
