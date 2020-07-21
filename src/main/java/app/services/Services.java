package app.services;

import app.services.impl.*;

public class Services {
    public static final BillService BILL_SERVICE = new BillServiceImpl();
    public static final CategoryService CATEGORY_SERVICE = new CategoryServiceImpl();
    public static final DishService DISH_SERVICE = new DishServiceImpl();
    public static final OrderDishService ORDER_DISH_SERVICE = new OrderDishServiceImpl();
    public static final OrdersService ORDERS_SERVICE = new OrderServiceImpl();
    public static final TablesService TABLES_SERVICE = new TablesServiceImpl();
    public static final UserService USER_SERVICE = new UserServiceImpl();
    public static final WaiterService WAITER_SERVICE = new WaiterServiceImpl();
}
