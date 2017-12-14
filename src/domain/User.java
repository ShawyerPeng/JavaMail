package domain;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private String password;
    private int flag;
    private String randomcode;
    private Object addtime;
    private String email;

    public User(String name, String password, int flag, String email, String randomcode, Date addtime) {
        this.name = name;
        this.password = password;
        this.flag=flag;
        this.email = email;
        this.randomcode = randomcode;
        this.addtime = addtime;
    }

    public User() {

    }

    public String getRandomcode() {
        return randomcode;
    }

    public void setRandomcode(String randomcode) {
        this.randomcode = randomcode;
    }

    public Object getAddtime() {
        return addtime;
    }

    public void setAddtime(Object addtime) {
        this.addtime = addtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", flag=" + flag +
                ", randomcode='" + randomcode + '\'' +
                ", addtime=" + addtime +
                ", email='" + email + '\'' +
                '}';
    }
}
