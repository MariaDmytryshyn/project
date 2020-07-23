package app.services;

import app.model.dao.impl.Language;
import app.model.entity.Tables;
import app.model.entity.Waiter;

public interface WaiterService extends Service<Waiter> {
    Waiter getWaiterByName(String name, Language language);
}
