package au.com.telstra.simcardactivator;

import au.com.telstra.simcardactivator.ActuationResult;
import au.com.telstra.simcardactivator.SimCardActivator;

import javax.persistence.*;

@Entity

public class SimDBRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "simCardId", nullable = false)
    private Long simCardId;
    @Column(name = "iccid", nullable = false)
    private String iccid;
    @Column(name = "customerEmail", nullable = false)
    private String customerEmail;
    @Column(name = "boolean", nullable = false)
    private boolean active;

    public SimDBRecord() {
    }

    public SimDBRecord(SimCardActivator simCardActivator, ActuationResult actuationResult) {
        this.iccid = simCardActivator.getIccid();
        this.customerEmail = simCardActivator.getCustomerEmail();
        this.active = actuationResult.getSuccess();
    }

    public long getsimCardId() {
        return simCardId;
    }

    public String getIccid() {
        return iccid;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public boolean getActive() {
        return active;
    }
    @Override
    public String toString() {
        return "SimCard {ID =" + simCardId + ", iccid=" + iccid + ", Customer Email=" + customerEmail + ", Active=" + active + "}";
    }
}
