package tmstest.FunctionFactory.common.http;

import com.jayway.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.jayway.restassured.RestAssured.given;

public class httpapi {
    static final Logger logs = LoggerFactory.getLogger(httpapi.class);
    Response result;

    public Response tc_send_message(String method, String token, String path, String param, Object body) {
        if (method == "POST"){
            result = given().header("Content-Type","application/json").
                    body(body).post(path);
        }
        else if(method == "PUT"){
            result = given().header("Content-Type","application/json").
                    and().header("tcToken", token).
                    body(body).put(path);
        }
        else if (method == "GET"){
            result = given().header("Content-Type","application/json").
                    and().header("tcToken", token).
                    get(path + "?" + param);
        }
        return result;
    }

    public Response tem_send_message(String path, Object body){
        result = given().header("ContentType","application/json").
                and().header("Connection","keep-alive").
                body(body).post(path);

        return result;
    }
}
