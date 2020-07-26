package app.model.entity;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;

public class DishTest {
    private Dish dish = new Dish("Шефбургер", "Chefburger", new BigDecimal(48.99), 1);

    @Test
    public void getIdTest() {
        dish.setId(2);
        assertEquals(2, dish.getId());
    }

    @Test
    public void setIdTest() {
        Dish dish = new Dish();
        dish.setId(11);
        assertEquals(11, dish.getId());
    }

    @Test
    public void getNameTest() {
        assertEquals("Шефбургер", dish.getName());
    }

    @Test
    public void setNameTest() {
        Dish dish = new Dish();
        dish.setName("Чізбургер");
        assertEquals("Чізбургер", dish.getName());
    }

    @Test
    public void getName_enTest() {
        assertEquals("Chefburger", dish.getName_en());
    }

    @Test
    public void setName_enTest() {
        Dish dish = new Dish();
        dish.setName_en("Cheeseburger");
        assertEquals("Cheeseburger", dish.getName_en());
    }

    @Test
    public void getPriceTest() {
        assertEquals(new BigDecimal(48.99).setScale(2, RoundingMode.CEILING), dish.getPrice());
    }

    @Test
    public void setPriceTest() {
        Dish dish = new Dish();
        dish.setPrice(new BigDecimal(50.00));
        assertEquals(new BigDecimal(50.00).setScale(2, RoundingMode.CEILING), dish.getPrice());
    }

    @Test
    public void getCategory_idTest() {
        assertEquals(1, dish.getCategory_id());
    }

    @Test
    public void setCategory_idTest() {
        Dish dish = new Dish();
        dish.setCategory_id(3);
        assertEquals(3, dish.getCategory_id());
    }

    @Test
    public void CategoryTest() {
        dish.setCategory(new Category("Сендвічі", "Burgers"));
        assertEquals(new Category("Сендвічі", "Burgers"), dish.getCategory());
    }

    @Test
    public void equalsTest() {
        Dish dish1 = new Dish("Чай", "Tea", new BigDecimal(20.00), 7);
        Dish dish2 = new Dish("Чай", "Tea", new BigDecimal(20.00), 7);
        assertEquals(true, dish1.equals(dish2));
    }

    @Test
    public void hashCodeTest() {
        Dish dish1 = new Dish();
        Dish dish2 = new Dish();
        dish1.setId(5);
        dish2.setId(5);
        assertEquals(dish1.hashCode(), dish2.hashCode());
     }





    @Test
    public void toStringTest() {
        assertEquals("Dish name is Шефбургер, name in English is Chefburger, price is 48.99, category id is 1", dish.toString());
    }


}
