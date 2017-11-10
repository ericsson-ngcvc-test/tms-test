package csptest.FunctionFactory.common.dbFactory.dbSQL;

//S = select
//U = update
//D = delete
//I = insert

public class CSQL {
    private String csql;

    public String S_Vstate_by_vin(String vin) {
        csql = "select \n" +
                "vin,active_state,inhibition_state,immobilization_state,svt_state,svt_start_time,svt_end_time,journal_log_state,engine_state,power_mode,power_next_wakeup_time,maintenance_state,advanced_remote_control_state,position_upload_state,vds_protocol,certificate \n" +
                "from tsc_vehicle_state \n" +
                "where \n" +
                "vin = '" + vin + "';";
        return csql;
    }

    public String U_protocol_Vstate(String newp,String vin) {
        csql = "update tsc_vehicle_state\n" +
                "set vds_protocol = '" + newp + "'\n" +
                "where \n" +
                "vin = '" + vin + "';";
        return csql;
    }

    public String S_current_status(String vin) {
        csql = "select * \n" +
                "from current_status \n" +
                "where \n" +
                "vin = '" + vin + "';";
        return csql;
    }
}
