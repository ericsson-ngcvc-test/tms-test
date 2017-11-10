package csptest.FunctionFactory.TEM.messages;

public class RVS_bak {

    private String topic;
    private String content;

    public RVS_bak(String vin) {
        super();
        this.topic = "VDC/TEM/RVS";
        String currenttime = String.valueOf(System.currentTimeMillis());

//        this.content = "{\"header\":{\"requestid\":104,\"timeStamp\":1507713135480,\"eventId\":1507713135480,\"creatorId\":0,\"requestType\":0},\"body\":{\"serviceId\":51,\"serviceData\":{\"vehicleStatus\":{\"basicVehicleStatus\":{\"position\":{\"latitude\":133641292,\"longitude\":457530178,\"altitude\":94,\"posCanBeTrusted\":false,\"carLocatorStatUploadEn\":true,\"marsCoordinates\":false},\"speed\":0,\"speedValidity\":0,\"direction\":0,\"engineStatus\":1,\"keyStatus\":0,\"engineBlockedStatus\":0,\"distanceToEmpty\":0},\"additionalVehicleStatus\":{\"drivingSafetyStatus\":{\"srsStatus\":0,\"vehicleAlarm\":0,\"doorOpenStatusDriver\":0,\"doorOpenStatusPassenger\":0,\"doorOpenStatusDriverRear\":0,\"doorOpenStatusPassengerRear\":0,\"doorLockStatusDriver\":0,\"doorLockStatusPassenger\":0,\"doorLockStatusDriverRear\":0,\"doorLockStatusPassengerRear\":0,\"trunkOpenStatus\":0,\"engineHoodOpenStatus\":0,\"seatBeltStatusDriver\":false,\"seatBeltStatusPassenger\":false,\"electricParkBrakeStatus\":0,\"electricParkBrakeStatusValidity\":0},\"maintenanceStatus\":{\"mainBatteryStatus\":{\"stateOfCharge\":0,\"stateOfHealth\":0,\"voltage\":0,\"chargeLevel\":0},\"tyreStatusDriver\":0,\"tyreStatusPassenger\":0,\"tyreStatusDriverRear\":0,\"tyreStatusPassengerRear\":0,\"tyrePreWarningDriver\":0,\"tyrePreWarningPassenger\":0,\"tyrePreWarningDriverRear\":0,\"tyrePreWarningPassengerRear\":0,\"distanceToService\":0,\"serviceWarningStatus\":0,\"odometer\":0},\"runningStatus\":{\"engineOilPressureWarning\":0,\"engineCoolantTemperature\":0,\"engineCoolantTemperatureValidity\":0,\"fuelLevel\":0,\"aveFuelConsumption\":0,\"avgSpeed\":0},\"climateStatus\":{\"winStatusDriver\":0,\"winStatusDriverValidity\":0,\"winStatusPassenger\":0,\"winStatusPassengerValidity\":0,\"winStatusDriverRear\":0,\"winStatusDriverRearValidity\":0,\"winStatusPassengerRear\":0,\"winStatusPassengerRearValidity\":0,\"sunroofOpenStatus\":0,\"sunroofOpenStatusValidity\":0,\"exteriorTemp\":0,\"exteriorTempValidity\":0},\"drivingBehaviourStatus\":{\"brakePedalDepressed\":false,\"brakePedalDepressedValidity\":0,\"engineSpeed\":0,\"engineSpeedValidity\":0,\"transimissionGearPostion\":0,\"cruiseControlStatus\":0},\"pollutionStatus\":{\"interiorPM25\":0,\"exteriorPM25\":0}},\"temStatus\":{\"vin\":\"" + id + "\",\"powerSource\":0,\"backupBattery\":{\"stateOfCharge\":0,\"stateOfHealth\":1,\"voltage\":0,\"chargeLevel\":0},\"powerMode\":0,\"serviceProvisoned\":true,\"healthStatus\":1,\"diagnostics\":{\"ecuID\":\"T-BOX\",\"diagnosticResult\":1,\"dtcs\":[{\"dtc\":\"940113\",\"status\":0},{\"dtc\":\"940211\",\"status\":0},{\"dtc\":\"940331\",\"status\":0},{\"dtc\":\"940413\",\"status\":0},{\"dtc\":\"940A1B\",\"status\":0},{\"dtc\":\"940B11\",\"status\":0},{\"dtc\":\"C01087\",\"status\":0},{\"dtc\":\"C10087\",\"status\":0},{\"dtc\":\"C10187\",\"status\":0},{\"dtc\":\"C11287\",\"status\":0},{\"dtc\":\"C12287\",\"status\":0},{\"dtc\":\"C12687\",\"status\":0},{\"dtc\":\"C13187\",\"status\":0},{\"dtc\":\"C14087\",\"status\":0},{\"dtc\":\"C14687\",\"status\":0},{\"dtc\":\"C15187\",\"status\":0},{\"dtc\":\"C15587\",\"status\":0},{\"dtc\":\"C15987\",\"status\":0},{\"dtc\":\"C16487\",\"status\":0},{\"dtc\":\"C20987\",\"status\":0},{\"dtc\":\"C23587\",\"status\":0},{\"dtc\":\"D11487\",\"status\":0},{\"dtc\":\"D11587\",\"status\":0},{\"dtc\":\"D20387\",\"status\":0}]},\"networkAccessStatus\":{\"simInfo\":{\"msisdn\":\"01049154394\",\"imsi\":\"450050491547358\",\"iccId\":\"8982051609604360864\"},\"mobileNetwork\":\"4G\"},\"completeECUPartNumbers\":\"888067729\",\"imei\":\"356655080052534\",\"hwVersion\":\"HW_REV_1.0\",\"swVersion\":\"NGT_TBOX_190A\"}}}}}\n";
        this.content = "{\r\n" +
                "    \"header\":{\r\n" +
                "        \"requestid\":104,\r\n" +
//                "        \"timeStamp\":1507713135480,\r\n" +
//                "        \"eventId\":1507713135480,\r\n" +
                "        \"timeStamp\":" + System.currentTimeMillis() + ",\r\n" +
                "        \"eventId\":" + System.currentTimeMillis() + ",\r\n" +
                "        \"creatorId\":0,\r\n" +
                "        \"requestType\":0\r\n" +
                "    },\r\n" +
                "    \"body\":{\r\n" +
                "        \"serviceId\":51,\r\n" +
                "        \"serviceData\":{\r\n" +
                "            \"vehicleStatus\":{\r\n" +
                "                \"basicVehicleStatus\":{\r\n" +
                "                    \"position\":{\r\n" +
                "                        \"latitude\":133641292,\r\n" +
                "                        \"longitude\":457530178,\r\n" +
                "                        \"altitude\":94,\r\n" +
                "                        \"posCanBeTrusted\":false,\r\n" +
                "                        \"carLocatorStatUploadEn\":true,\r\n" +
                "                        \"marsCoordinates\":false\r\n" +
                "                    },\r\n" +
                "                    \"speed\":0,\r\n" +
                "                    \"speedValidity\":0,\r\n" +
                "                    \"direction\":0,\r\n" +
                "                    \"engineStatus\":1,\r\n" +
                "                    \"keyStatus\":0,\r\n" +
                "                    \"engineBlockedStatus\":0,\r\n" +
                "                    \"distanceToEmpty\":0\r\n" +
                "                },\r\n" +
                "                \"additionalVehicleStatus\":{\r\n" +
                "                    \"drivingSafetyStatus\":{\r\n" +
                "                        \"srsStatus\":0,\r\n" +
                "                        \"vehicleAlarm\":0,\r\n" +
                "                        \"doorOpenStatusDriver\":0,\r\n" +
                "                        \"doorOpenStatusPassenger\":0,\r\n" +
                "                        \"doorOpenStatusDriverRear\":0,\r\n" +
                "                        \"doorOpenStatusPassengerRear\":0,\r\n" +
                "                        \"doorLockStatusDriver\":0,\r\n" +
                "                        \"doorLockStatusPassenger\":0,\r\n" +
                "                        \"doorLockStatusDriverRear\":0,\r\n" +
                "                        \"doorLockStatusPassengerRear\":0,\r\n" +
                "                        \"trunkOpenStatus\":0,\r\n" +
                "                        \"engineHoodOpenStatus\":0,\r\n" +
                "                        \"seatBeltStatusDriver\":false,\r\n" +
                "                        \"seatBeltStatusPassenger\":false,\r\n" +
                "                        \"electricParkBrakeStatus\":0,\r\n" +
                "                        \"electricParkBrakeStatusValidity\":0\r\n" +
                "                    },\r\n" +
                "                    \"maintenanceStatus\":{\r\n" +
                "                        \"mainBatteryStatus\":{\r\n" +
                "                            \"stateOfCharge\":0,\r\n" +
                "                            \"stateOfHealth\":0,\r\n" +
                "                            \"voltage\":0,\r\n" +
                "                            \"chargeLevel\":0\r\n" +
                "                        },\r\n" +
                "                        \"tyreStatusDriver\":0,\r\n" +
                "                        \"tyreStatusPassenger\":0,\r\n" +
                "                        \"tyreStatusDriverRear\":0,\r\n" +
                "                        \"tyreStatusPassengerRear\":0,\r\n" +
                "                        \"tyrePreWarningDriver\":0,\r\n" +
                "                        \"tyrePreWarningPassenger\":0,\r\n" +
                "                        \"tyrePreWarningDriverRear\":0,\r\n" +
                "                        \"tyrePreWarningPassengerRear\":0,\r\n" +
                "                        \"distanceToService\":0,\r\n" +
                "                        \"serviceWarningStatus\":0,\r\n" +
                "                        \"odometer\":523423\r\n" +
                "                    },\r\n" +
                "                    \"runningStatus\":{\r\n" +
                "                        \"engineOilPressureWarning\":0,\r\n" +
                "                        \"engineCoolantTemperature\":0,\r\n" +
                "                        \"engineCoolantTemperatureValidity\":0,\r\n" +
                "                        \"fuelLevel\":0,\r\n" +
                "                        \"aveFuelConsumption\":0,\r\n" +
                "                        \"avgSpeed\":0\r\n" +
                "                    },\r\n" +
                "                    \"climateStatus\":{\r\n" +
                "                        \"winStatusDriver\":0,\r\n" +
                "                        \"winStatusDriverValidity\":0,\r\n" +
                "                        \"winStatusPassenger\":0,\r\n" +
                "                        \"winStatusPassengerValidity\":0,\r\n" +
                "                        \"winStatusDriverRear\":0,\r\n" +
                "                        \"winStatusDriverRearValidity\":0,\r\n" +
                "                        \"winStatusPassengerRear\":0,\r\n" +
                "                        \"winStatusPassengerRearValidity\":0,\r\n" +
                "                        \"sunroofOpenStatus\":0,\r\n" +
                "                        \"sunroofOpenStatusValidity\":0,\r\n" +
                "                        \"exteriorTemp\":0,\r\n" +
                "                        \"exteriorTempValidity\":0\r\n" +
                "                    },\r\n" +
                "                    \"drivingBehaviourStatus\":{\r\n" +
                "                        \"brakePedalDepressed\":false,\r\n" +
                "                        \"brakePedalDepressedValidity\":0,\r\n" +
                "                        \"engineSpeed\":0,\r\n" +
                "                        \"engineSpeedValidity\":0,\r\n" +
                "                        \"transimissionGearPostion\":0,\r\n" +
                "                        \"cruiseControlStatus\":0\r\n" +
                "                    },\r\n" +
                "                    \"pollutionStatus\":{\r\n" +
                "                        \"interiorPM25\":0,\r\n" +
                "                        \"exteriorPM25\":0\r\n" +
                "                    }\r\n" +
                "                },\r\n" +
                "                \"temStatus\":{\r\n" +
                "                    \"vin\":\"" + vin + "\",\r\n" +
                "                    \"powerSource\":0,\r\n" +
                "                    \"backupBattery\":{\r\n" +
                "                        \"stateOfCharge\":0,\r\n" +
                "                        \"stateOfHealth\":1,\r\n" +
                "                        \"voltage\":0,\r\n" +
                "                        \"chargeLevel\":0\r\n" +
                "                    },\r\n" +
                "                    \"powerMode\":0,\r\n" +
                "                    \"serviceProvisoned\":true,\r\n" +
                "                    \"healthStatus\":1,\r\n" +
                "                    \"diagnostics\":{\r\n" +
                "                        \"ecuID\":\"T-BOX\",\r\n" +
                "                        \"diagnosticResult\":1,\r\n" +
                "                        \"dtcs\":[\r\n" +
                "                            {\r\n" +
                "                                \"dtc\":\"940113\",\r\n" +
                "                                \"status\":0\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"dtc\":\"940211\",\r\n" +
                "                                \"status\":0\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"dtc\":\"940331\",\r\n" +
                "                                \"status\":0\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"dtc\":\"940413\",\r\n" +
                "                                \"status\":0\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"dtc\":\"940A1B\",\r\n" +
                "                                \"status\":0\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"dtc\":\"940B11\",\r\n" +
                "                                \"status\":0\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"dtc\":\"C01087\",\r\n" +
                "                                \"status\":0\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"dtc\":\"C10087\",\r\n" +
                "                                \"status\":0\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"dtc\":\"C10187\",\r\n" +
                "                                \"status\":0\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"dtc\":\"C11287\",\r\n" +
                "                                \"status\":0\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"dtc\":\"C12287\",\r\n" +
                "                                \"status\":0\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"dtc\":\"C12687\",\r\n" +
                "                                \"status\":0\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"dtc\":\"C13187\",\r\n" +
                "                                \"status\":0\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"dtc\":\"C14087\",\r\n" +
                "                                \"status\":0\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"dtc\":\"C14687\",\r\n" +
                "                                \"status\":0\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"dtc\":\"C15187\",\r\n" +
                "                                \"status\":0\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"dtc\":\"C15587\",\r\n" +
                "                                \"status\":0\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"dtc\":\"C15987\",\r\n" +
                "                                \"status\":0\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"dtc\":\"C16487\",\r\n" +
                "                                \"status\":0\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"dtc\":\"C20987\",\r\n" +
                "                                \"status\":0\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"dtc\":\"C23587\",\r\n" +
                "                                \"status\":0\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"dtc\":\"D11487\",\r\n" +
                "                                \"status\":0\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"dtc\":\"D11587\",\r\n" +
                "                                \"status\":0\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"dtc\":\"D20387\",\r\n" +
                "                                \"status\":0\r\n" +
                "                            }\r\n" +
                "                        ]\r\n" +
                "                    },\r\n" +
                "                    \"networkAccessStatus\":{\r\n" +
                "                        \"simInfo\":{\r\n" +
                "                            \"msisdn\":\"01049154394\",\r\n" +
                "                            \"imsi\":\"450050491547358\",\r\n" +
                "                            \"iccId\":\"8982051609604360864\"\r\n" +
                "                        },\r\n" +
                "                        \"mobileNetwork\":\"4G\"\r\n" +
                "                    },\r\n" +
                "                    \"completeECUPartNumbers\":\"888067729\",\r\n" +
                "                    \"imei\":\"356655080052534\",\r\n" +
                "                    \"hwVersion\":\"HW_REV_1.0\",\r\n" +
                "                    \"swVersion\":\"NGT_TBOX_190A\"\r\n" +
                "                }\r\n" +
                "            }\r\n" +
                "        }\r\n" +
                "    }\r\n" +
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
