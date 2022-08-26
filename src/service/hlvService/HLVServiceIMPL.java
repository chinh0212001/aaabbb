package service.hlvService;


import config.Config;
import model.bongda.CauThu;
import model.bongda.HLV;

import java.util.ArrayList;
import java.util.List;

public class HLVServiceIMPL implements IHlvService {
    public static String PATH_HLV = "C:\\Users\\Chinh\\IdeaProjects\\MD2_Role\\src\\database\\hlv.txt";
    static Config<List<HLV>> config = new Config<>();
    static List<HLV> hlvList = config.read(PATH_HLV);

    static {
        if(hlvList == null) hlvList = new ArrayList<>();
    }
    @Override
    public List<HLV> findAll() {
        config.write(PATH_HLV,hlvList);

        return hlvList;
    }

    @Override
    public void save(HLV hlv) {
        hlvList.add(hlv);
        config.write(PATH_HLV,hlvList);
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < hlvList.size(); i++) {
            if (id == hlvList.get(i).getId()){
                hlvList.remove(i);
            }
        }
    }
}
