package com.my.blog.website.common;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HolidayTest {


    public static String getData(String addess){
        URL url = null;
        HttpURLConnection httpConn = null;
        StringBuffer sb = new StringBuffer();
        try(BufferedReader in = new BufferedReader(new InputStreamReader(new URL(addess).openStream(),"utf-8") )){
            String str = null;
            while((str = in.readLine()) != null) {
                sb.append( str );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        String  data =sb.toString();
        return data;
    }

    @Test
    public void testHoliday(){
        LocalDate nowDate = LocalDate.now();
        LocalDate firstDate = LocalDate.of(nowDate.getYear(),1,1);
        LocalDate endDate = LocalDate.of(nowDate.getYear(),12,31);
        String date = "";
        String result = "";
        String value = "";
        while(firstDate.compareTo(endDate)<=0){
            date = DateTimeFormatter.ofPattern("yyyyMMdd").format(firstDate);
            result = getData("http://api.goseek.cn/Tools/holiday?date="+date);
            value = JSONObject.parseObject(result).get("data").toString();
            if("1".equals(value)||"3".equals(value)){
                System.out.println(date);
            }
            firstDate = firstDate.plusDays(1);
        }

    }

    @Test
    public void testDate(){
        LocalDate date = LocalDate.now();
        date = date.plusDays(1);
    }


}