package csptest.stepDefinitions;

import java.io.IOException;

import com.jayway.restassured.response.Response;
import csptest.FunctionFactory.common.mqtt.org.eclipse.paho.client.mqttv3.MqttException;
import csptest.FunctionFactory.TEM.api.TemSim;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;

public class TEMStep {
    Response result;
    TemSim tem = new TemSim();

    public TEMStep() throws MqttException {
    }

//    @Before
//    public void SubscribeMessage() throws IOException, InterruptedException {
//        result = tem.SubsribeMessage();
//    }

    @When("^Vehicle do \"(.*?)\" operation$")
    public void TemUploadMessage(String service) throws IOException, InterruptedException{
//        if (service.equals("remote status")){
//            result = tem.UplinkMessage("RVS");
//        }
//        else {
//            tem.UplinkMessage();
//        }
    }

//    @After
//    public void Disconnect() throws IOException, InterruptedException {
//        for (int t=20;t>0;t--){
//            System.out.print("preparing to disconnect "+ t + " seconds\n");
//            Thread.sleep(1000);
//        }
////        tem.Disconnect();
//    }
}
