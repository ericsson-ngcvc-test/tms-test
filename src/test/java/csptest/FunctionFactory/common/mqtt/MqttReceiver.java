package csptest.FunctionFactory.common.mqtt;

import com.jayway.restassured.path.json.JsonPath;
import csptest.FunctionFactory.common.mqtt.org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import  csptest.FunctionFactory.common.mqtt.org.eclipse.paho.client.mqttv3.MqttMessage;
/**
 * Created by eoorssz on 9/23/2017.
 */


//class MqttReceiver implements IMqttMessageListener {
//
//    public void messageArrived(String topic, MqttMessage message) {
//        System.out.println("MQTT message received: " + message);
//        //if (message.toString().equals("exit")) System.exit(0);
//        //GlobalValue.setMessage(message.toString());
//        if (JsonPath.from( message.toString()).getString("destination.address").equals("test address"))
//            System.exit(0);
//
//    }
//}
