package csptest.tools;

public interface Env_mqtt {
    //mqtt
//    static final String MQTT_BROKER       =  (System.getenv("MQTT_BROKER") !=null) ? System.getenv("MQTT_BROKER") : "tcp://localhost:1883";
//    static final String MQTT_CLIENTID     = "e2eTest_" + System.currentTimeMillis();
//    static final String MQTT_USERNAME     = (System.getenv("MQTT_USERNAME") !=null) ? System.getenv("MQTT_USERNAME") :  "E2ETestUser";
//    static final String MQTT_PASSWORD     = (System.getenv("MQTT_PASSWORD") !=null) ? System.getenv("MQTT_PASSWORD") : "passw0rd";

    //static final String MQTT_BROKER       =  "tcp://54.222.210.232:1883"; //stage
    static final String MQTT_BROKER       = "tcp://172.21.38.18:1883"; //eis

    static final String MQTT_CLIENTID     = "DECO20140120DECO2";
    static final String MQTT_USERNAME     = "E2ETestUser";
    static final String MQTT_PASSWORD     = "passw0rd";

    static final String RVS_TOPIC = "VDC/TEM/RVS";

    public void function();
}
