package app.model.dao;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract BillDao createBillDao();
    public abstract CategoryDao createCategoryDao();
    public abstract DishDao createDishDao();
    public abstract OrderDishDao createOrderDishDao();
    public abstract OrdersDao createOrderDao();
    public abstract TablesDao createTableDao();
    public abstract UserDao createUserDao();
    public abstract WaiterDao createWaiterDao();


//    public static DaoFactory getInstance(){
//        if( daoFactory == null ){
//            synchronized (DaoFactory.class){
//                if(daoFactory==null){
//                    DaoFactory temp = new DaoFactoryImpl();
//                    daoFactory = temp;
//                }
//            }
//        }
//        return daoFactory;
//    }
}
