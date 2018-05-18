package dao.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "express_info", schema = "express")
public class ExpressInfo {
    private String expressNo;
    private String fromName;
    private String fromTel;
    private String fromArea;
    private String fromAccount;
    private String toName;
    private String toTel;
    private String toArea;
    private String courierAccount;

    @Id
    @Column(name = "express_no", nullable = false, length = 50)
    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }

    @Basic
    @Column(name = "from_name", nullable = false, length = 10)
    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    @Basic
    @Column(name = "from_tel", nullable = false, length = 11)
    public String getFromTel() {
        return fromTel;
    }

    public void setFromTel(String fromTel) {
        this.fromTel = fromTel;
    }

    @Basic
    @Column(name = "from_area", nullable = false, length = 100)
    public String getFromArea() {
        return fromArea;
    }

    public void setFromArea(String fromArea) {
        this.fromArea = fromArea;
    }

    @Basic
    @Column(name = "from_account", nullable = false, length = 20)
    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    @Basic
    @Column(name = "to_name", nullable = false, length = 10)
    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    @Basic
    @Column(name = "to_tel", nullable = false, length = 11)
    public String getToTel() {
        return toTel;
    }

    public void setToTel(String toTel) {
        this.toTel = toTel;
    }

    @Basic
    @Column(name = "to_area", nullable = false, length = 100)
    public String getToArea() {
        return toArea;
    }

    public void setToArea(String toArea) {
        this.toArea = toArea;
    }

    @Basic
    @Column(name = "courier_account", nullable = false, length = 20)
    public String getCourierAccount() {
        return courierAccount;
    }

    public void setCourierAccount(String courierAccount) {
        this.courierAccount = courierAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpressInfo that = (ExpressInfo) o;
        return Objects.equals(expressNo, that.expressNo) &&
                Objects.equals(fromName, that.fromName) &&
                Objects.equals(fromTel, that.fromTel) &&
                Objects.equals(fromArea, that.fromArea) &&
                Objects.equals(fromAccount, that.fromAccount) &&
                Objects.equals(toName, that.toName) &&
                Objects.equals(toTel, that.toTel) &&
                Objects.equals(toArea, that.toArea) &&
                Objects.equals(courierAccount, that.courierAccount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(expressNo, fromName, fromTel, fromArea, fromAccount, toName, toTel, toArea, courierAccount);
    }
}
