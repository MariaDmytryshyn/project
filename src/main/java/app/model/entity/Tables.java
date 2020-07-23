package app.model.entity;

import java.util.Objects;

public class Tables {
    private int id;
    private int number;
    private boolean is_free;

    public boolean isIs_free() {
        return is_free;
    }

    public void setIs_free(boolean is_free) {
        this.is_free = is_free;
    }

    public Tables() {
    }

    public Tables(int id, int number) {
        this.id = id;
        this.number = number;
    }

    public int getTablesId() {
        return id;
    }

    public int getTablesNumber() {
        return number;
    }

    public void setTablesId(int id) {
        this.id = id;
    }

    public void setTablesNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tables tables = (Tables) o;
        return id == tables.id &&
                number == tables.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTablesId(), getTablesNumber());
    }

    @Override
    public String toString() {
        return "Table number is" + number;
    }
}

