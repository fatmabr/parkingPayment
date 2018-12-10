package parking.bill.payment.service;

import java.util.Date;

/**
 * Created by fatma on 03/12/2018.
 */
public interface BillingService {
    Double calculateBillAmount(Date beginDate, Date endDate);
}
