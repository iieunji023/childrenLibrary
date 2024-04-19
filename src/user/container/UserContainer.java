package user.container;

import user.book.UserBookController;
import user.book.UserBookDao;
import user.book.UserBookService;
import user.member.UserController;
import user.member.UserDao;
import user.member.UserService;

public class UserContainer {
    private static UserContainer userContainer;

    private UserController userController;
    private UserService userService;
    private UserDao userDao;

    private UserBookController userBookContrller;
    private UserBookService userBookService;
    private UserBookDao userBookDao;

    private UserContainer() {

    }

    public static UserContainer getInstance() {
        if(userContainer == null) {
            userContainer = new UserContainer();
        }
        return userContainer;

    }

    public UserController getUserController() {
        return userController;

    }

    public void setUserController(UserController userController) {
        this.userController = userController;

    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserBookController getUserBookContrller() {
        return userBookContrller;
    }

    public void setUserBookContrller(UserBookController userBookContrller) {
        this.userBookContrller = userBookContrller;
    }

    public UserBookService getUserBookService() {
        return userBookService;
    }

    public void setUserBookService(UserBookService userBookService) {
        this.userBookService = userBookService;
    }

    public UserBookDao getUserBookDao() {
        return userBookDao;
    }

    public void setUserBookDao(UserBookDao userBookDao) {
        this.userBookDao = userBookDao;
    }
}
