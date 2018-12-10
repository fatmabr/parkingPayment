package parking.bill.payment;

import parking.bill.payment.model.VehicleType;
import parking.bill.payment.service.BillingService;
import parking.bill.payment.service.impl.BillingServiceImpl;
import parking.bill.payment.service.impl.LPGBillingServiceImpl;
import parking.bill.payment.service.impl.TwoWeelerBillingServiceImpl;
import parking.bill.payment.utils.BillingUtils;

import java.util.Date;

/**
 * Created by fatma on 03/12/2018.
 */
public class PaymentDelegate {

    public BillingService getPaymentService(VehicleType vehicleType) {
        switch (vehicleType) {
            case LPG:
                return new LPGBillingServiceImpl();
            case TWOWEELER:
                return new TwoWeelerBillingServiceImpl();
            default:
                return new BillingServiceImpl();
        }
    }

    public Double calculateBillAmount(VehicleType vehicleType, Date beginDate, Date endDate) {
        Double amount = getPaymentService(vehicleType).calculateBillAmount(beginDate, endDate);
        return BillingUtils.round(amount);
    }
}
