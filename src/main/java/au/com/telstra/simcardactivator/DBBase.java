package au.com.telstra.simcardactivator;

import au.com.telstra.simcardactivator.ActuationResult;
import au.com.telstra.simcardactivator.SimCardActivator;
import au.com.telstra.simcardactivator.SimDBRecord;
import au.com.telstra.simcardactivator.SimRepository;
import org.springframework.stereotype.Component;

@Component
public class DBBase {
    private final SimRepository simRepository;

    public DBBase(SimRepository simRepository) {
        this.simRepository = simRepository;
    }

    public void save(SimCardActivator simCardActivator, ActuationResult actuationResult) {
        SimDBRecord simDBRecord = new SimDBRecord(simCardActivator, actuationResult);
        simRepository.save(simDBRecord);
    }

    public SimCardActivator querySimCard(long simCardId) {
        var simDBRecord = simRepository.findById(simCardId).orElse(null);
        if (simDBRecord == null) {
            return null;
        }
        return new SimCardActivator(simDBRecord);
    }
}