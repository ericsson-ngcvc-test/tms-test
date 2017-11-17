package csptest.FunctionFactory;

import csptest.FunctionFactory.common.Helper;
import csptest.FunctionFactory.common.dbFactory.dbSQL.*;
import csptest.FunctionFactory.common.dbFactory.postgresdbopr;
import csptest.FunctionFactory.common.dbFactory.cassandradbopr;
import csptest.tools.GlobalValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class dbsample {
    static final Logger logs = LoggerFactory.getLogger(dbsample.class);

    postgresdbopr pdb = new postgresdbopr();
    cassandradbopr cdb = new cassandradbopr();
    CSQL csqls = new CSQL();
    Helper help = new Helper();

    String csql;
    String tscdburl = help.getConfig("db","TSC_DB_URL");
    String tscdbuser = help.getConfig("db","TSC_DB_USERNAME");
    String tscdbpwd = help.getConfig("db","TSC_DB_PWD");;

    String cassurl = help.getConfig("db","CASS_IP");
    String cassuser = help.getConfig("db","CASS_USERNAME");
    String casspwd = help.getConfig("db","CASS_PWD");

    public void Qprotocol(){
        String vin = GlobalValue.VIN;
        String result;

        csql = csqls.S_Vstate_by_vin(vin);
//        logs.info("csql = " + csql);
        result = pdb.selectdb(tscdburl,tscdbuser,tscdbpwd, csql);
//        logs.info("result = " + result);

        Map<String, String> myMap = new HashMap<String, String>();
        String[] pairs = result.split(",");
        for (int i=0;i<pairs.length;i++) {
            String pair = pairs[i];
            String[] keyValue = pair.split(":");
            myMap.put(keyValue[0], keyValue[1]);
        }

        String vds_protocol = myMap.get("vds_protocol");
        logs.info("vds_protocol : " + vds_protocol);
    }

    public void updateprotocol() {
//        String vin = GlobalValue.VIN;
        String vin = "DECO20140120DECO1";
        String new_protocol = "VDA";
        boolean issuccess;

        csql = csqls.U_protocol_Vstate(new_protocol,vin);
//        logs.info("csql = " + csql);
        issuccess = pdb.updatedb(tscdburl,tscdbuser,tscdbpwd, csql);
        logs.info("issuccess = " + issuccess);
    }

    public void querycass(){
        String vin = GlobalValue.VIN;
        csql = csqls.S_current_status(vin);
        logs.info("csql = " + csql);
        String current_status = cdb.Selectdb(cassurl,cassuser,casspwd,"m2m",csql);
        logs.info("current_status = " + current_status);

        Map<String, String> myMap = new HashMap<String, String>();
        String[] pairs = current_status.split(",");
        for (int i=0;i<pairs.length;i++) {
            String pair = pairs[i];
            String[] keyValue = pair.split(":");
            if(keyValue!=null && keyValue.length==2){
                myMap.put(keyValue[0], keyValue[1]);
            }else if(keyValue!=null && keyValue.length==1){
                myMap.put(keyValue[0], null);
            }

        }
        String door_lock_driver = myMap.get("doorlockstatusdriver");
        String door_lock_driverrear = myMap.get("doorlockstatusdriverrear");
        String door_lock_passenger = myMap.get("doorlockstatuspassenger");
        String door_lock_passengerrear = myMap.get("doorlockstatuspassengerrear");
        logs.info("door_lock_driver: " + door_lock_driver);
        logs.info("door_lock_driverrear: " + door_lock_driverrear);
        logs.info("door_lock_passenger: " + door_lock_passenger);
        logs.info("door_lock_passengerrear: " + door_lock_passengerrear);

    }



}
