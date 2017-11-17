package csptest.FunctionFactory.TEM.messages;

public class TEM_BODY {

    private String topic;
    private String content;

    public TEM_BODY(String clientid,String playload,String serviceid) {
        super();
        String currenttime = String.valueOf(System.currentTimeMillis());

//        this.content = "{\"header\":{\"requestid\":104,\"timeStamp\":1507713135480,\"eventId\":1507713135480,\"creatorId\":0,\"requestType\":0},\"body\":{\"serviceId\":51,\"serviceData\":{\"vehicleStatus\":{\"basicVehicleStatus\":{\"position\":{\"latitude\":133641292,\"longitude\":457530178,\"altitude\":94,\"posCanBeTrusted\":false,\"carLocatorStatUploadEn\":true,\"marsCoordinates\":false},\"speed\":0,\"speedValidity\":0,\"direction\":0,\"engineStatus\":1,\"keyStatus\":0,\"engineBlockedStatus\":0,\"distanceToEmpty\":0},\"additionalVehicleStatus\":{\"drivingSafetyStatus\":{\"srsStatus\":0,\"vehicleAlarm\":0,\"doorOpenStatusDriver\":0,\"doorOpenStatusPassenger\":0,\"doorOpenStatusDriverRear\":0,\"doorOpenStatusPassengerRear\":0,\"doorLockStatusDriver\":0,\"doorLockStatusPassenger\":0,\"doorLockStatusDriverRear\":0,\"doorLockStatusPassengerRear\":0,\"trunkOpenStatus\":0,\"engineHoodOpenStatus\":0,\"seatBeltStatusDriver\":false,\"seatBeltStatusPassenger\":false,\"electricParkBrakeStatus\":0,\"electricParkBrakeStatusValidity\":0},\"maintenanceStatus\":{\"mainBatteryStatus\":{\"stateOfCharge\":0,\"stateOfHealth\":0,\"voltage\":0,\"chargeLevel\":0},\"tyreStatusDriver\":0,\"tyreStatusPassenger\":0,\"tyreStatusDriverRear\":0,\"tyreStatusPassengerRear\":0,\"tyrePreWarningDriver\":0,\"tyrePreWarningPassenger\":0,\"tyrePreWarningDriverRear\":0,\"tyrePreWarningPassengerRear\":0,\"distanceToService\":0,\"serviceWarningStatus\":0,\"odometer\":0},\"runningStatus\":{\"engineOilPressureWarning\":0,\"engineCoolantTemperature\":0,\"engineCoolantTemperatureValidity\":0,\"fuelLevel\":0,\"aveFuelConsumption\":0,\"avgSpeed\":0},\"climateStatus\":{\"winStatusDriver\":0,\"winStatusDriverValidity\":0,\"winStatusPassenger\":0,\"winStatusPassengerValidity\":0,\"winStatusDriverRear\":0,\"winStatusDriverRearValidity\":0,\"winStatusPassengerRear\":0,\"winStatusPassengerRearValidity\":0,\"sunroofOpenStatus\":0,\"sunroofOpenStatusValidity\":0,\"exteriorTemp\":0,\"exteriorTempValidity\":0},\"drivingBehaviourStatus\":{\"brakePedalDepressed\":false,\"brakePedalDepressedValidity\":0,\"engineSpeed\":0,\"engineSpeedValidity\":0,\"transimissionGearPostion\":0,\"cruiseControlStatus\":0},\"pollutionStatus\":{\"interiorPM25\":0,\"exteriorPM25\":0}},\"temStatus\":{\"vin\":\"" + id + "\",\"powerSource\":0,\"backupBattery\":{\"stateOfCharge\":0,\"stateOfHealth\":1,\"voltage\":0,\"chargeLevel\":0},\"powerMode\":0,\"serviceProvisoned\":true,\"healthStatus\":1,\"diagnostics\":{\"ecuID\":\"T-BOX\",\"diagnosticResult\":1,\"dtcs\":[{\"dtc\":\"940113\",\"status\":0},{\"dtc\":\"940211\",\"status\":0},{\"dtc\":\"940331\",\"status\":0},{\"dtc\":\"940413\",\"status\":0},{\"dtc\":\"940A1B\",\"status\":0},{\"dtc\":\"940B11\",\"status\":0},{\"dtc\":\"C01087\",\"status\":0},{\"dtc\":\"C10087\",\"status\":0},{\"dtc\":\"C10187\",\"status\":0},{\"dtc\":\"C11287\",\"status\":0},{\"dtc\":\"C12287\",\"status\":0},{\"dtc\":\"C12687\",\"status\":0},{\"dtc\":\"C13187\",\"status\":0},{\"dtc\":\"C14087\",\"status\":0},{\"dtc\":\"C14687\",\"status\":0},{\"dtc\":\"C15187\",\"status\":0},{\"dtc\":\"C15587\",\"status\":0},{\"dtc\":\"C15987\",\"status\":0},{\"dtc\":\"C16487\",\"status\":0},{\"dtc\":\"C20987\",\"status\":0},{\"dtc\":\"C23587\",\"status\":0},{\"dtc\":\"D11487\",\"status\":0},{\"dtc\":\"D11587\",\"status\":0},{\"dtc\":\"D20387\",\"status\":0}]},\"networkAccessStatus\":{\"simInfo\":{\"msisdn\":\"01049154394\",\"imsi\":\"450050491547358\",\"iccId\":\"8982051609604360864\"},\"mobileNetwork\":\"4G\"},\"completeECUPartNumbers\":\"888067729\",\"imei\":\"356655080052534\",\"hwVersion\":\"HW_REV_1.0\",\"swVersion\":\"NGT_TBOX_190A\"}}}}}\n";
        this.content = "clientid=" + clientid +
                "&payload=" + playload +
                "&serviceid=" + serviceid;
    }


//    public Message() {
//        super();
//        this.topic = "VDA/TEM/RVS";
//        this.content = "{\"dataset\":[{\"device\":{\"event\":{\"theft\":{\"context\":{\"motion\":{\"moving\":1,\"speed\":98}},\"description\":\"Towaway In Event\",\"name\":\"Towaway In Event\",\"position\":{\"altitude\":1,\"date\":1,\"direction\":1,\"fixed\":true,\"hdop\":1,\"isMarsCoordinates\":true,\"latitude\":8.3243988E7,\"longitude\":4.08114108E8,\"nbSatellites\":1,\"speed\":1},\"tag\":\"towAway\",\"timestamp\":1506477764729,\"uuid\":\"12403187-6684-0616-5588462704373552\"}},\"id\":\"VIN1234567DEMO001\",\"profile\":{\"configuration\":{\"architecture\":1}},\"timestamp\":1506477764729}}]}";
//    }
//
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }


}
