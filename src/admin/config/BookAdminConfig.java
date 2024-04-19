package admin.config;

public class BookAdminConfig {
    final static public byte ADMIN_SIGN_UP          = 1;
    final static public byte ADMIN_SIGN_IN          = 2;
    final static public byte MYPAGE                 = 3;
    final static public byte USER_INFO              = 4;
    final static public byte BOOK_MANAGEMENT        = 5;

    // 로그인
    final static public byte ADMIN_SIGN_UP_SUCCESS  = 1;
    final static public byte ADMIN_SIGN_UP_FAIL     = 0;
    final static public byte DB_CONNECTION_ERROR    = -1;

    // 마이페이지
    final static public byte MODIFY_MYINFO = 1;
    final static public byte SEARCH_MYINFO = 2;
    final static public byte DELETE_MYINFO = 3;

    // 책 관리
    final static public byte REGIST_BOOK            = 1;
    final static public byte MODIFY_BOOK            = 2;
    final static public byte SEARCH_BOOK            = 3;
    final static public byte ALL_SEARCH_BOOK        = 4;
    final static public byte DELETE_BOOK            = 5;
    
    // 책 등록
    final static public byte ADMIN_BOOK_REGIST_SUCCESS  = 1;
    final static public byte ADMIN_BOOK_REGIST_FAIL     = 0;
}
