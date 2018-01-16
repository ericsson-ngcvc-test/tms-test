package tmstest.FunctionFactory.TC.api;

import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.given;

import tmstest.FunctionFactory.TC.messages.*;
import tmstest.FunctionFactory.common.*;
import tmstest.FunctionFactory.common.http.*;
import tmstest.tools.GlobalValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AppBackend {
    static final Logger logs = LoggerFactory.getLogger(AppBackend.class);
    Helper help = new Helper();
    httpapi hapi = new httpapi();

    Response result;
    String userid = GlobalValue.APP_USERID;
    String vin = GlobalValue.VIN;
    String url = help.getConfig("tc","APP_URL");
    String add = "";
    String method = "";

    public Response login() {
        //logs.info("start login");
        String password = GlobalValue.APP_PASSWORD;
        String registrationId = GlobalValue.APP_REGISTER_ID;
        add = help.getConfig("tc","LOGIN_ADD");
        String path = url + add;
        //logs.info("url = "+path);

        App_Login body = new App_Login(userid,password,registrationId);
        String content = body.getContent();
        //logs.info(content);

        result = hapi.tc_send_message("POST",null,path,null,content);
        //result.prettyPrint();
        return result;
    }

    public Response QueryTelematry(String token) throws InterruptedException {
        add = help.getConfig("tc","RVS_ADD");
        String path = url + add + vin;
        String param = "userId=" + userid + "&target=basic,more&latest=False&source=tc";
        //logs.info("url = "+path);

        for (int t=5;t>0;t--){
            System.out.print("wait for RVS "+ t + " seconds\n");
            Thread.sleep(1000);
        }

        result = hapi.tc_send_message("GET",token,path,param,null);
//        result.prettyPrint();
//        logs.info(result.jsonPath().getString("data.vehicleStatus.additionalVehicleStatus.drivingSafetyStatus.doorLockStatusDriver"));
//        logs.info(result.jsonPath().getString("data.vehicleStatus.additionalVehicleStatus.drivingSafetyStatus.doorLockStatusPassenger"));
//        logs.info(result.jsonPath().getString("data.vehicleStatus.additionalVehicleStatus.drivingSafetyStatus.doorLockStatusDriverRear"));
//        logs.info(result.jsonPath().getString("data.vehicleStatus.additionalVehicleStatus.drivingSafetyStatus.doorLockStatusPassengerRear"));

        return result;
    }

    public Response RemoteControl(String token,String service) {
        logs.info("start to " + service);
        add = help.getConfig("tc","RC_ADD");
        String path = url + add + vin;
        String content = "";

        if (service.equals("RDL")){
            App_RDL_RDU body = new App_RDL_RDU("start","RDL",userid);
            content = body.getContent();
//            logs.info(content);
        }
        else if (service.equals("RDU")){
            App_RDL_RDU body = new App_RDL_RDU(null,"RDU",userid);
            content = body.getContent();
//            logs.info(content);
        }

        result = hapi.tc_send_message("PUT",token,path,null,content);
//        result.prettyPrint();

        return result;
    }


    /*
    achieve by httpapi.tc_send_message
     */
//    public Response tc_send_message(String method,String token,String path,String param,Object body) {
//        if (method == "POST"){
//            result = given().header("Content-Type","application/json").
//                    body(body).post(path);
//        }
//        else if(method == "PUT"){
//            result = given().header("Content-Type","application/json").
//                    and().header("tcToken", token).
//                    body(body).put(path);
//        }
//        else if (method == "GET"){
//            result = given().header("Content-Type","application/json").
//                    and().header("tcToken", token).
//                    get(path + "?" + param);
//        }
//        return result;
//    }

}
