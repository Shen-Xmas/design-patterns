package com.patterns.singleton;

/**
 * @author: Shen
 *
 * static inner class singleton pattern
 * 静态内部类单例模式
 *
 * is thread-safe: true
 * is lazy-load: true
 * is locked: false
 *
 * 线程安全的 / 是懒加载 / 不加锁
 *
 * but can be destroyed by reflection
 * 但是可以被反射破坏
 *
 * When Java loads the external class, it will not create an instance of the internal class.
 * It will only create the instance of the internal class when the external class uses the internal class.
 * Java加载外部类的时候, 不会创建内部类的实例, 只有在外部类使用到内部类的时候才会创建内部类实例
 */
public class StaticInnerClassSingleton {

    // forbidden to call the constructor of this class
    // 禁止直接调用该类构造方法
    private StaticInnerClassSingleton() {}

    // init the instance of this class
    // 初始化该类的实例
    private static class InnerSingleton {
        private static final StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }

    // obtain the instance of this class
    // 开放获取实例的方式
    public static StaticInnerClassSingleton getInstance() {
        return InnerSingleton.instance;
    }

}
