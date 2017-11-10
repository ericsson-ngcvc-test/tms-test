package csptest.tools;

public interface Env_app {
    //static final String APP_URL = "120.236.175.104:12046";
    //static final String APP_URL = "http://54.223.130.38:8090";  //stage AZ2
    //static final String APP_URL = "http://120.236.175.104:12046";   //EIS external
    static final String APP_URL = "http://172.21.38.23:8080";   //EIS internal

    static final String LOGIN_ADD = "/geelyTCAccess/tcservices/user/login";
    static final String RVS_ADD = "/geelyTCAccess/tcservices/vehicle/status/";
    static final String RC_ADD = "/geelyTCAccess/tcservices/vehicle/telematics/";

}
