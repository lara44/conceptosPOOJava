package concepts.conceptsPOOJava.data.factories;

import concepts.conceptsPOOJava.data.concrets.DaviplataMethod;
import concepts.conceptsPOOJava.data.concrets.NequiMethod;
import concepts.conceptsPOOJava.data.interfaces.IPaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component(value = "PaymentFactory")
public class PaymentFactory {
    @Qualifier(value = "DaviplataMethod")
    private final DaviplataMethod daviplataMethod;
    @Qualifier(value = "NequiMethod")
    private final NequiMethod nequiMethod;

    public PaymentFactory(DaviplataMethod daviplataMethod, NequiMethod nequiMethod) {
        this.daviplataMethod = daviplataMethod;
        this.nequiMethod = nequiMethod;
    }

    public IPaymentMethod create(String paymentMethod) {
        return switch (paymentMethod) {
            case "Nequi" -> nequiMethod;
            case "Daviplata" -> daviplataMethod;
            default -> throw new IllegalArgumentException("Payment Method: " + paymentMethod + " is not supported.");
        };
    }
}
