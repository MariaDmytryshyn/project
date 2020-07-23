package app.model.entity;

import java.util.Objects;

public class Waiter {
    private int id;
    private String name;
    private String name_en;
    private int table_id;
    private boolean is_free;

    public boolean isIs_free() {
        return is_free;
    }

    public void setIs_free(boolean is_free) {
        this.is_free = is_free;
    }

    private Tables table;

    public Waiter() {
    }

    public Waiter(int id, String name, String name_en, int table_id) {
        this.id = id;
        this.name = name;
        this.name_en = name_en;
        this.table_id = table_id;
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

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public Tables getTable() {
        return table;
    }

    public void setTable(Tables table) {
        this.table = table;
        this.table_id = table.getTablesId();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Waiter waiter = (Waiter) o;
        return id == waiter.id &&
                table_id == waiter.table_id &&
                Objects.equals(name, waiter.name) &&
                Objects.equals(name_en, waiter.name_en);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, name_en, table_id);
    }

    @Override
    public String toString() {
        return "Waiter" +
                " name is " + name + '\'' +
                ", name_en is " + name_en + '\'' +
                ", table number is " + table_id;
    }
}
