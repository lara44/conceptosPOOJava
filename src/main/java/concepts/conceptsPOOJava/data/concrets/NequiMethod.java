package concepts.conceptsPOOJava.data.concrets;

import concepts.conceptsPOOJava.data.interfaces.IPaymentMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component(value = "NequiMethod")
public class NequiMethod implements IPaymentMethod {
    @Override
    public String applyPayment() {
        try {
            return "Nequi, process payment correctly!";
        } catch (Exception e) {
            throw new IllegalArgumentException("Payment error with Nequi:", e);
        }
    }
}
