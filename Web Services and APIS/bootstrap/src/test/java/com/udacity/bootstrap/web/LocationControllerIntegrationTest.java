package com.udacity.bootstrap.web;

import com.udacity.bootstrap.entity.Location;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class LocationControllerIntegrationTest {

    @LocalServerPort
    private int port;

    TestRestTemplate testRestTemplate
            = new TestRestTemplate("admin", "password");
    @Test
    public void getAllLocations(){
        ResponseEntity<List> response = this.testRestTemplate.getForEntity("http://localhost:"+port+"/locations", List.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }
}
