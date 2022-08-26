package service.bongdaService;

import model.bongda.CauThu;
import service.IGenericService;

public interface IBongDaService extends IGenericService<CauThu> {

    void remove (int soAo);

    CauThu soAo(int soAo);
    CauThu findSoAO(int soAo);

}