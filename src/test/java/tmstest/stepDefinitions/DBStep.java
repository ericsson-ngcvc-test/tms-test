package tmstest.stepDefinitions;

import tmstest.FunctionFactory.dbsample;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DBStep {
    static final Logger logs = LoggerFactory.getLogger(DBStep.class);

    dbsample db = new dbsample();

    /**
     * fake step
     */
    @When("^query protocol$")
    public void queryprotocol() throws IOException, InterruptedException {
        db.Qprotocol();
    }

    /**
     * fake step
     */
    @When("^update protocol$")
    public void updateprotocol() throws IOException, InterruptedException {
        db.updateprotocol();
    }

    /**
     * fake step
     */
    @When("^query cassandra$")
    public void querycass() throws IOException, InterruptedException {
        db.querycass();
    }
}
