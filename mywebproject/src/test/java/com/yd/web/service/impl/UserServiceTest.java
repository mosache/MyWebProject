package com.yd.web.service.impl;

import com.yd.web.MywebprojectApplication;
import com.yd.web.beans.ResponseEntry;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MywebprojectApplication.class},webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getUserById() {
    }

    @Test
    public void loginIn(){
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("username","admin");
        map.add("password","123456");
        ResponseEntry resp = testRestTemplate.postForObject("/loginIn", map, ResponseEntry.class);
        Assert.assertNotNull(resp);
        Assert.assertEquals(1,resp.getState());
    }
}