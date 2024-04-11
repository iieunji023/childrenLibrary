import admin.session.AdminSession;

public class Gnb {
    public static void showAdminGnb() {
        // AdminSession.getInstance() = AdminSession adminSession = new AdminSession();
        if(AdminSession.getInstance().getAdminDto() != null) {      // 관리자 로그인시


        } else {    // 관리자 로그인X
            System.out.println("1) SIGN UP 2) SIGN IN 99) EXIT");

        }

    }

}
