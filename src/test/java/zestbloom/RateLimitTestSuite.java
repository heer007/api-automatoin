package zestbloom;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(strict = true,
        plugin = {"pretty"},
        features = {"src/test/resources/features/zestbloom/rate-limit"},
        glue = {"zestbloom.stepDefinitions"}
)
public class RateLimitTestSuite {}
