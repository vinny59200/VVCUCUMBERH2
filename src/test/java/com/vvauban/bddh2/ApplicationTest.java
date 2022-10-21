package com.vvauban.bddh2;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest( classes = { DummyConfig.class } )
@AutoConfigureMockMvc
public class ApplicationTest {
}
