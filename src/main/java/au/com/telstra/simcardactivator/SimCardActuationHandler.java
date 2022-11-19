package au.com.telstra.simcardactivator;

import au.com.telstra.simcardactivator.ActuationResult;
import au.com.telstra.simcardactivator.SimCardActivator;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SimCardActuationHandler {
    private final RestTemplate restTemplate;
    private final String incentiveApiUrl;

    public SimCardActuationHandler(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
        this.incentiveApiUrl = "http://localhost:8444/actuate";
    }

    public ActuationResult actuate(SimCardActivator simCardActivator) {
        return restTemplate.postForObject(incentiveApiUrl, simCardActivator, ActuationResult.class);
    }

}