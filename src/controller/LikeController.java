package controller;

import model.bongda.Like;
import service.bongdaService.BongDaServiceIMPL;
import service.bongdaService.IBongDaService;
import service.like.ILikeService;
import service.like.LikeServiceIMPL;

import java.util.List;

public class LikeController {
    ILikeService likeService = new LikeServiceIMPL();
        IBongDaService bongDaService = new BongDaServiceIMPL();

    public int getLikeNumberBYSoAo( int soAO){
        return likeService.getLikeNumberByCauThu(soAO);
    }

    public List<Like> getListLike(){
        return likeService.findAll();
    }
    public void CreateLike(Like like){
        likeService.save(like);
        capNhatLike(like.getSoAoCauThu());
    }
    public void deleteLike( int soAo){
        likeService.remove(soAo);
    }
    public boolean checkLike ( int IdLike){
        return likeService.checkLike(IdLike);
    }

    public void capNhatLike(int soAo){
        List<Like>list =likeService.findAll();
        int count =0;
        for (int i = 0; i < list.size(); i++) {
            if (soAo == list.get(i).getSoAoCauThu()){
                count++;
            }

        }
        bongDaService.soAo(soAo).setLike(count);
    }
}
