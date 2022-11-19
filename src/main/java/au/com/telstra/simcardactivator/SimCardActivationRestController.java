package au.com.telstra.simcardactivator;

import au.com.telstra.simcardactivator.SimCardActivator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
public class SimCardActivationRestController {

    private final SimCardActuationHandler simCardActuationHandler;
    private final DBBase dBBase;

    public SimCardActivationRestController(DBBase dBBase, SimCardActuationHandler simCardActuationHandler) {
        this.dBBase = dBBase;
        this.simCardActuationHandler = simCardActuationHandler;
    }

    @PostMapping(value = "/activate")
    public void handleActivationRequest(@RequestBody SimCardActivator simCardActivator) {
        var actuationResult = simCardActuationHandler.actuate(simCardActivator);
        dBBase.save(simCardActivator, actuationResult);
    }

    @GetMapping(value = "/query")
    public SimCardActivator handleActivationRequest(@RequestParam Long simCardId) {
        return dBBase.querySimCard(simCardId);
    }
}