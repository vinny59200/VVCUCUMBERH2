package com.vvauban.bddh2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vvauban.bddh2.model.Joke;
import com.vvauban.bddh2.repository.JokeRepository;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
public class StepDefinitions {

    @Autowired
    private JokeRepository repo;

    public static final String  DUMMY_LOCAL_JOKE_URL = "http://localhost:8080/api/jokes";
    @Autowired
    private             MockMvc mockMvc;

    //To pass data between the steps
    private static final ThreadLocal<DummyContext> CTX_KEEPER = new ThreadLocal<>();

    private static DummyContext context() {
        log.error( "vv dummy context null?" + (CTX_KEEPER.get() == null) );
        return CTX_KEEPER.get();
    }

    @Before
    public void before() {
        CTX_KEEPER.set( new DummyContext() );
    }


    @When( "^the client call the app$" )
    public void frontCallOfOurAppByClient() {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post( DUMMY_LOCAL_JOKE_URL )
                                                                      .content( asJsonString( Joke.builder()
                                                                                                  .content( "Moving to Paris would be In-Seine." )
                                                                                                  .build() ) )
                                                                      .contentType( MediaType.APPLICATION_JSON )
                                                                      .accept( MediaType.APPLICATION_JSON );
        builder.accept( MediaType.APPLICATION_JSON );
        try {
            log.error( "vv in the when setting the current action" );
            context().setCurrentAction( this.mockMvc.perform( builder ) );
        } catch ( Exception e ) {
            log.error( "VV error in when:" + e.getMessage() );
            context().setCurrentException( e );
        }
    }

    @Then( "^the client receives status code of (\\d+)$" )
    public void checkCallStatus( int statusCode ) throws Throwable {
        log.error( "vv in the then getting the current action" );
        context().getCurrentAction()
                 .andExpect( status().is( statusCode ) );
    }

    @And( "^the client receives server joke (.+)$" )
    public void checkDBRecordy( String joke ) throws Throwable {
        log.error( "vv in the and getting the current action" );
        Joke foundCreatedJoke = repo.findAll()
                                    .get( 0 );

        assertEquals( getJoke().getContent(), foundCreatedJoke.getContent() );
    }

    @Data
    public static class DummyContext {
        private Exception     currentException;
        private ResultActions currentAction;
    }

    public static String asJsonString( final Object obj ) {
        try {
            return new ObjectMapper().writeValueAsString( obj );
        } catch ( Exception e ) {
            throw new RuntimeException( e );
        }
    }

    private Joke getJoke() {
        Joke joke = new Joke();
        joke.setContent( "Moving to Paris would be In-Seine." );
        return joke;
    }

}
