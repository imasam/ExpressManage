package dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Province {
    private String province;

    @Id
    @Column(name = "province", nullable = false, length = 10)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Province province1 = (Province) o;
        return Objects.equals(province, province1.province);
    }

    @Override
    public int hashCode() {

        return Objects.hash(province);
    }
}
