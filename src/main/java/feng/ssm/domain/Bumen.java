package feng.ssm.domain;

/**
 * @author Feng
 * @date 2021/6/7 9:40
 */
public class Bumen {
    private Integer id;
    private String bumenName;
    private String bumenDesc;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBumenName() {
        return bumenName;
    }

    public void setBumenName(String bumenName) {
        this.bumenName = bumenName;
    }

    public String getBumenDesc() {
        return bumenDesc;
    }

    public void setBumenDesc(String bumenDesc) {
        this.bumenDesc = bumenDesc;
    }

    @Override
    public String toString() {
        return "Bumen{" +
                "id=" + id +
                ", bumenName='" + bumenName + '\'' +
                ", bumenDesc='" + bumenDesc + '\'' +
                '}';
    }
}
