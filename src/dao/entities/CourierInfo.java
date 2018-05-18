package dao.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "courier_info", schema = "express")
public class CourierInfo {
    private String account;
    private String password;
    private String name;
    private String city;
    private String tel;

    @Id
    @Column(name = "account", nullable = false, length = 20)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 10)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "city", nullable = false, length = 20)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "tel", nullable = false, length = 11)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourierInfo that = (CourierInfo) o;
        return Objects.equals(account, that.account) &&
                Objects.equals(password, that.password) &&
                Objects.equals(name, that.name) &&
                Objects.equals(city, that.city) &&
                Objects.equals(tel, that.tel);
    }

    @Override
    public int hashCode() {

        return Objects.hash(account, password, name, city, tel);
    }
}
