package csptest.FunctionFactory.common.mqtt;

import  csptest.FunctionFactory.common.mqtt.org.eclipse.paho.client.mqttv3.MqttClient;
import csptest.FunctionFactory.common.mqtt.org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import csptest.FunctionFactory.common.mqtt.org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import csptest.FunctionFactory.common.*;

/**
 * Created by eoorssz on 9/20/2017.
 */
public class MqttSender {
    static final Logger logger = LoggerFactory.getLogger(MqttSender.class);
    Helper help = new Helper();

    private String broker;
    private String clientId;
    private String username;
    private String password;

    public MqttSender() {
        super();
        this.broker = help.getConfig("mqtt","MQTT_BROKER");
        this.clientId = help.getConfig("mqtt","MQTT_CLIENTID");
//        this.username = Environment.MQTT_USERNAME;
//        this.password = Environment.MQTT_PASSWORD;

    }

    public void mqttSendMessage(Object mes) {
        if (mes != null) {

            try {
                MqttConnectOptions connOpts = new MqttConnectOptions();
                connOpts.setUserName(username);
                connOpts.setPassword(password.toCharArray());

                System.out.println("Connecting to broker: " + broker);
                MqttClient mqttClient = new MqttClient(broker, clientId);
                mqttClient.connect(connOpts);
                System.out.println("Connected. Client id is " + clientId);

                // mqttClient.subscribe(topic, new MqttReceiver());
                // System.out.println("Subscribed to topic: " + topic);

//                MqttMessage message = new MqttMessage(mes.getContent().getBytes());
//                mqttClient.publish(mes.getTopic(), message);
//                System.out.println("Published Topic: " + mes.getTopic());
//                System.out.println("Published Message: " + mes.getContent());


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
