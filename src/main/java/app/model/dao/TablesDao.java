package app.model.dao;

import app.model.entity.Tables;
import app.model.entity.Waiter;

import java.util.List;

public interface TablesDao extends Dao<Tables> {
    List<Tables> findFree();
    Waiter findWaiter(Tables entity);

}
