package com.patterns.singleton;
/**
 * @author: Shen
 *
 * Hungry-style singleton pattern
 * 饿汉式单例模式
 *
 * is thread-safe: true
 * is lazy-load: false
 * is locked: false
 *
 * 是线程安全的 / 非懒加载 / 不加锁
 *
 * but can be destroyed by reflection
 * 但是可以被反射破坏
 */
public class HungryStyleSingleton {

    // forbidden to call the constructor of this class
    // 禁止直接调用该类构造方法
    private HungryStyleSingleton() {}

    // create an instance of this class
    // 创建该类的实例
    private static final HungryStyleSingleton instance = new HungryStyleSingleton();

    // obtain the only instance of this class
    // 开放获取唯一实例的方式
    public static HungryStyleSingleton getInstance() {
        return instance;
    }

}
