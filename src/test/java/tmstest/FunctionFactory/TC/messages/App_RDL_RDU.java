package tmstest.FunctionFactory.TC.messages;


public class App_RDL_RDU {

    private String body;
    public App_RDL_RDU(String command, String serviceId, String userid) {
        super();
        this.body = "{\n" +
                "    \"command\":\"" + command + "\",\n" +
                "    \"creator\":\"tc\",\n" +
                "    \"operationScheduling\":{\n" +
                "        \"duration\":0,\n" +
                "        \"interval\":0,\n" +
                "        \"occurs\":1,\n" +
                "        \"recurrentOperation\":false\n" +
                "    },\n" +
                "    \"pin\":\"\",\n" +
                "    \"serviceId\":\"" + serviceId + "\",\n" +
                "    \"serviceParameters\":[],\n" +
                "    \"sessionId\":\"\",\n" +
                "    \"timestamp\":\"1512529357937\",\n" +
                "    \"userId\":\"" + userid + "\"\n" +
                "}";
    }

    public String getContent() {
        return body;
    }

    public void setContent(String content) {
        this.body = content;
    }

}
