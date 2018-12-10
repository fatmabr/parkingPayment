import org.junit.Test;
import parking.bill.payment.service.impl.BillingServiceImpl;
import parking.bill.payment.service.impl.LPGBillingServiceImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by fatma on 10/12/2018.
 */
public class LPGBillingServiceTest {

    @Test
    public void test_when_duration_less_than_hour() {

        Calendar instance = GregorianCalendar.getInstance();
        instance.set(Calendar.HOUR, 13);
        instance.set(Calendar.MINUTE, 13);

        Date beginDate = instance.getTime();

        Calendar instance1 = GregorianCalendar.getInstance();
        instance1.set(Calendar.HOUR, 14);
        instance1.set(Calendar.MINUTE, 13);

        Date endDate = instance1.getTime();

        LPGBillingServiceImpl billingService = new LPGBillingServiceImpl();
        Double aDouble = billingService.calculateBillAmount(beginDate, endDate);
        assert aDouble == 0;
    }

    @Test
    public void test_when_duration_is_hour_and_one_minute() {

        Calendar instance = GregorianCalendar.getInstance();
        instance.set(Calendar.HOUR, 13);
        instance.set(Calendar.MINUTE, 13);

        Date beginDate = instance.getTime();

        Calendar instance1 = GregorianCalendar.getInstance();
        instance1.set(Calendar.HOUR, 14);
        instance1.set(Calendar.MINUTE, 14);

        Date endDate = instance1.getTime();

        LPGBillingServiceImpl billingService = new LPGBillingServiceImpl();
        Double aDouble = billingService.calculateBillAmount(beginDate, endDate);
        assert aDouble == 2.14;
    }

    @Test
    public void test_when_duration_is_three_hour_one_minute() {

        Calendar instance = GregorianCalendar.getInstance();
        instance.set(Calendar.HOUR, 11);
        instance.set(Calendar.MINUTE, 13);

        Date beginDate = instance.getTime();

        Calendar instance1 = GregorianCalendar.getInstance();
        instance1.set(Calendar.HOUR, 14);
        instance1.set(Calendar.MINUTE, 14);

        Date endDate = instance1.getTime();

        LPGBillingServiceImpl billingService = new LPGBillingServiceImpl();
        Double aDouble = billingService.calculateBillAmount(beginDate, endDate);
        assert aDouble == 6.42;
    }

    @Test
    public void test_when_duration_is_three_hour() {

        Calendar instance = GregorianCalendar.getInstance();
        instance.set(Calendar.HOUR, 11);
        instance.set(Calendar.MINUTE, 13);

        Date beginDate = instance.getTime();

        Calendar instance1 = GregorianCalendar.getInstance();
        instance1.set(Calendar.HOUR, 14);
        instance1.set(Calendar.MINUTE, 13);

        Date endDate = instance1.getTime();

        LPGBillingServiceImpl billingService = new LPGBillingServiceImpl();
        Double aDouble = billingService.calculateBillAmount(beginDate, endDate);
        assert aDouble == 4.28;
    }

    @Test
    public void test_when_duration_is_four_hour() {

        Calendar instance = GregorianCalendar.getInstance();
        instance.set(Calendar.HOUR, 10);
        instance.set(Calendar.MINUTE, 13);

        Date beginDate = instance.getTime();

        Calendar instance1 = GregorianCalendar.getInstance();
        instance1.set(Calendar.HOUR, 14);
        instance1.set(Calendar.MINUTE, 13);

        Date endDate = instance1.getTime();

        LPGBillingServiceImpl billingService = new LPGBillingServiceImpl();
        Double aDouble = billingService.calculateBillAmount(beginDate, endDate);
        assert aDouble == 6.42;
    }

    @Test
    public void test_when_duration_is_four_hour_and_one_minute() {

        Calendar instance = GregorianCalendar.getInstance();
        instance.set(Calendar.HOUR, 10);
        instance.set(Calendar.MINUTE, 13);

        Date beginDate = instance.getTime();

        Calendar instance1 = GregorianCalendar.getInstance();
        instance1.set(Calendar.HOUR, 14);
        instance1.set(Calendar.MINUTE, 14);

        Date endDate = instance1.getTime();

        LPGBillingServiceImpl billingService = new LPGBillingServiceImpl();
        Double aDouble = billingService.calculateBillAmount(beginDate, endDate);
        assert aDouble == 8.025;
    }
}
