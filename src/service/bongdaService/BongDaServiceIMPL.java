package service.bongdaService;

import config.Config;
import model.User;
import model.bongda.CauThu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BongDaServiceIMPL implements IBongDaService, Serializable {
    public static String PATH_CauThu = "C:\\Users\\Chinh\\IdeaProjects\\MD2_Role\\src\\database\\cauthu.txt";
    static Config<List<CauThu>> config = new Config<>();
    static List<CauThu> cauThuList = config.read(PATH_CauThu);

    static {
        if(cauThuList == null) cauThuList = new ArrayList<>();
    }
    @Override
    public List<CauThu> findAll() {
        config.write(PATH_CauThu,cauThuList);
        return cauThuList;
    }

    @Override
    public void save(CauThu cauThu) {
        cauThuList.add(cauThu);
        config.write(PATH_CauThu,cauThuList);
    }

    @Override
    public void remove(int soAo) {
        for (int i = 0; i < cauThuList.size(); i++) {
            if (soAo == cauThuList.get(i).getSoAo()){
                cauThuList.remove(i);
            }
        }

    }
    public CauThu soAo(int soAo){
        for (int i = 0; i < cauThuList.size(); i++) {
            if (soAo == cauThuList.get(i).getSoAo()){
                return cauThuList.get(i);
            }
        }
        return null;
    }

    @Override
    public CauThu findSoAO(int soAo) {
        for (int i = 0; i < cauThuList.size(); i++) {
            if (soAo == cauThuList.get(i).getSoAo()) {
                return cauThuList.get(i);
            }
        }
        return null;
    }

    }


