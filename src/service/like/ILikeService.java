package service.like;

import model.bongda.Like;
import service.IGenericService;

public interface ILikeService extends IGenericService<Like> {
    int getLikeNumberByCauThu(int soAo);

    boolean checkLike(int idLike);


    void remove(int soAo);

}
