package runnerclass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features/demo1.feature",
        glue ="Stepdefinition",
        plugin = "html:reports/datepicker.html",
        monochrome = true





)
public class runner {

}
