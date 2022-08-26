package view;

import config.Config;
import controller.UserController;
import model.RoleName;
import model.User;

import java.util.ArrayList;

public class ViewHome {
    UserController userController = new UserController();
    User currentUser = userController.getCurrentUser();
    RoleName roleName = new ArrayList<>(currentUser.getRoles()).get(0).getRoleName();
    public ViewHome(){
        switch (roleName){
            case ADMIN:
                menuAdmin();
                break;
            case USER:
                menuUser();

        }
    }

    public void menuAdmin(){
        System.out.println("hello Admin: "+ roleName + ": " + currentUser.getName());
        System.out.println("1. Log Out");
        System.out.println("2. -----WELCOME FOOTBALL WEBSITE------");

        int choice = Integer.parseInt(Config.scanner().nextLine());

        switch (choice){
            case 1:
                userController.logOut();
                new ViewMainMenu().menu();
                break;
            case 2:
                new ViewWebsite().website();

        }
        menuAdmin();
    }
    public void menuUser(){
        System.out.println("hello User: "+ roleName+": "+ currentUser.getName());
        System.out.println("1. List Cau thu");
        System.out.println("2. List HLV");
        System.out.println("3. LOG OUT");
        int choice = Integer.parseInt(Config.scanner().nextLine());
        switch (choice){
            case 1:
                new ViewCLB().fromShowList();
                break;
            case 2:
                new ViewHLV().fromShowListHLV();
                break;
            case 3:
                userController.logOut();
                new ViewMainMenu().menu();
                return;
        }
        menuUser();

    }


}
