package com.patterns.singleton;

/**
 * @author: Shen
 *
 * Lazy-style singleton pattern with lock
 * 懒汉式单例模式 加锁
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
 * the efficiency is very inefficient because you need to acquire the lock and release the lock every time
 * 效率非常低，因为每次都需要获取锁和释放锁
 */
public class LazyStyleSingletonWithLock {

    // forbidden to call the constructor of this class
    // 禁止直接调用该类构造方法
    private LazyStyleSingletonWithLock() {}

    // init the instance of this class
    // 初始化该类的实例
    private static LazyStyleSingletonWithLock instance;

    // obtain the instance of this class
    // 开放获取实例的方式
    public synchronized static LazyStyleSingletonWithLock getInstance() {
        if (instance == null) {
            instance = new LazyStyleSingletonWithLock();
        }
        return instance;
    }

}
