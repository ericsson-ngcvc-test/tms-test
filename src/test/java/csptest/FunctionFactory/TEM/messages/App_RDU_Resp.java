package csptest.FunctionFactory.TEM.messages;


public class App_RDU_Resp {

    private String body;

    public App_RDU_Resp(String eventId) {

        super();
        this.body = "{\n" +
                "    \"header\":{\n" +
                "        \"requestid\":0,\n" +
                "        \"timeStamp\":1452239844543,\n" +
                "        \"eventId\":" + eventId + "\r\n" +
                "    },\n" +
                "    \"body\":{\n" +
                "        \"serviceData\":{\n" +
                "            \"serviceResult\":{\n" +
                "                \"operationSucceeded\":true\n" +
                "            },\n" +
                "            \"vehicleStatus\":{\n" +
                "                \"additionalVehicleStatus\":{\n" +
                "                    \"drivingSafetyStatus\":{\n" +
//                "                        \"srsStatus\":\"SRS_DEPLOYED\",\n" +
                "                        \"vehicleAlarm\":1,\n" +
                "                        \"doorOpenStatusDriver\":0,\n" +
                "                        \"doorOpenStatusPassenger\":0,\n" +
                "                        \"doorOpenStatusDriverRear\":0,\n" +
                "                        \"doorOpenStatusPassengerRear\":0,\n" +
                "                        \"doorLockStatusDriver\":0,\n" +
                "                        \"doorLockStatusPassenger\":0,\n" +
                "                        \"doorLockStatusDriverRear\":0,\n" +
                "                        \"doorLockStatusPassengerRear\":1\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
    }

    public String getContent() {
        return body;
    }

    public void setContent(String content) {
        this.body = content;
    }


}
