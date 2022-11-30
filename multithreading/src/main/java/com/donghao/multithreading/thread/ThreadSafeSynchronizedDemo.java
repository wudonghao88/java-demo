package com.donghao.multithreading.thread;

public class ThreadSafeSynchronizedDemo {
  private static int data;

  public static void main(String[] args) {
    Thread thread1 = new Thread() {
      @Override
      public void run() {
        for (int i = 0; i < 10; i++) {
          increment("1");
        }
      }
    };

    Thread thread2 = new Thread() {
      @Override
      public void run() {
        for (int i = 0; i < 10; i++) {
          increment("2");
        }
      }
    };
    thread1.start();
    // try {
    // thread1.join();
    // } catch (InterruptedException e) {
    // throw new RuntimeException(e);
    // }

    thread2.start();
    // try {
    // thread2.join();
    // } catch (InterruptedException e) {
    // throw new RuntimeException(e);
    // }

  }

  private synchronized static void increment(String title) {
    data++;
    System.out.println(title + ":" + data);
  }
}
