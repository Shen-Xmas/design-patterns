package com.patterns.singleton;

import org.junit.Test;

import java.lang.reflect.Constructor;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

/**
 * @author: Shen
 */
public class LazyStyleSingletonWithLockTest extends SingleTest<LazyStyleSingletonWithLock> {

    /**
     * pass in the get instance method to test
     * 传入获取实例方法即可测试
     */
    public LazyStyleSingletonWithLockTest() {
        super(LazyStyleSingletonWithLock :: getInstance);
    }

    /**
     * Test whether it can be broken by reflection
     * 测试是否可以被反射破坏
     *
     * result is true
     * 答案是可以
     */
    @Test
    public void testReflection() throws Exception {

        // obtain constructor and make it enable because it is private
        // 获取构造方法, 由于是private所以需要使它可用
        Constructor<LazyStyleSingletonWithLock> constructor = LazyStyleSingletonWithLock.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        LazyStyleSingletonWithLock instance1 = constructor.newInstance();
        LazyStyleSingletonWithLock instance2 = LazyStyleSingletonWithLock.getInstance();
        LazyStyleSingletonWithLock instance3 = LazyStyleSingletonWithLock.getInstance();

        System.out.println("instance1 by reflection: " + instance1);
        System.out.println("instance2 by normal: " + instance2);
        System.out.println("instance3 by normal: " + instance3);

        assertNotSame(instance1, instance2);
        assertNotSame(instance1, instance3);
        assertSame(instance2, instance3);
    }

}
