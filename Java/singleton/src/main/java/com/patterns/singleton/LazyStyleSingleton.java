package com.patterns.singleton;

/**
 * @author: Shen
 *
 * Lazy-style singleton pattern
 * 懒汉式单例模式
 *
 * is thread-safe: false
 * is lazy-load: true
 * is locked: false
 *
 * 非线程安全的 / 是懒加载 / 不加锁
 *
 * but can be destroyed by reflection
 * 但是可以被反射破坏
 */
public class LazyStyleSingleton {

    // forbidden to call the constructor of this class
    // 禁止直接调用该类构造方法
    private LazyStyleSingleton() {}

    // init the instance of this class
    // 初始化该类的实例
    private static LazyStyleSingleton instance;

    // obtain the instance of this class
    // 开放获取实例的方式
    public static LazyStyleSingleton getInstance() {
        if (instance == null) {
            instance = new LazyStyleSingleton();
        }
        return instance;
    }

}
