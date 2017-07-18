package database_table;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Michele on 14/07/2017.
 */
@Entity
@Table(name = "departments", schema = "warehouse")
public class DepartmentsEntity {
    private String name;
    private int id;

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "departments",cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @OrderBy ("name asc")
    private List<ItemsEntity> items;

    public List<ItemsEntity> getItems() {
        return this.items;
    }
    public void setItems (List<ItemsEntity> items){
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentsEntity that = (DepartmentsEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString(){
        String res = "///Departments///";
        res += "\nID:          "+this.getId();
        res += "\nname:        "+this.getName();
        return res;
    }
}
