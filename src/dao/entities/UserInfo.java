package dao.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_info", schema = "express")
public class UserInfo {
    private String account;
    private String password;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(account, userInfo.account) &&
                Objects.equals(password, userInfo.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(account, password);
    }
}
