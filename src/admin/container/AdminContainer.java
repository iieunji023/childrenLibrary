package admin.container;

import admin.book.AdminBookController;
import admin.book.AdminBookDao;
import admin.book.AdminBookService;
import admin.member.AdminController;
import admin.member.AdminDao;
import admin.member.AdminService;
import book.BookController;

public class AdminContainer {
    private static AdminContainer adminContainer;

    private AdminController adminController;
    private AdminService adminService;
    private AdminDao adminDao;

    private AdminBookController adminBookController;
    private AdminBookService adminBookService;
    private AdminBookDao adminBookDao;

    // CONSTRUCTOR
    private AdminContainer() {

    }

    // METHOD
    public static AdminContainer getInstance(){
        if(adminContainer == null) {
            adminContainer = new AdminContainer();

        }
        return adminContainer;

    }

    /*
     * GETTER & SETTER
     */
    public AdminController getAdminController() {
        return adminController;

    }

    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;

    }

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public AdminDao getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public AdminBookController getAdminBookController() {
        return adminBookController;
    }

    public void setAdminBookController(AdminBookController adminBookController) {
        this.adminBookController = adminBookController;
    }

    public AdminBookService getAdminBookService() {
        return adminBookService;
    }

    public void setAdminBookService(AdminBookService adminBookService) {
        this.adminBookService = adminBookService;
    }

    public AdminBookDao getAdminBookDao() {
        return adminBookDao;
    }

    public void setAdminBookDao(AdminBookDao adminBookDao) {
        this.adminBookDao = adminBookDao;
    }
}
