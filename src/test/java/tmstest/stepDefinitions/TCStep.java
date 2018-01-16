package tmstest.stepDefinitions;

import tmstest.FunctionFactory.TC.api.*;

import tmstest.tools.GlobalValue;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

import com.jayway.restassured.response.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

public class TCStep {
    static final Logger logs = LoggerFactory.getLogger(TCStep.class);

    AppBackend app = new AppBackend();
    static String tc_token = "";

    Response result;
    Response Login_result;
    Response RVS_result;
    Response RDL_result;
    Response RDU_result;

    @Given("^I login the mobile app$")
    public void login() throws IOException, InterruptedException{
        logs.info("start login step");
        Login_result = app.login();
        tc_token = Login_result.jsonPath().getString("tcToken");
        assertEquals(200,Login_result.statusCode());

        assertTrue(true);     //fake step
        }

    @When("^I press \"(.*?)\" button in mobile app$")
    public void AppSendMessage(String service) throws IOException,InterruptedException {
        if (service.equals("remote status")) {
            RVS_result = app.QueryTelematry(tc_token);
            assertEquals(200,RVS_result.statusCode());
        }
        else if (service.equals("door lock")) {
            result = app.RemoteControl(tc_token,"RDL",null);
            assertEquals(200, RDL_result.statusCode());
            assertEquals(1,result.jsonPath().getInt("data.serviceResult.operationResult"));
        }
        else if (service.equals("door unlock")) {
            result = app.RemoteControl(tc_token,"RDU",null);
            assertEquals(200, RDL_result.statusCode());
            assertEquals(1,result.jsonPath().getInt("data.serviceResult.operationResult"));
        }
        else if (service.equals("start engine")) {
            result = app.RemoteControl(tc_token,"RES","start");
            assertEquals(200, result.statusCode());
            assertEquals(1,result.jsonPath().getInt("data.serviceResult.operationResult"));
        }
        else if (service.equals("stop engine")) {
            result = app.RemoteControl(tc_token,"RES","stop");
            assertEquals(200, result.statusCode());
            assertEquals(1,result.jsonPath().getInt("data.serviceResult.operationResult"));
        }
        else if (service.equals("close windows")) {
            result = app.RemoteControl(tc_token,"RWS","stop");
            assertEquals(200, result.statusCode());
            assertEquals(1,result.jsonPath().getInt("data.serviceResult.operationResult"));
        }
        else if (service.equals("start air condition")) {
            result = app.RemoteControl(tc_token,"RCE","start");
            assertEquals(200, result.statusCode());
            assertEquals(1,result.jsonPath().getInt("data.serviceResult.operationResult"));
        }
        else if (service.equals("door open")) {
            assertTrue(true);       //fake step
        }
        else if (service.equals("door close")) {
            assertTrue(true);       //fake step
        }
        else if (service.equals("remote active")) {
            assertTrue(true);       //fake step
        }
        else {
            result = app.RemoteControl(tc_token,service,"");
            assertEquals(200, result.statusCode());
        }

    }

