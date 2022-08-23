package service.user;

import config.Config;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceIMPL implements IUserService{
    static String PATH_USER = "C:\\Users\\Chinh\\IdeaProjects\\MD2_Role\\src\\database\\user.txt";

    static Config<List<User>> config = new Config<>();

    static List<User> userList = config.read(PATH_USER);


    @Override
    public List<User> findAll() {
        config.write(PATH_USER,userList);
        return userList;
    }

    @Override
    public void save(User user) {
        userList.add(user);

    }

    @Override
    public boolean existByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existsByEmail(String email) {
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
            return false;
        }
    }
