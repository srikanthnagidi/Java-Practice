package com.udacity.bootstrapII.tests;

import com.udacity.bootstrapII.service.DogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DogControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private TestRestTemplate testRestTemplate = new TestRestTemplate("admin", "password");

    @Test
    public void getAllDogs() throws Exception{
        ResponseEntity<List> responseEntity = testRestTemplate.getForEntity("http://localhost:"+port+"/dogs", List.class);
        assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getDogBreed() throws Exception{
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("http://localhost:" + port + "/1/breed", String.class);

        assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
    }

}
