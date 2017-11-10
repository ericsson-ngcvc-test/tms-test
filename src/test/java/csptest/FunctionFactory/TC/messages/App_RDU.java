package csptest.FunctionFactory.TC.messages;


public class App_RDU {

    private String body;

    public App_RDU(String userid) {

        super();
        this.body = "{\n" +
                "    \"userId\":\"" + userid + "\",\n" +
                "    \"serviceId\":\"RDU\",\n" +
                "    \"timestamp\":\"" + System.currentTimeMillis() + "\",\n" +
                "    \"creator\":\"tc\",\n" +
                "    \"command\":null,\n" +
                "    \"latest\":false,\n" +
                "    \"pin\":null,\n" +
                "    \"sessionId\":null,\n" +
                "    \"operationScheduling\":{\n" +
                "        \"scheduledTime\":null,\n" +
                "        \"recurrentOperation\":false,\n" +
                "        \"duration\":0,\n" +
                "        \"interval\":0,\n" +
                "        \"occurs\":0,\n" +
                "        \"endTime\":null\n" +
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
