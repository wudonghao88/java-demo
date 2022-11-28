package com.donghao.multithreading;

/**
 * @author donghao.wu
 */
public class DoubleCheckDemo {
  /**
   * 单例模式：双层校验
   *
   * 由于是要使用单例模式
   * 所以instance变量为private类型
   * volatile保证可见性
   */
  private static volatile DoubleCheckDemo instance;

  public DoubleCheckDemo() {
  }

  public DoubleCheckDemo getInstance() {
    if (instance == null) {
      /*
       * 多线程会卡在这里
       */
      synchronized (DoubleCheckDemo.class) {
        /*
         * 第一个线程陷进来了
         * 第二个线程进来了此时如果没有volatile这个关键字 会继续创建一个实例然后从工作内存传回主内存
         * 有了的话 则不会继续创建
         */
        if (instance == null) {
          // 创建一个单例
          instance = new DoubleCheckDemo();
        }
      }
    }
    // 返回
    return instance;
  }
}