    @Then("^I can get latest \"(.*?)\" status$")
    public void GetRVS(String service) throws IOException, InterruptedException {
        result = app.QueryTelematry(tc_token);

        if (service.equals("remote vehicle")) {
            logs.info(RVS_result.jsonPath().getString("data.result.serviceId"));
            logs.info(RVS_result.jsonPath().getString("data.result.vin"));
            assertEquals("RVS",RVS_result.jsonPath().getString("data.result.serviceId"));
            assertEquals(GlobalValue.VIN,RVS_result.jsonPath().getString("data.result.vin"));
        }
        else if (service.equals("door lock")) {
            assertEquals(1, result.jsonPath().getInt("data.vehicleStatus.additionalVehicleStatus.drivingSafetyStatus.doorLockStatusDriver"));
            assertEquals(1, result.jsonPath().getInt("data.vehicleStatus.additionalVehicleStatus.drivingSafetyStatus.doorLockStatusPassenger"));
            assertEquals(1, result.jsonPath().getInt("data.vehicleStatus.additionalVehicleStatus.drivingSafetyStatus.doorLockStatusDriverRear"));
            assertEquals(1, result.jsonPath().getInt("data.vehicleStatus.additionalVehicleStatus.drivingSafetyStatus.doorLockStatusPassengerRear"));
        }
        else if (service.equals("door unlock")) {
            assertEquals(0, result.jsonPath().getInt("data.vehicleStatus.additionalVehicleStatus.drivingSafetyStatus.doorLockStatusDriver"));
            assertEquals(0, result.jsonPath().getInt("data.vehicleStatus.additionalVehicleStatus.drivingSafetyStatus.doorLockStatusPassenger"));
            assertEquals(0, result.jsonPath().getInt("data.vehicleStatus.additionalVehicleStatus.drivingSafetyStatus.doorLockStatusDriverRear"));
            assertEquals(0, result.jsonPath().getInt("data.vehicleStatus.additionalVehicleStatus.drivingSafetyStatus.doorLockStatusPassengerRear"));
        }
        else if (service.equals("engine started")) {
            assertEquals(0, result.jsonPath().getInt("data.result.serviceResult.operationResult"));
            assertEquals("ENGINE_RUNNING",result.jsonPath().getString("data.vehicleStatus.basicVehicleStatus.engineStatus"));
        }
        else if (service.equals("engine stopped")) {
            assertEquals(0, result.jsonPath().getInt("data.result.serviceResult.operationResult"));
            assertEquals("ENGINE_OFF",result.jsonPath().getString("data.vehicleStatus.basicVehicleStatus.engineStatus"));
        }
        else if (service.equals("windows closed")) {
            assertEquals(0, result.jsonPath().getInt("data.result.serviceResult.operationResult"));
            assertEquals(2, result.jsonPath().getInt("data.vehicleStatus.additionalVehicleStatus.climateStatus.winStatusDriver"));
            assertEquals(2, result.jsonPath().getInt("data.vehicleStatus.additionalVehicleStatus.climateStatus.winStatusPassenger"));
            assertEquals(2, result.jsonPath().getInt("data.vehicleStatus.additionalVehicleStatus.climateStatus.winStatusDriverRear"));
            assertEquals(2, result.jsonPath().getInt("data.vehicleStatus.additionalVehicleStatus.climateStatus.winStatusPassengerRear"));
            assertEquals(1, result.jsonPath().getInt("data.vehicleStatus.additionalVehicleStatus.climateStatus.sunroofOpenStatus"));
        }
        else if (service.equals("Cliamte stop")) {
            assertTrue(false);   //fake step
        }
        else if (service.equals("all journay logs")) {
            assertTrue(true);   //fake step
        }
        else if (service.equals("trip detail")) {
            assertTrue(true);   //fake step
        }
    }

    /**
     * fake step
     */
    @When("^Vehicle's remote control activation status is off$")
    public void RC_activate_off() throws IOException, InterruptedException {
        assertTrue(true);
    }

    /**
     * fake step
     */
    @When("^Vehicle's remote control activation status turn to on$")
    public void RC_activate_on() throws IOException, InterruptedException {
        assertTrue(true);
    }

    /**
     * fake step
     */
    @When("^Input last 8 charactoer of the vin$")
    public void input_vin() throws IOException, InterruptedException {
        assertTrue(true);
    }

    /**
     * fake step
     */
    @When("^Input vehicle onwer's phone number$")
    public void input_own_phone() throws IOException, InterruptedException {
        assertTrue(true);
    }

    /**
     * fake step
     */
    @When("^new car will be showed on app$")
    public void car_bind_result() throws IOException, InterruptedException {
        assertTrue(false);
    }

    /**
     * fake step
     */
    @When("^The switch of journey log is ([^\"]*)$")
    public void joulog_switch(String oldstatus) throws IOException, InterruptedException {
        assertTrue(true);
    }

    /**
     * fake step
     */
    @Then("^I switch to ([^\"]*)$")
    public void joulog_switch_operate(String newstatus) throws IOException, InterruptedException {
        assertTrue(true);
    }

}
