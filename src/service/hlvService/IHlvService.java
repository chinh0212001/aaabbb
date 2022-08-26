package service.hlvService;

import model.bongda.HLV;
import service.IGenericService;

public interface IHlvService extends IGenericService<HLV> {
    void remove(int id);
}
