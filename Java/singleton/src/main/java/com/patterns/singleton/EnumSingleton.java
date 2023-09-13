package com.patterns.singleton;

/**
 * @author: Shen
 *
 * enum singleton pattern
 * 枚举类单例模式
 *
 * is thread-safe: true
 * is lazy-load: true
 * is locked: false
 *
 * 是线程安全的 / 懒加载 / 不加锁
 *
 * * can not be destroyed by reflection * *
 * * 不可以被反射破坏 * *
 *
 * The enumeration class itself is designed as a singleton
 * 枚举类本身被设计为单例
 *
 * The most recommended way, simple and efficient
 * 最推荐的方式, 简单高效
 */
public enum EnumSingleton {

    INSTANCE;

    public static EnumSingleton getInstance() {
        return EnumSingleton.INSTANCE;
    }

}
