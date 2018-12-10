package parking.bill.payment;
import parking.bill.payment.PaymentDelegate;
import parking.bill.payment.model.VehicleType;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by fatma on 03/12/2018.
 */
public class ParkingMain {
    public static void main(String... args) {
        PaymentDelegate paymentDelegate = new PaymentDelegate();
        Calendar beginDate = getDate(13, 24);
        Calendar endDate = getDate(15, 10);
        Double amount = paymentDelegate.calculateBillAmount(VehicleType.N, beginDate.getTime(), endDate.getTime());
        System.out.println(amount);

        beginDate = getDate(19, 30);
        endDate = getDate(00, 37);
        amount = paymentDelegate.calculateBillAmount(VehicleType.TWOWEELER, beginDate.getTime(), endDate.getTime());
        System.out.println(amount);

        beginDate = getDate(7, 43);
        endDate = getDate(15, 10);
        amount = paymentDelegate.calculateBillAmount(VehicleType.LPG, beginDate.getTime(), endDate.getTime());
        System.out.println(amount);
    }

    private static Calendar getDate(int hour, int minute) {
        Calendar beginDate = GregorianCalendar.getInstance();
        beginDate.set(Calendar.HOUR, hour);
        beginDate.set(Calendar.MINUTE, minute);
        return beginDate;
    }
}
