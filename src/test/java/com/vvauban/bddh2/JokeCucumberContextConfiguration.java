package com.vvauban.bddh2;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest( classes = { JokeTestConfiguration.class } )
@AutoConfigureMockMvc
public class JokeCucumberContextConfiguration {
}
