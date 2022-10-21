package com.vvauban.bddh2;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith( Cucumber.class )
@CucumberOptions( glue = "com.vvauban.bddh2",
                  features = "src/test/resources",
                  plugin = "pretty" )
public class CucumberIntegrationTest {
}
