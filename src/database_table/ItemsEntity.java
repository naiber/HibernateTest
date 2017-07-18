package database_table;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michele on 14/07/2017.
 */
@Entity
@Table(name = "items", schema = "warehouse")
public class ItemsEntity {
    private String name;
    private Integer price;
    private Integer size;
    private int id;
    private String description;

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "size")
    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne
    @Column (name = "dep" , nullable = false)//nome colonna della table items nel database warehouse
    private DepartmentsEntity departments;//nome oggetto nel mappedBy di DepartmentsEntity(l'entita di destinazione)
                                          //che contiene una List di Item
    public DepartmentsEntity getDepartments(){return this.departments;}
    public void setDepartments(DepartmentsEntity departments){this.departments = departments;}


    @OneToMany (mappedBy = "items",fetch = FetchType.LAZY)
    @OrderBy ("date asc")
    private List<MovementsEntity> movements;
    public List<MovementsEntity> getMovements(){return this.movements;}
    public void setMovements(List<MovementsEntity> movements){this.movements = movements;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemsEntity that = (ItemsEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public void replaceItem(ItemsEntity item){
        if(item.name!= "" || item.name!=null){
            this.setName(item.name);
        }
        if(item.price!=null){
            this.setPrice(item.price);
        }
        if(item.size!=null){
            this.setSize(item.size);
        }
        if(item.description!= "" || item.description!=null){
            this.setDescription(item.description);
        }
        if(item.departments.getName()!= "" || item.departments!=null){
            this.setDepartments(item.departments);
        }
    }

    @Override
    public String toString(){
        String res = "///Item///";
        res += "\nID:          "+this.getId();
        res += "\nname:        "+this.getName();
        res += "\nprice:       "+this.getDescription();
        res += "\nstored size: "+this.getSize();
        res += "\ndepartment:  "+this.getDepartments().getName();
        return res;
    }
}
