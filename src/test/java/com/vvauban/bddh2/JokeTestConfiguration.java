package com.vvauban.bddh2;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

@TestConfiguration
@ActiveProfiles( "test" )
@ComponentScan( "com.vvauban.bddh2.repository" )
public class JokeTestConfiguration {
}
