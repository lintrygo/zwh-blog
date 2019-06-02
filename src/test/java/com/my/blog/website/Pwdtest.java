package com.my.blog.website;

import com.my.blog.website.modal.Vo.UserVo;
import com.my.blog.website.utils.TaleUtils;
import org.junit.Test;

/**
 * Created by shuaihan on 2017/4/2.
 */
public class Pwdtest {
    public static void main(String args[]){
        UserVo user = new UserVo();
        user.setUsername("admin");
        user.setPassword("asdfasdfs");
        String encodePwd = TaleUtils.MD5encode(user.getUsername() + user.getPassword());
        System.out.println(encodePwd);
    }

    @Test
    public void testException(){
        try{
            int i=100;
            int m = i/0;
                throw new RuntimeException("fff");


        }catch (Exception e){
            e.printStackTrace();
//            throw new RuntimeException("ff11f");
        }
        //System.out.println("1111");
    }
}
