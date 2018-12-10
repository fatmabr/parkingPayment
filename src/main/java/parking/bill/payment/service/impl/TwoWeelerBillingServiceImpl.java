package parking.bill.payment.service.impl;

import java.util.Date;

/**
 * Created by fatma on 03/12/2018.
 */
public class TwoWeelerBillingServiceImpl extends BillingServiceImpl {
    @Override
    public Double calculateBillAmount(Date beginDate, Date endDate) {
        Double amount = super.calculateBillAmount(beginDate, endDate);
        return amount/2.0;
    }
}
