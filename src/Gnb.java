import admin.session.AdminSession;
import user.session.UserSession;

public class Gnb {
    /*
     * ADMIN GNB METHOD START
     */
    public static void showAdminGnb() {
        if(AdminSession.getInstance().getAdminDto() != null) {      // 관리자 로그인시
            System.out.println("┌──────────────────────┐");
            System.out.println("  3) 마이페이지           ");
            System.out.println("  4) 유저관리            ");
            System.out.println("  5) 도서관리            ");
            System.out.println("  99) 종료            ");
            System.out.println("└──────────────────────┘");
        } else {    // 관리자 로그인 X
            System.out.println("┌──────────────────────┐");
            System.out.println("  1) 회원가입             ");
            System.out.println("  2) 로그인              ");
            System.out.println("  99) 종료               ");
            System.out.println("└──────────────────────┘");
        }
    }

    public static void showAdminMyPage() {
        System.out.println("┌──────────────────────┐");
        System.out.println("  1) 회원정보수정          ");
        System.out.println("  2) 회원정보조회          ");
        System.out.println("  3) 회원탈퇴             ");
        System.out.println("  99) 종료               ");
        System.out.println("└──────────────────────┘");
    }

    public static void showAdminBook() {
        System.out.println("┌──────────────────────┐");
        System.out.println("  1) 책 등록               ");
        System.out.println("  2) 책 수정               ");
        System.out.println("  3) 책 조회               ");
        System.out.println("  4) 책 전체 조회          ");
        System.out.println("  5) 책 삭제               ");
        System.out.println("  99) 종료               ");
        System.out.println("└──────────────────────┘");
    }
    /*
     * ADMIN GNB METHOD END
     */

    /*
     * USER GNB METHOD START
     */
    public static void showUserGnb() {
        if(UserSession.getInstance().getUserDto() != null) {
            System.out.println("┌──────────────────────┐");
            System.out.println("  3) 마이페이지           ");
            System.out.println("  4) 도서                ");
            System.out.println("  99) 종료              ");
            System.out.println("└──────────────────────┘");
        } else {
            System.out.println("┌──────────────────────┐");
            System.out.println("  1) 회원가입             ");
            System.out.println("  2) 로그인               ");
            System.out.println("  99) 종료               ");
            System.out.println("└──────────────────────┘");
        }
    }

    public static void showUserMyPage() {
        System.out.println("┌──────────────────────┐");
        System.out.println("  1) 회원정보수정        ");
        System.out.println("  2) 회원정보조회        ");
        System.out.println("  3) 회원탈퇴           ");
        System.out.println("  99) 종료             ");
        System.out.println("└──────────────────────┘");
    }

    public static void showUserBook() {
        System.out.println("┌──────────────────────┐");
        System.out.println("  1) 도서조회(제목)       ");
        System.out.println("  2) 도서 전체조회         ");
        System.out.println("  3) 대여                 ");
        System.out.println("  4) 도서 대여 목록        ");
        System.out.println("  5) 이달의 독서왕         ");
        System.out.println("  99) 종료              ");
        System.out.println("└──────────────────────┘");
    }
    /*
     * USER GNB METHOD  END
     */
}
