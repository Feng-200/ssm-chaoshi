package feng.ssm.domain;

/**
 * @author Feng
 * @date 2021/6/7 9:42
 */
public class Yuangong {
    private Integer id;
    private String name;
    private String phone;
    private Bumen bumen;
    private Integer bumenId;
    private double gongzi;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Bumen getBumen() {
        return bumen;
    }

    public void setBumen(Bumen bumen) {
        this.bumen = bumen;
    }

    public Integer getBumenId() {
        return bumenId;
    }

    public void setBumenId(Integer bumenId) {
        this.bumenId = bumenId;
    }

    public double getGongzi() {
        return gongzi;
    }

    public void setGongzi(double gongzi) {
        this.gongzi = gongzi;
    }

    @Override
    public String toString() {
        return "Yuangong{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", bumen=" + bumen +
                ", bumenId=" + bumenId +
                ", gongzi=" + gongzi +
                '}';
    }
}
