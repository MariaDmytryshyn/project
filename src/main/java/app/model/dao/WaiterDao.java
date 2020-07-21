package app.model.dao;

import app.model.dao.impl.Language;
import app.model.entity.Tables;
import app.model.entity.Waiter;

public interface WaiterDao extends Dao<Waiter> {
    Tables getTable(int id);
    Waiter getWaiterByName(String name, Language language);

}

