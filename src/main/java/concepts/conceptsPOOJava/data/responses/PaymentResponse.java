package concepts.conceptsPOOJava.data.responses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component()
public class PaymentResponse {
    private String message;
    private HttpStatus status;

    public PaymentResponse() {}

    public String getMessage() {
        return message;
    }

    public HttpStatus  getStatus() {
        return status;
    }

    public void setMessage(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
