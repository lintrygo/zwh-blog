package com.my.blog.website.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {

    @Test
    public void test1(){
        Map<String,String> hashMap = new HashMap<>(1);
        hashMap.put("key1","value1");
        hashMap.put("key2","value2");
        Iterator<Map.Entry<String, String>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            System.out.print("key:" + entry.getKey() + ", value: " + entry.getValue());
        }
        System.out.println();
    }

    @Test
    public void test2(){
        Map<KeyTest,String> hashMap = new HashMap<>();
        KeyTest key1 = new KeyTest(1);
        KeyTest key2 = new KeyTest(1);
        hashMap.put(key1,"value1");
        hashMap.put(key2,"value2");
        System.out.println("map-size:"+hashMap.size());
        System.out.println("key1:"+hashMap.get(key1));
        System.out.println("key2:"+hashMap.get(key2));
    }

}
