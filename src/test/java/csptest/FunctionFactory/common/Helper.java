package csptest.FunctionFactory.common;

import csptest.tools.GlobalValue;
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;


public class Helper {

    public String ccBase64(String src,boolean enc) {
        String codeedStr = "";
        try {
            if (enc = true) {
                //encode
                byte[] encodeBytes = Base64.encodeBase64(src.getBytes(GlobalValue.DEFAULT_ENCODING));
                codeedStr = new String(encodeBytes, GlobalValue.DEFAULT_ENCODING);
                //System.out.println("CC BASE64 encoder: " + codeedStr);
            }
            else {
                //decode
                byte[] decodeBytes = Base64.decodeBase64(src.getBytes(GlobalValue.DEFAULT_ENCODING));
                codeedStr = new String(decodeBytes, GlobalValue.DEFAULT_ENCODING);
                //System.out.println("CC BASE64 decoder: " + codeedStr);
            }
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return codeedStr;
    }

    public static String getConfig(String module, String key)
    {
        String path = "";
        if(module == "tc"){
            path = "src/test/resources/Configs/tc.properties";     //test
            //path = "test-classes/Configs/tc.properties";         //prod
        }
        else if (module == "tmp"){
            path = "src/test/resources/Configs/tmp.properties";      //test
            //path = "test-classes/Configs/tmp.properties";         //prod
        }
        else if (module == "mqtt"){
            path = "src/test/resources/Configs/mqtt.properties";      //test
            //path = "test-classes/Configs/mqtt.properties";         //prod
        }
        else if (module == "tem"){
            path = "src/test/resources/Configs/tem.properties";      //test
            //path = "test-classes/Configs/tem.properties";         //prod
        }
        else if (module == "db"){
            path = "src/test/resources/Configs/db.properties";      //test
            //path = "test-classes/Configs/mqtt.properties";         //prod
        }

        PropertyFileReader property = new PropertyFileReader(path);
        property.load();
        String value = property.getData(key);
        return value;
    }

}
