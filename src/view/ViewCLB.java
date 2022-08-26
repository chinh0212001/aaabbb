package view;

import config.Config;
import controller.CauThuBongDaController;
import controller.LikeController;
import controller.UserController;
import model.bongda.CauThu;
import model.bongda.Like;

import java.util.List;

public class ViewCLB {
    public UserController userController = new UserController();
    public CauThuBongDaController cauThuBongDaController = new CauThuBongDaController();
    public LikeController likeController = new LikeController();
    public List<CauThu> cauThuList = cauThuBongDaController.showListCauThu();

    public void viewCLB() {
        System.out.println("1. show danh sach Cau Thu");
        System.out.println("2. Create cau thu");
        System.out.println("3. delete cau thu");
        System.out.println("4. detail cau thu");
        System.out.println("5. Edit cau thu");

        int choice = Integer.parseInt(Config.scanner().nextLine());
        switch (choice) {
            case 1:
                fromShowList();
                break;
            case 2:
                fromCreateCauThu();
                break;
            case 3:
                fromDeleteCauThu();
                break;
            case 4:
                fromDetailCauThu();
                break;
            case 5:
                fromEditCauThu();
                break;
        }
        viewCLB();
    }

    private void fromEditCauThu() {
        System.out.println("nhap So Ao vao de sua: ");
        int soAo = Config.scanner().nextInt();

        if (cauThuBongDaController.detailCauThu(soAo)==null){
            System.out.println("ko ton tai!");
        }else {
            CauThu cauThu = cauThuBongDaController.detailCauThu(soAo);
            System.out.println("OLD NAME: "+ cauThu.getName());
            System.out.println("OLD AGE: "+ cauThu.getAge());
            System.out.println("OLD Vitri: "+cauThu.getViTri());
            System.out.println("OLD quocGia: "+cauThu.getQuocGia());
            System.out.println("NHap vao name de Sua: ");
            String newNAme = Config.scanner().nextLine();
            if (newNAme.trim().equals("")){
                newNAme = cauThu.getName();
            }
            System.out.println("nhap tuoi de sua: ");
            String newAge = Config.scanner().nextLine();
            if (newAge.trim().equals("")){
                newAge = String.valueOf(cauThu.getAge());
            }
            System.out.println("nhap vao viTri de sua: ");
            String newVitri = Config.scanner().nextLine();
            if (newVitri.trim().equals("")){
                newVitri = cauThu.getViTri();
            }
            System.out.println("nhap quocGia de sua: ");
            String quocgia = Config.scanner().nextLine();
            if (quocgia.trim().equals("")){
                quocgia = cauThu.getQuocGia();
            }
            CauThu newCauThu = new CauThu(newNAme,newAge,newVitri,quocgia);
            cauThuBongDaController.editCauThu(soAo,newCauThu);
            System.out.println("Edit success!!!");
            cauThuBongDaController.showListCauThu();
        }
        System.out.println("Nhập vào phím bất kì để tiếp tục - Nhập vào back để thoát: ");
        String backMenu = Config.scanner().nextLine();
        if(backMenu.equalsIgnoreCase("back")){
            new ViewCLB();
        }
    }

    private void fromDetailCauThu() {
        System.out.println("input so ao for show detail: ");
        int soAo = Config.scanner().nextInt();
        if(cauThuBongDaController.detailCauThu(soAo)==null){
            System.out.println("no exist id cau thu");
        }else {
            CauThu cauThu = cauThuBongDaController.detailCauThu(soAo);
            System.out.println(cauThu);
        }
        System.out.println("input back for out: ");
        String backMenu = Config.scanner().nextLine();
        if(backMenu.equalsIgnoreCase("back")){
            new ViewHome();
        }
    }

    private void fromDeleteCauThu() {
        int soAo;
        while (true) {
            System.out.println("Nhap So ao: ");
            soAo = Integer.parseInt(Config.scanner().nextLine());
            if (checkSoAo(soAo)) {
                cauThuBongDaController.deleteCauThu(soAo);
                System.out.println("xoa thanh cong");
                break;
            } else {
                System.out.println("so ao ko ton tai !!!");
            }
        }
    }

    public void fromShowList() {
        System.out.println(cauThuList.size());
        System.out.println("===so ao===Name===tuoi===vi tri===quoc tich===like===");
        for (int i = 0; i < cauThuList.size(); i++) {
            System.out.println("===" + cauThuList.get(i).getSoAo()
                    + "====" + cauThuList.get(i).getName()
                    + "====" + cauThuList.get(i).getAge()
                    + "====" + cauThuList.get(i).getViTri()
                    + "====" + cauThuList.get(i).getQuocGia()
                    + "====" + cauThuList.get(i).getLike());
        }

        int soAo;
        System.out.println("Nhap So ao de like: / 0 de thoat");
        soAo = Integer.parseInt(Config.scanner().nextLine());

        if (soAo == 0){
            return;
        }

        if (!checkSoAo(soAo)) {
            System.out.println("so ao k ton tai");
            return;
        }

        likeController.CreateLike(new Like(1, soAo, userController.getCurrentUser().getId()));
        fromShowList();
    }

    private void fromCreateCauThu() {
        System.out.println("Create Cau Thu");

        int soAo;
        while (true) {
            System.out.println("Nhap So ao: ");
            soAo = Integer.parseInt(Config.scanner().nextLine());
            if (checkSoAo(soAo)) {
                System.out.println("so ao da ton tai");
            } else {
                break;
            }
        }

        System.out.println("Nhap name cau thu: ");
        String name = Config.scanner().nextLine();
        System.out.println("Nhap tuoi: ");
        int age = Integer.parseInt(Config.scanner().nextLine());
        System.out.println("Nhap Vi tri thi dau cua Cau Thu: ");
        String viTri = Config.scanner().nextLine();
        System.out.println("NHap QUoc Tich: ");
        String quocGia = Config.scanner().nextLine();
        int like = 0;
        CauThu cauThu = new CauThu(soAo, name, age, viTri, quocGia, like);
        cauThuBongDaController.themCauThu(cauThu);
        System.out.println("them Cau Thu Thanh Cong");
        System.out.println("===so ao===Name===tuoi===vi tri===quoc tich===like===");
        for (int i = 0; i < cauThuList.size(); i++) {
            System.out.println("===" + cauThuList.get(i).getSoAo()
                    + "====" + cauThuList.get(i).getName()
                    + "====" + cauThuList.get(i).getAge()
                    + "====" + cauThuList.get(i).getViTri()
                    + "====" + cauThuList.get(i).getQuocGia()
                    + "====" + cauThuList.get(i).getLike());
        }
        //back
        System.out.println("nhap phim bat ki de tiep tuc --- nhap back de thoat: ");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new ViewCLB();
        }
    }

    private boolean checkSoAo(int soAo) {
        for (int i = 0; i < cauThuList.size(); i++) {
            if (soAo == cauThuList.get(i).getSoAo()) {
                return true;
            }
        }
        return false;

    }


}
