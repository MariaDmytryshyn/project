package app.model.dao;

import app.model.entity.Bill;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface BillDao extends Dao<Bill> {
    List<Bill> findUnpaid();

    List<Bill> findPaid();

    List<Bill> UnpaidByUser(int user_id);

    List<Bill> PaidByUser(int user_id);
}