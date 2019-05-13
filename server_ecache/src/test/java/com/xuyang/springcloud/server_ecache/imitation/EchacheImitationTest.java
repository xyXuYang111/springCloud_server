package com.xuyang.springcloud.server_ecache.imitation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EchacheImitationTest {

    @Test
    public void ecacheMap() {
        String value = (String) EchacheImitation.ecacheMap("111");
        System.out.println(value);
    }
}