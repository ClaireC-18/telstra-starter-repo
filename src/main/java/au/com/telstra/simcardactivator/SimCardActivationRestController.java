package au.com.telstra.simcardactivator;

import au.com.telstra.simcardactivator.SimCardActivator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimCardActivationRestController {

    private final SimCardActuationHandler simCardActuationHandler;

    public SimCardActivationRestController(SimCardActuationHandler simCardActuationHandler) {
        this.simCardActuationHandler = simCardActuationHandler;
    }

    @PostMapping(value = "/activate")
    public void handleActivationRequest(@RequestBody SimCardActivator simCardActivator) {
        var actuationResult = simCardActuationHandler.actuate(simCardActivator);
        System.out.println(actuationResult.getSuccess());
    }

}
