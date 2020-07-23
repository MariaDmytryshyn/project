package app.services;

import app.model.entity.Tables;
import app.model.entity.Waiter;

import java.util.List;

public interface TablesService extends Service<Tables> {
    List<Tables> findFree();
    Waiter findWaiter(Tables entity);
}
