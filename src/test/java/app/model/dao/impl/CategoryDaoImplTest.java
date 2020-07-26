package app.model.dao.impl;


import app.model.dao.CategoryDao;
import app.model.entity.Category;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryDaoImplTest {


    DaoFactoryImpl daoFactory = new DaoFactoryImpl();
    CategoryDao categoryDao = daoFactory.createCategoryDao();

    @Test
    public void  findOneTest() {
        Category category = new Category("Сендвічі", "Burgers");
        category.setCategoryId(1);
        assertEquals(category, categoryDao.findOne(1));
    }
}

