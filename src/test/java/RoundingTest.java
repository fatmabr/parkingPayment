import org.junit.Test;
import parking.bill.payment.utils.BillingUtils;

/**
 * Created by fatma on 10/12/2018.
 */
public class RoundingTest {
    @Test
    public void round_less_than_2() throws Exception {
        Double round = BillingUtils.round(1.01);
        assert round == 1.5;
    }

    @Test
    public void round_less_more_than_2() throws Exception {
        Double round = BillingUtils.round(1.51);
        assert round == 2;
    }
}
