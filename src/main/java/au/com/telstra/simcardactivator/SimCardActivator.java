package au.com.telstra.simcardactivator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@JsonIgnoreProperties(ignoreUnknown = true)
@SpringBootApplication
public class SimCardActivator {
    private String iccid;
    private String customerEmail;
    private boolean active;

    public SimCardActivator() {
    }

    public SimCardActivator(String iccid, String customerEmail, boolean active) {
        this.iccid = iccid;
        this.customerEmail = customerEmail;
        this.active = active;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "SimCard {iccid=" + iccid + ", Customer Email=" + customerEmail + ", Active=" + active + "}";
    }
    public static void main(String[] args) {
        SpringApplication.run(SimCardActivator.class, args);
    }

}