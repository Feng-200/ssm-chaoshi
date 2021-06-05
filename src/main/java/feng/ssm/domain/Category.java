package feng.ssm.domain;

/**
 * 部门实体类
 */
public class Category {
    private Integer id;
    private String catName;
    private String catDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatDesc() {
        return catDesc;
    }

    public void setCatDesc(String catDesc) {
        this.catDesc = catDesc;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", catName='" + catName + '\'' +
                ", catDesc='" + catDesc + '\'' +
                '}';
    }
}
