package controller;

import model.bongda.CauThu;
import service.bongdaService.BongDaServiceIMPL;
import service.bongdaService.IBongDaService;

import java.util.List;

public class CauThuBongDaController {
    IBongDaService bongDaService = new BongDaServiceIMPL();
    public List<CauThu> showListCauThu(){
        return bongDaService.findAll();
    }
    public void themCauThu(CauThu cauThu){
        bongDaService.save(cauThu);
        showListCauThu();

    }
    public void deleteCauThu(int soAo){
        bongDaService.remove(soAo);
        showListCauThu();
    }
    public void editCauThu(int soAo, CauThu newCauThu){
        CauThu cauThu = bongDaService.findSoAO(soAo);
        cauThu.setName(newCauThu.getName());
        cauThu.setAge(newCauThu.getAge());
        System.out.println(newCauThu);
        System.out.println(cauThu);
        bongDaService.findAll();

    }
    public CauThu detailCauThu(int soAo){
        return bongDaService.findSoAO(soAo);

    }
}
