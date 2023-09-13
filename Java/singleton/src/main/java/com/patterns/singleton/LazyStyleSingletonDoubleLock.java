package com.patterns.singleton;

/**
 * @author: Shen
 *
 * Lazy-style singleton pattern with double lock
 * 懒汉式单例模式 双重检锁
 *
 * is thread-safe: true
 * is lazy-load: true
 * is locked: true
 *
 * 线程安全的 / 是懒加载 / 加锁
 *
 * but can be destroyed by reflection
 * 但是可以被反射破坏
 *
 * more efficient than LazyStyleSingletonWithLock
 * but the writing is very complicated
 * 效率比LazyStyleSingletonWithLock要高，只有创建实例时加锁
 * 但是写起来非常复杂
 */
public class LazyStyleSingletonDoubleLock {

    // forbidden to call the constructor of this class
    // 禁止直接调用该类构造方法
    private LazyStyleSingletonDoubleLock() {}

    /**
     * init the instance of this class
     * 初始化该类的实例
     *
     * Instruction reordering in Java 1.4 and earlier versions
     * may cause the singleton object to be used by another thread
     * after it is created and assigned to the instance before it is initialized.
     * Later versions solved this problem, so there is no need to add volatile anymore.
     * 在 Java 1.4 及更早的版本中指令重排序可能会导致 Singleton 对象被创建,
     * 并且赋值给 instance 之后, 还没来得及初始化, 就被另一个线程使用了,
     * 所以需要volatile, 后面的版本解决了这个问题, 所以不再需要加了
     */
    private volatile static LazyStyleSingletonDoubleLock instance;

    // obtain the instance of this class
    // 开放获取实例的方式
    public static LazyStyleSingletonDoubleLock getInstance() {
        if (instance == null) {
            /**
             * Prevent multiple threads creating instances
             * after judging that the instance is empty at the same time
             * 防止多个线程同时判断实例为空后创建实例
             */
            synchronized (LazyStyleSingletonDoubleLock.class) {
                if (instance == null) {
                    instance = new LazyStyleSingletonDoubleLock();
                }
            }
        }
        return instance;
    }

}
