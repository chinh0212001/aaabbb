package model.bongda;

import java.io.Serializable;

public class HLV implements Serializable {
    private int id;
    private String coachName;
    private String detail;

    public HLV() {

    }
    public HLV(int id, String coachName, String detail) {
        this.id = id;
        this.coachName = coachName;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "HLV{" +
                "id=" + id +
                ", coach='" + coachName + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
