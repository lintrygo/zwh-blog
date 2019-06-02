package com.my.blog.website.TestJson;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDemo {

    /**
     * Arrays.asList使用方法
     * 不适用与基本数据类型
     *  没有add,remove方法
     */
    @Test
    public void test(){
        String[] s = {"aa","bb","cc"};
        List<String> list = Arrays.asList(s);
        Map<String,Object> testMap = new HashMap<>();
        testMap.put("111",111);
        testMap.put("222","222");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name1","aaa");
        jsonObject.put("name2","bbb");
        jsonObject.put("name3","ccc");
        jsonObject.put("name4",s);
        jsonObject.put("name5",testMap);

        System.out.println(jsonObject);
        System.out.println(jsonObject.toJSONString());
        System.out.println(jsonObject.toString());

        //字符串转变json对象
        JSONObject jsonObject1 = JSONObject.parseObject(jsonObject.toJSONString());
        System.out.println("name1:"+jsonObject1.getString("name1"));
        System.out.println("name2:"+jsonObject1.getString("name2"));
        System.out.println("name3:"+jsonObject1.getString("name3"));
        //JSONObject.parseArray()
//        Map<String,String> map = JSONObject.parseObject("",Map.class);
//        jsonObject1.getJSONArray("name4");
//        List<String> tets = JSONObject.parseArray(jsonObject1.getJSONArray("name4").toJSONString(),String.class);
    }
}
