package controller;

import model.bongda.HLV;
import service.hlvService.HLVServiceIMPL;
import service.hlvService.IHlvService;

import java.util.List;

public class HLVController {
    IHlvService hlvService = new HLVServiceIMPL();
    public List<HLV> showListHLV(){
        return hlvService.findAll();
    }
    public void createHLV(HLV hlv){
        hlvService.save(hlv);
    }
    public void deleteHLV(int id){
        hlvService.remove(id);
    }
}
