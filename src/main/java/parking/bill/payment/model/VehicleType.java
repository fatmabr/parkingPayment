package parking.bill.payment.model;

/**
 * Created by fatma on 03/12/2018.
 */
public enum VehicleType {
    N("Normal Vehicle"),
    LPG("LPG Vehicle"),
    TWOWEELER("Tow weeler vehicle");

    private String label;

    VehicleType(String label) {
        this.label = label;
    }

}
