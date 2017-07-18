package database_table;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Michele on 14/07/2017.
 */

@Entity
@Table(name = "movements", schema = "warehouse")
public class MovementsEntity {
    private Integer size;
    private int id;
    private Date date;

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
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne
    @Column (name = "item")
    private ItemsEntity items;

    public ItemsEntity getItems(){return this.items;}
    public void setItems(ItemsEntity items){this.items=items;}


    @ManyToOne
    @JoinColumn (name = "waremen")
    private WarehousemenEntity warehousemen;

    public WarehousemenEntity getWarehousemen(){return this.warehousemen;}
    public void setWarehousemen(WarehousemenEntity warehousemen){this.warehousemen=warehousemen;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovementsEntity that = (MovementsEntity) o;

        if (id != that.id) return false;
        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = size != null ? size.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
