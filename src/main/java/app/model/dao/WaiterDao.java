package app.model.dao;

import app.model.entity.Tables;
import app.model.entity.Waiter;

public interface WaiterDao extends Dao<Waiter> {
    Tables getTable(int id);
    String getNameByLanguage(int id, String language);

}

