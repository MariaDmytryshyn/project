package app.model.entity;

import java.util.Objects;

public class Category {
    private int id;
    private String name;
    private String name_en;

    public Category() {
    }

    public Category(String name, String name_en) {
        this.name = name;
        this.name_en = name_en;
    }

    public int getCategoryId() {
        return id;
    }

    public void setCategoryId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return name;
    }

    public void setCategoryName(String name) {
        this.name = name;
    }

    public String getCategoryName_en() {
        return name_en;
    }

    public void setCategoryName_en(String name_en) {
        this.name_en = name_en;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id &&
                Objects.equals(name, category.name) &&
                Objects.equals(name_en, category.name_en);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategoryId(), getCategoryName(), getCategoryName_en());
    }

    @Override
    public String toString() {
        return "Category name is '" + name + '\'' +
                ", name in English is '" + name_en + '\'';
    }
}

