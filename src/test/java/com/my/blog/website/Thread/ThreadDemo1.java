package com.my.blog.website.Thread;

public class ThreadDemo1 implements Runnable{
    private int number = 100000;
    @Override
    public  void run() {
        for(int i = 0 ;i<1000000;i++){

                if(number>0){
                    System.out.println(Thread.currentThread().getName()+"--卖出票：" + number--);
                }

//            try{
//                Thread.sleep(1000);
//            }catch (Exception e){
//
//            }

        }
    }
}
