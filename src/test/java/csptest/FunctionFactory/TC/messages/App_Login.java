package csptest.FunctionFactory.TC.messages;

public class App_Login {

    private String body;

    public App_Login(String user, String password, String register) {
        super();
        this.body = "{\r\n" +
                "    \"username\":\"" + user + "\",\r\n" +
                "    \"password\":\"" + password + "\",\r\n" +
                "    \"registrationId\":\"" + register + "\",\r\n" +
                "    \"language\":\"zh_CN\",\r\n" +
                "    \"vin\":null,\r\n" +
                "    \"tcToken\":null,\r\n" +
                "    \"platform\":null\r\n" +
                "}";
    }

//    public String getTopic() {
//        return topic;
//    }
//
//    public void setTopic(String topic) {
//        this.topic = topic;
//    }
//
    public String getContent() {
        return body;
    }

    public void setContent(String content) {
        this.body = content;
    }


}
