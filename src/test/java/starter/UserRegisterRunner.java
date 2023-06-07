package starter;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/UserRegister.feature",
dryRun = false,
tags = "@smoke",
glue = "starter.stepdefinitions")
public class UserRegisterRunner {
}
