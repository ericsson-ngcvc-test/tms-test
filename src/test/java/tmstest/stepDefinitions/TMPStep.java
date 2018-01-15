package tmstest.stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class TMPStep {

    @When("^I select \"(.*?)\" page$")
    public void TmpRequery(String service) throws IOException, InterruptedException{
        if (service.equals("ecall")){
            //fake step
        }
        else if(service.equals("oncall info")){
            //fake step
        }
        else if(service.equals("POI")){
            //fake step
        }
        else if(service.equals("send to car")){
            //fake step
        }
    }

    @When("^I send \"(.*?)\" to vehicle$")
    public void TmpOperate(String service) throws IOException, InterruptedException{
        if (service.equals("Ecall ETA")){
            //fake step
        }
        else if(service.equals("Ecall CLOSE")){
            //fake step
            assertTrue(false);
        }
    }

    @When("^I can get \"(.*?)\" of the event$")
    public void TmpQueryResult(String service) throws IOException, InterruptedException{
        if (service.equals("ecall vehicle info and location")){
            //fake step
        }
        if (service.equals("oncall vehivle location")){
            //fake step
        }
        if (service.equals("icall vehivle location")){
            //fake step
        }
    }

    @Then("^Vehicle receive the \"(.*?)\" message$")
    public void TemReceMess(String service) throws IOException, InterruptedException{
        if (service.equals("Ecall ETA")){
            //fake step
            assertTrue(true);
        }
        else if (service.equals("Ecall CLOSE")){
            //fake step
            assertTrue(true);
        }
        else if (service.equals("POI")){
            //fake step
            assertTrue(false);
        }
    }


}
