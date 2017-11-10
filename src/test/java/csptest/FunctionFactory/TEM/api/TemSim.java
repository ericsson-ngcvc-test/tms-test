package csptest.FunctionFactory.TEM.api;

import com.alibaba.fastjson.JSONObject;
import com.jayway.restassured.response.Response;
import csptest.FunctionFactory.TEM.messages.*;
import csptest.FunctionFactory.common.Helper;
import csptest.FunctionFactory.common.mqtt.org.eclipse.paho.client.mqttv3.MqttException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import csptest.FunctionFactory.common.mqtt.*;

public class TemSim{
    static final Logger logs = LoggerFactory.getLogger(TemSim.class);

    Helper help = new Helper();
    Response result;
    Response sub_result;

    private String broker_ip = help.getConfig("mqtt","MQTT_BROKER_IP");
    private String str_broker_port = help.getConfig("mqtt","MQTT_BROKER_PORT");
    private int broker_port = Integer.parseInt(str_broker_port);
    private boolean ssl = false;
    private String clinetId = help.getConfig("mqtt","MQTT_CLIENTID");
    private boolean cleanSession = true;

    private String sub_topic = help.getConfig("mqtt","SUB_TOPIC");
    private int qos = 1;
    
    public TemSim() throws MqttException {
    }
    
    MqttClient mqttClient = new MqttClient(broker_ip,broker_port,ssl,clinetId,true,
            false,null,null,
            null,null,null);



    /*
     * remote control responce via mqttclient, no manual here
     */
    public void UplinkMessage() {
//        logs.info("start uplink ...");
//        sub_result = SubsribeMessage();
    }

    public Response SubsribeMessage() {
        logs.info("start subscribe dispather ...");
        logs.info("topic ="+sub_topic);
        try {
//            MqttClient mqttClient = new MqttClient(broker_ip,broker_port,ssl,clinetId,true,
//                    false,null,null,
//                    null,null,null);
            mqttClient.subscribe(sub_topic, qos);
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public void Disconnect() {
        logs.info("start disconnect dispather ...");
        try {
//            MqttClient mqttClient = new MqttClient(broker_ip,broker_port,ssl,clinetId,true,
//                    false,null,null,
//                    null,null,null);
            mqttClient.disconnect();
        }catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void ParasReceivedMessage(String service_id, String message){
        Long eventId = null;
//        logs.info("I get serviceid = " + service_id);
//        logs.info("And I get message = " + message);
        logs.info("start to get eventId");
        JSONObject  myJson = JSONObject.parseObject(message);
        eventId = myJson.getJSONObject("header").getLong("eventId");
        logs.info("serviceid | eventID = " + service_id + " | " + eventId);

        UplinkMessage(service_id,eventId.toString());

    }

    public Response UplinkMessage(String serviceid){
        try {
//            MqttClient mqttClient = new MqttClient(broker_ip,broker_port,ssl,clinetId,true,
//                    false,null,null,
//                    null,null,null);
            logs.info("vehicle start UPLINK " + serviceid);
            String playload = "";

            if (serviceid.equals("RVS")){
                RVS body = new RVS(clinetId);
                playload = body.getContent().toString();
                logs.info("playload : " + playload);
            }
           
            if (playload != null){
                try {
                	mqttClient.publish(serviceid, 1, playload.getBytes());
                } catch (Throwable e) {
                    e.printStackTrace();
                    logs.info("Unable to publish to broker server: " + e.toString());
                }
            }

        }
        catch (Throwable e) {

        }
        return result;
    }

    public void UplinkMessage(String topic, String eventid) {
        try {
//            MqttClient mqttClient = new MqttClient(broker_ip,broker_port,ssl,clinetId,true,
//                    false,null,null,
//                    null,null,null);

            String playload = "";
            String serviceid = topic.toString().substring(4, 7);
            logs.info("vehicle start RESPONSE " + serviceid);

            if (serviceid.equals("RDL")){
                App_RDL_Resp body = new App_RDL_Resp(eventid);
                playload = body.getContent().toString();
                logs.info("playload : " + playload);
            }
            else if (serviceid.equals("RDU")){
                App_RDU_Resp body = new App_RDU_Resp(eventid);
                playload = body.getContent().toString();
                logs.info("playload : " + playload);
            }
            else {
//                playload = null;
            }

            if (playload != null){
                try {
                    mqttClient.publish(serviceid, qos, playload.getBytes());
                } catch (Throwable e) {
                    e.printStackTrace();
                    logs.info("Unable to publish to broker server: " + e.toString());
                }
            }

        }catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
