package com.patterns.singleton;

import org.junit.Test;

import java.lang.reflect.Constructor;

import static org.junit.Assert.assertSame;

/**
 * @author: Shen
 */
public class EnumSingletonTest extends SingleTest<EnumSingleton> {

    /**
     * pass in the get instance method to test
     * 传入获取实例方法即可测试
     */
    public EnumSingletonTest() {
        super(EnumSingleton :: getInstance);
    }

    /**
     * Test whether it can be broken by reflection
     * 测试是否可以被反射破坏
     *
     * result is false
     * 答案是不可以
     */
    @Test
    public void testReflection() throws Exception {

        // obtain constructor and make it enable because it is private
        // 获取构造方法, 由于是private所以需要使它可用
        Constructor<EnumSingleton> constructor = EnumSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        EnumSingleton instance1 = constructor.newInstance(); // an error will be reported here  此处会报错
        EnumSingleton instance2 = EnumSingleton.INSTANCE;
        EnumSingleton instance3 = EnumSingleton.INSTANCE;

        System.out.println("instance1 by reflection: " + instance1);
        System.out.println("instance2 by normal: " + instance2);
        System.out.println("instance3 by normal: " + instance3);

        assertSame(instance1, instance2);
        assertSame(instance1, instance3);
        assertSame(instance2, instance3);
    }

}
