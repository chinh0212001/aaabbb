package view;

import config.Config;
import controller.UserController;
import dto.request.SignUpDTO;
import dto.response.ResponseMessenger;
import model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ViewMainMenu {
    UserController userController = new UserController();
    List<User> userList = userController.getUserList();

    public void menu() {

            System.out.println("-------Menu--------");
            System.out.println("1. Show user list");
            System.out.println("2. Register");

            int choice = Integer.parseInt(Config.scanner().nextLine());
            switch (choice) {
                case 1:
                    fromShowListUser();
                    break;
                case 2:
                    fromRegister();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
             menu();
        }

    private void fromRegister() {
        System.out.println("======REGISTER======");
        //id
        int id;
        if (userList.isEmpty()){
            id = 1;
        }else {
            id = userList.get(userList.size()-1).getId()+1;
        }
        //name
        String name;
        while (true){
            System.out.println("Enter name: ");
            name = Config.scanner().nextLine();
            if (name.matches("[A-Z][a-zA-Z]{1,30}")){
                break;
            }else {
                System.out.println("Invalid name, try again!");
            }
        }
        //username
        String username;
        while (true){
            System.out.println("Enter username: ");
            username = Config.scanner().nextLine();
            if (username.matches("[A-Z][a-zA-Z]{1,30}")){
                break;
            }else {
                System.out.println("Invalid username, try again!");
            }
        }
        //email
        String email;
        while (true){
            System.out.println("Enter email: ");
           email = Config.scanner().nextLine();
            if (email.matches("^(.+)@(.+)$")){
                break;
            }else {
                System.out.println("Invalid email, try again!");
            }
        }
        //password
        String password;
        while (true){
            System.out.println("Enter password: ");
           password = Config.scanner().nextLine();
            if (password.matches("[a-zA-Z0-9]{1,40}")){
                break;
            }else {
                System.out.println("Invalid password, try again!");
            }
        }
        //role
        System.out.println("Enter Role: ");
        String role = Config.scanner().nextLine();
        Set<String> strRole = new HashSet<>();
        strRole.add(role);
        SignUpDTO signUpDTO = new SignUpDTO(id,name,username,email,password,strRole);

        ResponseMessenger responseMessenger = userController.register(signUpDTO);

        switch (responseMessenger.getMessage()){
            case "user_existed":
                System.out.println("Username already exists");
                break;
            case "email_existed":
                System.out.println("email already exists");
                break;
            case "invalid_role":
                System.out.println("Invalid_role already exists");
            case "success":
                System.out.println("Register success");
        }



    }

    private void fromShowListUser() {
        System.out.printf("%-15s%s%n","User","Role");
        for (User user : userList ) {
            System.out.printf("%-15s%s%n",user.getUsername(),user.getRoles());
        }
    }
}

