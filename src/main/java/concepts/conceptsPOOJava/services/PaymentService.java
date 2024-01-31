package concepts.conceptsPOOJava.services;
import concepts.conceptsPOOJava.data.concrets.DaviplataMethod;
import concepts.conceptsPOOJava.data.interfaces.IPaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "PaymentService")
public class PaymentService {
    private IPaymentMethod method;

    public void setPaymentMethod(IPaymentMethod method) {
        this.method = method;
    }
    public String process() {
        if(this.method == null) {
            throw new IllegalArgumentException("Payment method has not been set.");
        }
        try {
            return this.method.applyPayment();
        } catch (Exception e) {
            throw new IllegalArgumentException("Error processing payment.", e);
        }
    }
}
