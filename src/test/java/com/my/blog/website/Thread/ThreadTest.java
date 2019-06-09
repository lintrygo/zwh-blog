package com.my.blog.website.Thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.io.*;

@Slf4j
public class ThreadTest {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ThreadTest.class);


    @Test
    public  void readFile() {
        Long begin = System.currentTimeMillis();
        String pathname = "D://output.txt"; // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
        //不关闭文件会导致资源的泄露，读写文件都同理
        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            //网友推荐更加简洁的写法
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据kkk
                log.info(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Long end = System.currentTimeMillis();
        System.out.println("总耗时:"+(end-begin));
    }

    @Test
    public void writeFile() {
        try {
            File writeName = new File("D://output.txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                for(int i = 0;i<1000000;i++){
                    out.write("我会写入文件啦1\r\n"); // \r\n即为换行
                    out.write("我会写入文件啦2\r\n"); // \r\n即为换行
                }
                out.flush(); // 把缓存区内容压入文件
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() throws Exception{
        Long begin = System.currentTimeMillis();
        File file = new File("D://output.txt");
        int count = getFileLineNumber(file);
        Long end = System.currentTimeMillis();
        System.out.println("总耗时:"+(end-begin));
        System.out.println("总行数:"+count);
    }

    @Test
    public void test2(){

    }

    public int getFileLineNumber(File file) throws IOException {
        LineNumberReader lnr = new LineNumberReader(new FileReader(file));
        lnr.skip(Long.MAX_VALUE);
        int lineNo = lnr.getLineNumber() + 1;
//        LOG.info(String.format("fileNo is %d", lineNo));
        lnr.close();
        return lineNo;
    }

    public static void main(String[] args) {
//        ThreadDemo1 demo1 = new ThreadDemo1();
//        Thread thread = new Thread(demo1,"oooo1");
//        Thread thread1 = new Thread(demo1,"oooo2");
//        thread.start();
//        thread1.start();
       // File file = new File("D://abc.txt");
        Long begin = System.currentTimeMillis();
        ThreadReadFile threadReadFile = new ThreadReadFile();
        Thread thread = new Thread(threadReadFile);
        Thread thread1 = new Thread(threadReadFile);
        thread.start();
        thread1.start();
        Long end = System.currentTimeMillis();
        System.out.println("线程总耗时:"+(end-begin));

    }


}
