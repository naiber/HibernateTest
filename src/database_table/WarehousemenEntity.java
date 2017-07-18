package database_table;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Michele on 14/07/2017.
 */
@Entity
@Table(name = "warehousemen", schema = "warehouse")
public class WarehousemenEntity {
    private String name;
    private String surname;
    private int id;

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany
    private List<MovementsEntity> movements;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WarehousemenEntity that = (WarehousemenEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString(){
        String res = "///Waremen Identity///";
        res += "\nname:    "+this.getName();
        res += "\nsurname: "+this.getSurname();
        return res;
    }
}
