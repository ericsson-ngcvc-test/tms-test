package csptest.stepDefinitions;

import csptest.FunctionFactory.TC.api.*;

import csptest.tools.GlobalValue;
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
    dbsample db = new dbsample();
    static String tc_token = "";

    Response result;
    Response Login_result;
    Response RVS_result;

    @Given("^I login the mobile app$")
    public void login() throws IOException, InterruptedException{
        //logs.info("start login step");
        Login_result = app.login();
        tc_token = Login_result.jsonPath().getString("tcToken");
        //logs.info("token = "+tc_token);

        assertEquals(200,Login_result.statusCode());
        }

    @When("^I tap \"(.*?)\" button$")
    public void AppSendMessage(String service) throws IOException,InterruptedException {
        if (service.equals("remote status")) {
            RVS_result = app.QueryRVS(tc_token);
            assertEquals(200,RVS_result.statusCode());
        }
//        else if (service.equals("door lock")) {
//            DL_result = app.RemoteControl(tc_token);
//            assertEquals(200, DL_result.statusCode());
//        }
        else {
            result = app.RemoteControl(tc_token,service);
            assertEquals(200, result.statusCode());
        }

    }

    @Then("^I can get latest \"(.*?)\" status$")
    public void GetRVS(String service) throws IOException, InterruptedException {
        result = app.QueryRVS(tc_token);

        if (service.equals("remote status")) {
            assertEquals(GlobalValue.VIN,RVS_result.jsonPath().getString("result.vin"));
        }
        else if (service.equals("door lock")) {
            assertEquals(1, result.jsonPath().getInt("vehicleStatus.additionalVehicleStatus.drivingSafetyStatus.doorLockStatusDriver"));
            assertEquals(1, result.jsonPath().getInt("vehicleStatus.additionalVehicleStatus.drivingSafetyStatus.doorLockStatusPassenger"));
            assertEquals(1, result.jsonPath().getInt("vehicleStatus.additionalVehicleStatus.drivingSafetyStatus.doorLockStatusDriverRear"));
            assertEquals(1, result.jsonPath().getInt("vehicleStatus.additionalVehicleStatus.drivingSafetyStatus.doorLockStatusPassengerRear"));
        }
        else if (service.equals("door open")) {
            assertEquals(0, result.jsonPath().getInt("vehicleStatus.additionalVehicleStatus.drivingSafetyStatus.doorLockStatusDriver"));
            assertEquals(0, result.jsonPath().getInt("vehicleStatus.additionalVehicleStatus.drivingSafetyStatus.doorLockStatusPassenger"));
            assertEquals(0, result.jsonPath().getInt("vehicleStatus.additionalVehicleStatus.drivingSafetyStatus.doorLockStatusDriverRear"));
            assertEquals(0, result.jsonPath().getInt("vehicleStatus.additionalVehicleStatus.drivingSafetyStatus.doorLockStatusPassengerRear"));
        }
    }

    @When("^query protocol$")
    public void queryprotocol() throws IOException, InterruptedException {
        db.Qprotocol();
    }

    @When("^update protocol$")
    public void updateprotocol() throws IOException, InterruptedException {
        db.updateprotocol();
    }

    @When("^query cassandra$")
    public void querycass() throws IOException, InterruptedException {
        db.querycass();
    }
}
