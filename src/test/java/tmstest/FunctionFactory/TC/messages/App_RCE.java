package tmstest.FunctionFactory.TC.messages;

public class App_RCE {

    private String body;

    public App_RCE(String userid, String command) {

        if ( command.equalsIgnoreCase("start")){
            command="start";
        }else if ( command.equalsIgnoreCase("stop")){
            command="stop";
        }else{
            System.out.print("[ERROR] invaild parameter.command only should be \"start\" or \"stop");
        }

        this.body = "{\n" +
                "  \"userId\": \"" + userid + "\",\n" +
                "  \"serviceId\": \"RCE\",\n" +
                "  \"timestamp\": " + System.currentTimeMillis() + ",\n" +
                "  \"creator\": \"tc\",\n" +
                "  \"command\": \"" + command + "\",\n" +
                "  \"latest\": false,\n" +
                "  \"serviceParameters\": [\n" +
                "    {\n" +
                "      \"key\": \"rce\",\n" +
                "      \"value\": \"15\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"operationScheduling\": {\n" +
                "    \"scheduledTime\": null,\n" +
                "    \"recurrentOperation\": false,\n" +
                "    \"duration\": 0,\n" +
                "    \"interval\": 0,\n" +
                "    \"occurs\": 0,\n" +
                "    \"endTime\": null\n" +
                "  },\n" +
                "  \"sessionId\": null,\n" +
                "  \"pin\": null\n" +
                "}";
    }

    public String getContent() {
        return body;
    }

    public void setContent(String content) {
        this.body = content;
    }


}
