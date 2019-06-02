package com.my.blog.website.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TimeTest {

    @Test
    public void TestLocalDateTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime startTime = getDayStart(localDateTime);
        LocalDateTime time = startTime.plusHours(21);
        System.out.println(""+convertLDTToDate(time));
    }

    public static LocalDateTime getDayStart(LocalDateTime time) {
        return time.withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
    }

    public static Date convertLDTToDate(LocalDateTime time) {
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }
}
