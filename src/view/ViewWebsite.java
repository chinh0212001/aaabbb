package view;

import config.Config;

public class ViewWebsite {
    public void website(){
        System.out.println("MANCHESTER UTD");
        System.out.println("1. Các tính năng cua cau thu");
        System.out.println("2. cac tinh nang HLV");

        int choice = Integer.parseInt(Config.scanner().nextLine());
        switch (choice){
            case 1:
                new ViewCLB().viewCLB();
                break;
            case 2:
                new ViewHLV().viewHLV();
                break;


        }

    }
}
