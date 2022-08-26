package model.bongda;

import java.io.Serializable;

public class CauThu implements Serializable {
    private int soAo;
    private String name;
    private int age;
    private String viTri;
    private String quocGia;
    private int like;

    public CauThu(String newNAme, String newAge,String newViTri, String quocGia) {
        this.name = newNAme;
        this.age = Integer.parseInt(newAge);
        this.viTri = newViTri;
        this.quocGia = quocGia;


    }

    public CauThu(int soAo, String name, int age, String viTri, String quocGia,int like) {
        this.soAo = soAo;
        this.name = name;
        this.age = age;
        this.viTri = viTri;
        this.quocGia = quocGia;
        this.like = like;
    }

    public int getSoAo() {
        return soAo;
    }

    public void setSoAo(int soAo) {
        this.soAo = soAo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }
    public int getLike(){
        return like;
    }

    public void setLike(int like) {
        this.like= like;

    }

    @Override
    public String toString() {
        return "CauThu{" +
                "soAo=" + soAo +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", viTri='" + viTri + '\'' +
                ", quocGia='" + quocGia + '\'' + "like= "+like+
                '}';
    }
}
