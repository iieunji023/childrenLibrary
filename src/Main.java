import admin.book.AdminBookController;
import admin.book.AdminBookDao;
import admin.book.AdminBookService;
import admin.book.impl.*;
import admin.config.BookAdminConfig;
import admin.container.AdminContainer;
import admin.member.AdminController;
import admin.member.AdminDao;
import admin.member.AdminService;
import admin.member.impl.*;
import book.BookController;
import book.BookDao;
import book.BookService;
import book.container.BookContainer;
import config.BookConfig;
import user.book.UserBookController;
import user.book.UserBookDao;
import user.book.UserBookService;
import user.book.impl.*;
import user.config.BookUserConfig;
import user.container.UserContainer;
import user.member.UserController;
import user.member.UserDao;
import user.member.UserService;
import user.member.impl.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AdminContainer adminContainer = AdminContainer.getInstance();
        UserContainer userContainer = UserContainer.getInstance();
        BookContainer bookContainer = BookContainer.getInstance();

        adminContainer.setAdminController(new AdminController());
        adminContainer.setAdminService(new AdminService());
        adminContainer.setAdminDao(new AdminDao());

        adminContainer.setAdminBookController(new AdminBookController());
        adminContainer.setAdminBookService(new AdminBookService());
        adminContainer.setAdminBookDao(new AdminBookDao());

        userContainer.setUserController(new UserController());
        userContainer.setUserService(new UserService());
        userContainer.setUserDao(new UserDao());
        userContainer.setUserBookContrller(new UserBookController());
        userContainer.setUserBookService(new UserBookService());
        userContainer.setUserBookDao(new UserBookDao());

        bookContainer.setBookController(new BookController());
        bookContainer.setBookService(new BookService());
        bookContainer.setBookDao(new BookDao());

        System.out.println("\u001B[32m"
                + "██╗     ██╗██████╗ ██████╗  █████╗ ██████╗ ██╗   ██╗\n"
                + "██║     ██║██╔══██╗██╔══██╗██╔══██╗██╔══██╗╚██╗ ██╔╝\n"
                + "██║     ██║██████╔╝██████╔╝███████║██████╔╝ ╚████╔╝ \n"
                + "██║     ██║██╔══██╗██╔══██╗██╔══██║██╔══██╗  ╚██╔╝  \n"
                + "███████╗██║██████╔╝██║  ██║██║  ██║██║  ██║   ██║   \n"
                + "╚══════╝╚═╝╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝   \n"
                + "\u001B[0m");

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        myloop:
        while (flag) {
            System.out.println("┌─────────────────────┐");
            System.out.println("   1) 관리자 2) 사용자 ");
            System.out.println("└─────────────────────┘");

            switch (scanner.nextInt()) {
                case BookConfig.ADMIN_MODE:         // 관리자 모드
                    boolean isAdminMode = true;

                    while (isAdminMode) {
                        Gnb.showAdminGnb();

                        IAdminMember adminMember = null;

                        switch (scanner.nextInt()) {
                            case BookAdminConfig.ADMIN_SIGN_UP:
                                adminMember = new AdminSignUp();
                                break;

                            case BookAdminConfig.ADMIN_SIGN_IN:
                                adminMember = new AdminSignIn();
                                break;

                            case BookAdminConfig.MYPAGE:
                                Boolean isAdminMyPage = true;
                                while (isAdminMyPage) {
                                    Gnb.showAdminMyPage();

                                    switch (scanner.nextInt()) {
                                        case BookAdminConfig.MODIFY_MYINFO:
                                            adminMember = new AdminModifyInfo();
                                            break;

                                        case BookAdminConfig.SEARCH_MYINFO:
                                            adminMember = new AdminSearchInfo();
                                            break;

                                        case BookAdminConfig.DELETE_MYINFO:
                                            adminMember = new AdminDeleteInfo();
                                            break;

                                        case BookConfig.SYSTEM_SHUTDOWN:
                                            isAdminMyPage = false;
                                            adminMember = null;
                                            break;

                                    }
                                    if (adminMember != null) {
                                        adminMember.execute(scanner);
                                    }
                                }
                                break;

                            case BookAdminConfig.USER_INFO:
                                adminMember = new UserSearchByAdmin();
                                break;

                            case BookAdminConfig.BOOK_MANAGEMENT:
                                IAdminBook adminBook = null;

                                boolean isAdminBook = true;
                                while (isAdminBook) {
                                    Gnb.showAdminBook();

                                    switch (scanner.nextInt()) {
                                        case BookAdminConfig.REGIST_BOOK:
                                            adminBook = new AdminRegistBook();
                                            break;
                                        case BookAdminConfig.MODIFY_BOOK:
                                            adminBook = new AdminModifyBook();
                                            break;
                                        case BookAdminConfig.SEARCH_BOOK:
                                            adminBook = new AdminSearchBook();
                                            break;
                                        case BookAdminConfig.ALL_SEARCH_BOOK:
                                            adminBook = new AdminAllSearchBook();
                                            break;
                                        case BookAdminConfig.DELETE_BOOK:
                                            adminBook = new AdminDeleteBook();
                                            break;
                                        case BookConfig.SYSTEM_SHUTDOWN:
                                            isAdminBook = false;
                                            adminBook = null;
                                            break;

                                    }
                                    if (adminBook != null) {
                                        adminBook.execute(scanner);

                                    }
                                }
                                break;

                            case BookConfig.SYSTEM_SHUTDOWN:
                                System.out.println("종료되었습니다.");
                                isAdminMode = false;
                                adminMember = null;
                                continue myloop;

                        }

                        if (adminMember != null) {
                            adminMember.execute(scanner);
                        }
                    }
                    break;

                case BookConfig.USER_MODE:
                    boolean isUserMode = true;

                    while (isUserMode) {
                        Gnb.showUserGnb();
                        IUserMember userMember = null;

                        switch (scanner.nextInt()) {
                            case BookUserConfig.USER_SIGN_UP:
                                userMember = new UserSignUp();
                                break;

                            case BookUserConfig.USER_SIGN_IN:
                                userMember = new UserSignIn();
                                break;

                            case BookUserConfig.USER_MYPAGE:
                                boolean isUserMypage = true;

                                while (isUserMypage) {
                                    Gnb.showUserMyPage();
                                    switch (scanner.nextInt()) {
                                        case BookUserConfig.MODIFY_MYINFO:
                                            userMember = new UserModifyInfo();
                                            break;

                                        case BookUserConfig.SEARCH_MYINFO:
                                            userMember = new UserSearchInfo();
                                            break;

                                        case BookUserConfig.DELETE_MYINFO:
                                            userMember = new UserDeleteInfo();
                                            break;

                                        case BookConfig.SYSTEM_SHUTDOWN:
                                            isUserMypage = false;
                                            userMember = null;
                                            break;

                                    }
                                    if (userMember != null) {
                                        userMember.execute(scanner);

                                    }
                                }
                            case BookUserConfig.USER_BOOK:
                                boolean isUserBook = true;

                                while (isUserBook) {
                                    Gnb.showUserBook();
                                    IUserBook userBook = null;

                                    switch (scanner.nextInt()) {
                                        case BookUserConfig.BOOK_SEARCH_BY_TITLE:
                                            userBook = new UserSearchBook();
                                            break;

                                        case BookUserConfig.BOOK_ALL_SEARCH:
                                            userBook = new UserAllSearchBook();
                                            break;

                                        case BookUserConfig.BOOK_RENTAL:
                                            userBook = new UserBookRental();
                                            break;

                                        case BookUserConfig.BOOK_SHOW_RENTAL_LIST:
                                            userBook = new UserBookRentalList();
                                            break;

                                        case BookUserConfig.RANKING:
                                            userBook = new UserBookRank();
                                            break;

                                        case BookConfig.SYSTEM_SHUTDOWN:
                                            isUserBook = false;
                                            userBook = null;

                                    }
                                    if (userBook != null) {
                                        userBook.execute(scanner);
                                    }
                                }

                            case BookConfig.SYSTEM_SHUTDOWN:
                                System.out.println("종료되었습니다.");
                                isUserMode = false;
                                userMember = null;
                                continue myloop;
                        }
                        if (userMember != null) {
                            userMember.execute(scanner);

                        }
                    }
                case BookConfig.SYSTEM_SHUTDOWN:
                    System.out.println("종료되었습니다.");
                    break;
            } break ;
        }
            scanner.close();

    }
}