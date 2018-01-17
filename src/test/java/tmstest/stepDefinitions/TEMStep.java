package tmstest.stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

public class TEMStep {
    static final Logger logs = LoggerFactory.getLogger(TEMStep.class);

    @Then("^The vehicle excute \"(.*?)\" command success$")
    public void TemResponse(String service) throws IOException, InterruptedException {
        if (service.equals("remote honk & flash")) {
            //no any excution
            return;}
    }}

