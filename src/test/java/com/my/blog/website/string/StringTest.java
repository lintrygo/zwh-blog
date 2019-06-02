package com.my.blog.website.string;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class StringTest {

    @Test
    public void test(){
        System.out.println(around("36230119960625201612",5,5));
        System.out.println(around("12345678",2,2));
        String str = "123456";
        String re = str.substring(0,2)+test(str.length()-4)+str.substring(str.length()-2,str.length());
        System.out.println(re);
    }

    public static String around(String name,int index,int end) {
        if (StringUtils.isBlank(name)) {
            return "";
        }
        return StringUtils.left(name, index).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(name, end), StringUtils.length(name), "*"), "***"));
    }

    public static String test(int size){
        StringBuffer buffer = new StringBuffer();
        for(int i=0;i<size;i++){
            buffer.append("*");
        }
        return  buffer.toString();
    }
}
