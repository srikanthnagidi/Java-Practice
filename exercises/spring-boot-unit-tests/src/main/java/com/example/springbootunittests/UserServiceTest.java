package com.example.springbootunittests;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.UserService;


import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringBootUnitTestsApplication.class})
public class UserServiceTest {
    @Resource
    private UserService userService ;

    @Test
    public void testGetUser(){
        Assert.assertEquals(userService.getUser(), "Tom");
    }

}
