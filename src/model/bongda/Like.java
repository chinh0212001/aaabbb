package model.bongda;

import java.io.Serializable;

public class Like implements Serializable {
    private int idLike;
    private int SoAoCauThu;
    private int idUser;

    public Like() {
    }

    public Like(int idLike, int soAoCauThu, int idUser) {
        this.idLike = idLike;
        SoAoCauThu = soAoCauThu;
        this.idUser = idUser;
    }

    public int getIdLike() {
        return idLike;
    }

    public void setIdLike(int idLike) {
        this.idLike = idLike;
    }

    public int getSoAoCauThu() {
        return SoAoCauThu;
    }

    public void setSoAoCauThu(int soAoCauThu) {
        SoAoCauThu = soAoCauThu;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Like{" +
                "idLike=" + idLike +
                ", SoAoCauThu=" + SoAoCauThu +
                ", idUser=" + idUser +
                '}';
    }
}
