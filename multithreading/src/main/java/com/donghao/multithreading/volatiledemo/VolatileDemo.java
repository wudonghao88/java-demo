package com.donghao.multithreading.volatiledemo;

import java.util.concurrent.TimeUnit;

/**
 * volatile使用
 */
public class VolatileDemo {

    static volatile int flag = 0;

    public static void main(String[] args) {
        new Thread() {

            public void run() {
                int localFlag = flag;
                while (true) {
                    if (localFlag != flag) {
                        localFlag = flag;
                        System.out.println("读取到了修改后的标志位：" + flag);
                    }
                }
            }

            ;

        }.start();
        new Thread() {

            public void run() {
                int localFlag = flag;
                while (true) {
                    flag = localFlag;
                    System.out.println("标志位被修改为了：" + ++localFlag);
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            ;

        }.start();
    }

}
