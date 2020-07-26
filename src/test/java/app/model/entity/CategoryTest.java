package app.model.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryTest {
    private Category category = new Category("Сендвічі", "Burgers");

    @Test
    public void getCategoryIdTest() {
        category.setCategoryId(1);
        assertEquals(1, category.getCategoryId());
    }

    @Test
    public void setCategoryIdTest() {
        Category cat = new Category();
        cat.setCategoryId(5);
        assertEquals(5, cat.getCategoryId());
    }

    @Test
    public void getCategoryNameTest() {
        assertEquals("Сендвічі", category.getCategoryName());
    }

    @Test
    public void setCategoryNameTest() {
        Category category = new Category();
        category.setCategoryName("Напої");
        assertEquals("Напої", category.getCategoryName());
    }

    @Test
    public void getCategoryName_enTest() {
        assertEquals("Burgers", category.getCategoryName_en());
    }

    @Test
    public void setCategoryName_enTest() {
        Category category = new Category();
        category.setCategoryName_en("Drinks");
        assertEquals("Drinks", category.getCategoryName_en());
    }

    @Test
    public void toStringTest() {
        assertEquals("Category name is 'Сендвічі', name in English is 'Burgers'", category.toString());
    }

    @Test
    public void equalsTest() {
        Category category1 = new Category("Напої", "Drinks");
        Category category2 = new Category("Напої", "Drinks");
        assertEquals(true, category1.equals(category2));
    }

    @Test
    public void hashCodeTest() {
        Category category1 = new Category();
        Category category2 = new Category();
        category1.setCategoryId(3);
        category2.setCategoryId(3);
        assertEquals(category1.hashCode(), category2.hashCode());
    }



}
