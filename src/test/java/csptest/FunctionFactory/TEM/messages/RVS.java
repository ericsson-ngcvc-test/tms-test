package csptest.FunctionFactory.TEM.messages;

public class RVS {

    private String topic;
    private String content;

    public RVS(String vin) {
        super();
        this.topic = "VDC/TEM/RVS";
        String currenttime = String.valueOf(System.currentTimeMillis());

//        this.content = "{\"header\":{\"requestid\":104,\"timeStamp\":1507713135480,\"eventId\":1507713135480,\"creatorId\":0,\"requestType\":0},\"body\":{\"serviceId\":51,\"serviceData\":{\"vehicleStatus\":{\"basicVehicleStatus\":{\"position\":{\"latitude\":133641292,\"longitude\":457530178,\"altitude\":94,\"posCanBeTrusted\":false,\"carLocatorStatUploadEn\":true,\"marsCoordinates\":false},\"speed\":0,\"speedValidity\":0,\"direction\":0,\"engineStatus\":1,\"keyStatus\":0,\"engineBlockedStatus\":0,\"distanceToEmpty\":0},\"additionalVehicleStatus\":{\"drivingSafetyStatus\":{\"srsStatus\":0,\"vehicleAlarm\":0,\"doorOpenStatusDriver\":0,\"doorOpenStatusPassenger\":0,\"doorOpenStatusDriverRear\":0,\"doorOpenStatusPassengerRear\":0,\"doorLockStatusDriver\":0,\"doorLockStatusPassenger\":0,\"doorLockStatusDriverRear\":0,\"doorLockStatusPassengerRear\":0,\"trunkOpenStatus\":0,\"engineHoodOpenStatus\":0,\"seatBeltStatusDriver\":false,\"seatBeltStatusPassenger\":false,\"electricParkBrakeStatus\":0,\"electricParkBrakeStatusValidity\":0},\"maintenanceStatus\":{\"mainBatteryStatus\":{\"stateOfCharge\":0,\"stateOfHealth\":0,\"voltage\":0,\"chargeLevel\":0},\"tyreStatusDriver\":0,\"tyreStatusPassenger\":0,\"tyreStatusDriverRear\":0,\"tyreStatusPassengerRear\":0,\"tyrePreWarningDriver\":0,\"tyrePreWarningPassenger\":0,\"tyrePreWarningDriverRear\":0,\"tyrePreWarningPassengerRear\":0,\"distanceToService\":0,\"serviceWarningStatus\":0,\"odometer\":0},\"runningStatus\":{\"engineOilPressureWarning\":0,\"engineCoolantTemperature\":0,\"engineCoolantTemperatureValidity\":0,\"fuelLevel\":0,\"aveFuelConsumption\":0,\"avgSpeed\":0},\"climateStatus\":{\"winStatusDriver\":0,\"winStatusDriverValidity\":0,\"winStatusPassenger\":0,\"winStatusPassengerValidity\":0,\"winStatusDriverRear\":0,\"winStatusDriverRearValidity\":0,\"winStatusPassengerRear\":0,\"winStatusPassengerRearValidity\":0,\"sunroofOpenStatus\":0,\"sunroofOpenStatusValidity\":0,\"exteriorTemp\":0,\"exteriorTempValidity\":0},\"drivingBehaviourStatus\":{\"brakePedalDepressed\":false,\"brakePedalDepressedValidity\":0,\"engineSpeed\":0,\"engineSpeedValidity\":0,\"transimissionGearPostion\":0,\"cruiseControlStatus\":0},\"pollutionStatus\":{\"interiorPM25\":0,\"exteriorPM25\":0}},\"temStatus\":{\"vin\":\"" + id + "\",\"powerSource\":0,\"backupBattery\":{\"stateOfCharge\":0,\"stateOfHealth\":1,\"voltage\":0,\"chargeLevel\":0},\"powerMode\":0,\"serviceProvisoned\":true,\"healthStatus\":1,\"diagnostics\":{\"ecuID\":\"T-BOX\",\"diagnosticResult\":1,\"dtcs\":[{\"dtc\":\"940113\",\"status\":0},{\"dtc\":\"940211\",\"status\":0},{\"dtc\":\"940331\",\"status\":0},{\"dtc\":\"940413\",\"status\":0},{\"dtc\":\"940A1B\",\"status\":0},{\"dtc\":\"940B11\",\"status\":0},{\"dtc\":\"C01087\",\"status\":0},{\"dtc\":\"C10087\",\"status\":0},{\"dtc\":\"C10187\",\"status\":0},{\"dtc\":\"C11287\",\"status\":0},{\"dtc\":\"C12287\",\"status\":0},{\"dtc\":\"C12687\",\"status\":0},{\"dtc\":\"C13187\",\"status\":0},{\"dtc\":\"C14087\",\"status\":0},{\"dtc\":\"C14687\",\"status\":0},{\"dtc\":\"C15187\",\"status\":0},{\"dtc\":\"C15587\",\"status\":0},{\"dtc\":\"C15987\",\"status\":0},{\"dtc\":\"C16487\",\"status\":0},{\"dtc\":\"C20987\",\"status\":0},{\"dtc\":\"C23587\",\"status\":0},{\"dtc\":\"D11487\",\"status\":0},{\"dtc\":\"D11587\",\"status\":0},{\"dtc\":\"D20387\",\"status\":0}]},\"networkAccessStatus\":{\"simInfo\":{\"msisdn\":\"01049154394\",\"imsi\":\"450050491547358\",\"iccId\":\"8982051609604360864\"},\"mobileNetwork\":\"4G\"},\"completeECUPartNumbers\":\"888067729\",\"imei\":\"356655080052534\",\"hwVersion\":\"HW_REV_1.0\",\"swVersion\":\"NGT_TBOX_190A\"}}}}}\n";
        this.content = "{\n" +
                "    \"header\":{\n" +
                "        \"requestid\":91,\n" +
                "        \"timeStamp\":" + System.currentTimeMillis() + ",\r\n" +
                "        \"eventId\":" + System.currentTimeMillis() + ",\r\n" +
                "        \"creatorId\":0,\n" +
                "        \"messageTTL\":720,\n" +
                "        \"requestType\":0\n" +
                "    },\n" +
                "    \"body\":{\n" +
                "        \"serviceId\":51,\n" +
                "        \"serviceData\":{\n" +
                "            \"vehicleStatus\":{\n" +
                "                \"basicVehicleStatus\":{\n" +
                "                    \"position\":{\n" +
                "                        \"latitude\":109227106,\n" +
                "                        \"longitude\":436474166,\n" +
                "                        \"altitude\":2,\n" +
                "                        \"posCanBeTrusted\":true,\n" +
                "                        \"carLocatorStatUploadEn\":true,\n" +
                "                        \"marsCoordinates\":false\n" +
                "                    },\n" +
                "                    \"speed\":0,\n" +
                "                    \"speedValidity\":0,\n" +
                "                    \"direction\":0,\n" +
                "                    \"engineStatus\":1,\n" +
                "                    \"engineBlockedStatus\":0\n" +
                "                },\n" +
                "                \"additionalVehicleStatus\":{\n" +
                "                    \"drivingSafetyStatus\":{\n" +
                "                        \"vehicleAlarm\":2,\n" +
                "                        \"doorOpenStatusDriver\":0,\n" +
                "                        \"doorOpenStatusPassenger\":0,\n" +
                "                        \"doorOpenStatusDriverRear\":0,\n" +
                "                        \"doorOpenStatusPassengerRear\":0,\n" +
                "                        \"doorLockStatusDriver\":1,\n" +
                "                        \"doorLockStatusPassenger\":0,\n" +
                "                        \"doorLockStatusDriverRear\":1,\n" +
                "                        \"doorLockStatusPassengerRear\":0,\n" +
                "                        \"trunkOpenStatus\":0,\n" +
                "                        \"engineHoodOpenStatus\":0,\n" +
                "                        \"seatBeltStatusDriver\":true,\n" +
                "                        \"seatBeltStatusPassenger\":true,\n" +
                "                        \"handBrakeStatus\":1,\n" +
                "                        \"electricParkBrakeStatus\":1\n" +
                "                    },\n" +
                "                    \"maintenanceStatus\":{\n" +
                "                        \"mainBatteryStatus\":{\n" +
                "                            \"voltage\":122\n" +
                "                        },\n" +
                "                        \"tyreStatusDriver\":168,\n" +
                "                        \"tyreStatusPassenger\":126,\n" +
                "                        \"tyreStatusDriverRear\":121,\n" +
                "                        \"tyreStatusPassengerRear\":144,\n" +
                "                        \"tyrePreWarningDriver\":0,\n" +
                "                        \"tyrePreWarningPassenger\":2,\n" +
                "                        \"tyrePreWarningDriverRear\":2,\n" +
                "                        \"tyrePreWarningPassengerRear\":0,\n" +
                "                        \"serviceWarningStatus\":0,\n" +
                "                        \"odometer\":40061\n" +
                "                    },\n" +
                "                    \"runningStatus\":{\n" +
                "                        \"engineOilPressureWarning\":0,\n" +
                "                        \"engineCoolantTemperature\":183,\n" +
                "                        \"engineCoolantTemperatureValidity\":0,\n" +
                "                        \"fuelLevel\":97,\n" +
                "                        \"avgSpeed\":0\n" +
                "                    },\n" +
                "                    \"climateStatus\":{\n" +
                "                        \"winStatusDriver\":0,\n" +
                "                        \"winStatusDriverValidity\":1,\n" +
                "                        \"winStatusPassenger\":0,\n" +
                "                        \"winStatusPassengerValidity\":1,\n" +
                "                        \"winStatusDriverRear\":0,\n" +
                "                        \"winStatusDriverRearValidity\":1,\n" +
                "                        \"winStatusPassengerRear\":0,\n" +
                "                        \"winStatusPassengerRearValidity\":0,\n" +
                "                        \"sunroofOpenStatus\":0,\n" +
                "                        \"sunroofOpenStatusValidity\":0,\n" +
                "                        \"exteriorTemp\":140,\n" +
                "                        \"exteriorTempValidity\":0\n" +
                "                    },\n" +
                "                    \"drivingBehaviourStatus\":{\n" +
                "                        \"brakePedalDepressedValidity\":1,\n" +
                "                        \"engineSpeed\":0,\n" +
                "                        \"engineSpeedValidity\":0,\n" +
                "                        \"transimissionGearPostion\":1,\n" +
                "                        \"cruiseControlStatus\":0\n" +
                "                    },\n" +
                "                    \"pollutionStatus\":{\n" +
                "                        \"interiorPM25\":25,\n" +
                "                        \"exteriorPM25\":12\n" +
                "                    }\n" +
                "                },\n" +
                "                \"temStatus\":{\n" +
                "                    \"vin\":\"" + vin + "\",\r\n" +
                "                    \"powerSource\":0,\n" +
                "                    \"backupBattery\":{\n" +
                "                        \"stateOfCharge\":1,\n" +
                "                        \"stateOfHealth\":0,\n" +
                "                        \"voltage\":40\n" +
                "                    },\n" +
                "                    \"powerMode\":0,\n" +
                "                    \"serviceProvisoned\":true,\n" +
                "                    \"healthStatus\":0,\n" +
                "                    \"diagnostics\":{\n" +
                "                        \"ecuID\":\"1\",\n" +
                "                        \"diagnosticResult\":1,\n" +
                "                        \"dtcs\":[\n" +
                "                            {\n" +
                "                                \"dtc\":\"6C13187\",\n" +
                "                                \"status\":3,\n" +
                "                                \"failureCount\":1,\n" +
                "                                \"firstFailureOdometer\":4005,\n" +
                "                                \"firstFailureBatteryVoltage\":140,\n" +
                "                                \"firstFailureVehicleSpeed\":0\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"dtc\":\"7940213\",\n" +
                "                                \"status\":1,\n" +
                "                                \"failureCount\":1,\n" +
                "                                \"firstFailureOdometer\":4005,\n" +
                "                                \"firstFailureBatteryVoltage\":119,\n" +
                "                                \"firstFailureVehicleSpeed\":0\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"dtc\":\"7940331\",\n" +
                "                                \"status\":1,\n" +
                "                                \"failureCount\":19,\n" +
                "                                \"firstFailureOdometer\":4005,\n" +
                "                                \"firstFailureBatteryVoltage\":141,\n" +
                "                                \"firstFailureVehicleSpeed\":0\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"dtc\":\"4F00616\",\n" +
                "                                \"status\":3,\n" +
                "                                \"failureCount\":2,\n" +
                "                                \"firstFailureOdometer\":4006,\n" +
                "                                \"firstFailureBatteryVoltage\":90,\n" +
                "                                \"firstFailureVehicleSpeed\":0\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"dtc\":\"7940D13\",\n" +
                "                                \"status\":1,\n" +
                "                                \"failureCount\":1,\n" +
                "                                \"firstFailureOdometer\":4005,\n" +
                "                                \"firstFailureBatteryVoltage\":119,\n" +
                "                                \"firstFailureVehicleSpeed\":0\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    \"networkAccessStatus\":{\n" +
                "                        \"simInfo\":{\n" +
                "                            \"msisdn\":\"18496518612\",\n" +
                "                            \"imsi\":\"460024965108612\",\n" +
                "                            \"iccId\":\"898602C9991630028612\"\n" +
                "                        },\n" +
                "                        \"mobileNetwork\":\"4G\"\n" +
                "                    },\n" +
                "                    \"serialNumber\":\"5710976606736989H8Z00005\",\n" +
                "                    \"imei\":\"864685030024700\",\n" +
                "                    \"hwVersion\":\"VF112H1Q131 \",\n" +
                "                    \"swVersion\":\"JL_CN_VF11Y1000FV1.0.0B02\",\n" +
                "                    \"mpuVersion\":\"VF1122_V1.1C.2\",\n" +
                "                    \"mcuVersion\":\"VF1121_V1.1C.2\"\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        \"seq\":0\n" +
                "    }\n" +
                "}";

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
