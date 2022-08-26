package view;

import config.Config;
import controller.HLVController;
import model.bongda.HLV;

import java.util.List;

public class ViewHLV {
    public HLVController hlvController = new HLVController();
    public List<HLV> hlvList = hlvController.showListHLV();
    public  void viewHLV(){
        System.out.println("1. show list HLV");
        System.out.println("2. Create HLV");
        System.out.println("3. Delete HLV");



        int choice = Integer.parseInt(Config.scanner().nextLine());
        switch (choice){
            case 1:
                fromShowListHLV();
                break;
            case 2:
                fromCreateHLV();
                break;
            case 3:
                fromDeleteHLV();
                break;
        }
    }

    private void fromDeleteHLV() {
        int id;
        while (true){
            System.out.println("nhap id: ");
            id = Integer.parseInt(Config.scanner().nextLine());
            if (checkIdHLV(id)){
                hlvController.deleteHLV(id);
                System.out.println("xoa thanh cong!");
                break;
            }else {
                System.out.println("id ko ton tai!!!");
            }
        }
    }

    private void fromCreateHLV() {
        System.out.println("Create HLV");
        int id;
        while (true){
            System.out.println("nhap id: ");
            id = Integer.parseInt(Config.scanner().nextLine());
            if (checkIdHLV(id)){
                System.out.println(" da ton tai!!!");
            }else {
                break;
            }
        }
        System.out.println("nhap name HLV: ");
        String name = Config.scanner().nextLine();
        System.out.println("nhap detail HLV: ");
        String detailHLV = Config.scanner().nextLine();

        HLV hlv = new HLV(id,name,detailHLV);
        hlvController.createHLV(hlv);
        System.out.println("them HLV thanh cong");
        hlvController.showListHLV();
        //back
        System.out.println("nhap phim bat ki de tiep tuc --- nhap back de thoat: ");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")){
            fromShowListHLV();
            new ViewCLB();
        }
    }

    public void fromShowListHLV() {
        System.out.println("===id===CoachName===Detail===");
        for (int i = 0; i < hlvList.size(); i++) {
            System.out.println("=="+hlvList.get(i).getId()+"=="
                    +hlvList.get(i).getCoachName()+"=="+hlvList.get(i).getDetail());

        }
    }
    private boolean checkIdHLV(int id){
        for (int i = 0; i < hlvList.size(); i++) {
            if (id == hlvList.get(i).getId()){
                return true;
            }
        }
        return false;
    }

}
