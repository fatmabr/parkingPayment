package parking.bill.payment.service.impl;


import parking.bill.payment.model.BillingIntervals;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

/**
 * Created by fatma on 03/12/2018.
 */

public class BillingServiceImpl implements parking.bill.payment.service.BillingService {

    public Double calculateBillAmount(Date beginDate, Date endDate) {
        long duration = calculateDuration(beginDate, endDate);
        for (BillingIntervals billingIntervals : BillingIntervals.values()) {
            if (billingIntervals.isApplicable(duration)) {
                return billingIntervals.calculate(duration);
            }
        }
        return 0d;
    }

    private long calculateDuration(Date beginDate, Date endDate) {
        Calendar beginDateCalendar = GregorianCalendar.getInstance();
        beginDateCalendar.setTime(beginDate);
        Calendar endDateCalendar = GregorianCalendar.getInstance();
        endDateCalendar.setTime(endDate);
        /**
         * when end Date is the next date as begin date
         */
        if (endDateCalendar.compareTo(beginDateCalendar) < 0) {
            endDateCalendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        long duration = endDateCalendar.getTimeInMillis() - beginDateCalendar.getTimeInMillis();
        return TimeUnit.MINUTES.convert(duration, TimeUnit.MILLISECONDS);
    }

}
