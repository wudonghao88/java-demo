package com.donghao.multithreading;

public class ThreadUnsafeDemo {
  private static int data;

  public static void main(String[] args) {
    Thread thread1 = new Thread() {
      @Override
      public void run() {
        for (int i = 0; i < 10; i++) {
          System.out.println("1:" + ++data);
        }
      }
    };

    Thread thread2 = new Thread() {
      @Override
      public void run() {
        for (int i = 0; i < 10; i++) {
          System.out.println("2:" + ++data);
        }
      }
    };
    thread1.start();
//    try {
//      thread1.join();
//    } catch (InterruptedException e) {
//      throw new RuntimeException(e);
//    }

    thread2.start();
//    try {
//      thread2.join();
//    } catch (InterruptedException e) {
//      throw new RuntimeException(e);
//    }

  }

}
