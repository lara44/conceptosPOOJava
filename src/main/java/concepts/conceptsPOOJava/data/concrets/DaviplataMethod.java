package concepts.conceptsPOOJava.data.concrets;

import concepts.conceptsPOOJava.data.interfaces.IPaymentMethod;
import org.springframework.stereotype.Component;

@Component(value = "DaviplataMethod")
public class DaviplataMethod implements IPaymentMethod  {
    @Override
    public String applyPayment() {
        try {
            return "Daviplata processed the payment correctly!";
        } catch (Exception e) {
            throw new IllegalArgumentException("Payment error with Daviplata:", e);
        }
    }
}
