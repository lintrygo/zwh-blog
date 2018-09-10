package com.my.blog.website.common;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class CollectionTest {

    /**
     *测试HashMap,TreeMap
     */
    @Test
    public void TestMap(){
        Map<String,String> hashMap = new HashMap<>();
        Map<String,String> treeMap = new TreeMap<>();
        hashMap.put(null,null);
        hashMap.put("1","1");
        hashMap.put("2","2");
        hashMap.put("3","3");
        hashMap.put("4","4");
        treeMap.put("1","1");
        for(Map.Entry<String,String> entry : hashMap.entrySet()) {
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }

        for(String key : hashMap.keySet()){
            System.out.println("key: "+key);
        }
        for(String value : hashMap.values()){
            System.out.println("value: "+value);
        }
        for(String key : hashMap.keySet()){
            System.out.println("key: "+key+" value: "+hashMap.get(key));
        }

        Iterator<Map.Entry<String,String>> entries = hashMap.entrySet().iterator();
        while(entries.hasNext()){
            Map.Entry entry = entries.next();
            System.out.println("key: "+entry.getKey()+" value: "+entry.getValue());
        }

    }
}
