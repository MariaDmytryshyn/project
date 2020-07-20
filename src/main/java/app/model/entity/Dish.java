package app.model.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Dish {
    private int id;
    private String name;
    private String name_en;
    private BigDecimal price;
    private int category_id;
    private Category category;

    public Dish() {
    }

    public Dish(int id, String name, String name_en, BigDecimal price, int category_id) {
        this.id = id;
        this.name = name;
        this.name_en = name_en;
        this.price = price;
        this.category_id = category_id;
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

    public BigDecimal getPrice() {
        return price.setScale(2, RoundingMode.CEILING);
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return id == dish.id &&
                category_id == dish.category_id &&
                name.equals(dish.name) &&
                name_en.equals(dish.name_en) &&
                price.equals(dish.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, name_en, price, category_id);
    }

    @Override
    public String toString() {
        return "Dish " +
                "name is " + name +
                ", name in English is " + name_en  +
                ", price is " + price.setScale(2, RoundingMode.FLOOR).toString() +
                ", category id is " + category_id;
    }
}

