package feng.ssm.domain;

/**
 * 管理员用户实体类
 */
public class UserInfo {

    private int id;
    private String username;
    private String password;
    private String peopleName;
    private String phoneNume;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public String getPhoneNume() {
        return phoneNume;
    }

    public void setPhoneNume(String phoneNume) {
        this.phoneNume = phoneNume;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", peopleName='" + peopleName + '\'' +
                ", phoneNume='" + phoneNume + '\'' +
                '}';
    }
}

