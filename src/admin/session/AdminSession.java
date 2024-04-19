package admin.session;

import admin.member.AdminDto;

public class AdminSession {
    private static AdminSession adminSession;
    
    /*
     * AdminSession을 통해서 AdminDto를 보관하고 저장하고 사용하기 위해
     */
    private AdminDto adminDto;

    /*
     * 해당 코드의 존재 유무는 외부에서 생성하지 못하도록 하기 위함
     */
    private AdminSession() {

    }

    /*
     * getInstance() 메서드로만 AdminSession 객체를 생성할 수 있다.
     * 그래서 싱클톤 패턴으로 하나의 객체만 유지할 수 있게 되는 것이다.
     */
    public static AdminSession getInstance() {
        if(adminSession == null) {
            adminSession = new AdminSession();  // AdminSession 객체 하나만 사용

        }
        return adminSession;

    }

    // 로그인한 정보가 담겨져있는 dto
    public AdminDto getAdminDto() {
        return adminDto;

    }

    public void setAdminDto(AdminDto adminDto) {
        this.adminDto = adminDto;

    }
}
