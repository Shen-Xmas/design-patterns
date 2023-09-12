package com.patterns.singleton;

import org.junit.Test;
import java.lang.reflect.Constructor;
import static org.junit.Assert.assertSame;

/**
 * @author: Shen
 */
public class HungryStyleSingletonTest extends SingleTest<HungryStyleSingleton> {

    /**
     * pass in the get instance method to test
     * 传入获取实例方法即可测试
     */
    public HungryStyleSingletonTest() {
        super(HungryStyleSingleton :: getInstance);
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
        Constructor<HungryStyleSingleton> constructor = HungryStyleSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        HungryStyleSingleton instance1 = constructor.newInstance();
        HungryStyleSingleton instance2 = HungryStyleSingleton.getInstance();
        HungryStyleSingleton instance3 = HungryStyleSingleton.getInstance();

        System.out.println("instance by reflection: " + instance1);
        System.out.println("instance by normal: " + instance2);
        System.out.println("instance by normal: " + instance3);

        assertSame(instance1, instance2);
        assertSame(instance1, instance3);
        assertSame(instance2, instance3);
    }

}
