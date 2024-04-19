package user.config;

public class BookUserConfig {
    final static public byte USER_SIGN_UP   = 1;
    final static public byte USER_SIGN_IN   = 2;
    final static public byte USER_MYPAGE    = 3;
    final static public byte USER_BOOK      = 4;


    final static public byte USER_SIGN_UP_SUCCESS   = 1;
    final static public byte USER_SIGN_UP_FAIL      = 0;
    final static public byte DB_CONNECTION_ERROR    = -1;

    // 마이페이지
    final static public byte MODIFY_MYINFO = 1;
    final static public byte SEARCH_MYINFO = 2;
    final static public byte DELETE_MYINFO = 3;

    // 책
    final static public byte BOOK_SEARCH_BY_TITLE    = 1;
    final static public byte BOOK_ALL_SEARCH         = 2;
    final static public byte BOOK_RENTAL             = 3;
    final static public byte BOOK_SHOW_RENTAL_LIST   = 4;
    final static public byte RANKING                 = 5;

    final static public byte EXTENSION_DUE   = 1;
    final static public byte RETURN_BOOK     = 2;

}
