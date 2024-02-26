package TestRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-report.html"},monochrome = true,features="Features",glue={"StepDefinition"})						
 
public class Runner {
 
}