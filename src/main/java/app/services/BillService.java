package app.services;

import app.model.entity.Bill;

import java.util.List;

public interface BillService  extends Service<Bill>{
    List<Bill> findUnpaid();

    List<Bill> findPaid();

    List<Bill> UnpaidByUser(int user_id);

    List<Bill> PaidByUser(int user_id);
}
