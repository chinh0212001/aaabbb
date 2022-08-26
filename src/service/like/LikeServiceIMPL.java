package service.like;

import config.Config;
import model.User;
import model.bongda.Like;
import service.user.IUserService;
import service.user.UserServiceIMPL;

import java.util.ArrayList;
import java.util.List;

public class LikeServiceIMPL implements ILikeService{
    IUserService userService  = new UserServiceIMPL();
    static String PATH_LIKE = "C:\\Users\\Chinh\\IdeaProjects\\MD2_Role\\src\\database\\like.txt";
    static Config<List<Like>> config = new Config<>();
    static List<Like> likeList = config.read(PATH_LIKE);
    static {
        if (likeList == null){
            likeList = new ArrayList<>();
        }
    }
    @Override
    public List<Like> findAll() {
        return likeList;
    }

    @Override
    public void save(Like like) {
        likeList.add(like);
        config.write(PATH_LIKE,likeList);

    }

    @Override
    public int getLikeNumberByCauThu(int soAo) {
        int count = 0;
        for (Like like : likeList){
            if (like.getSoAoCauThu() == soAo){
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean checkLike(int idLike) {
        User current = userService.getCurrentUser();
        for (Like like : likeList){
            if (like.getSoAoCauThu() == idLike && like.getIdUser() == current.getId()){
                return true;
            }
        }
        return false;

    }



    @Override
    public void remove(int soAo) {
        Like likeDelete = null;
        for (Like like : likeList) {
            if (like.getSoAoCauThu() == soAo && like.getIdUser() == userService.getCurrentUser().getId()) {
                likeDelete = like;
            }
        }
        likeList.remove(likeDelete);
        config.write(PATH_LIKE,likeList);
    }

}
