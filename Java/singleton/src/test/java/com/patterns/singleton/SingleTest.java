package com.patterns.singleton;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

/**
 * @author: Shen
 *
 * the parent of singleton test classes
 */
public abstract class SingleTest<T> {

    // method to get the instance
    // 获取实例的方法
    private final Supplier<T> getInstanceMethod;

    // defined constructor
    protected SingleTest(Supplier<T> getInstanceMethod) {
        this.getInstanceMethod = getInstanceMethod;
    }

    /**
     * get instance in same thread
     * 在同一个线程中测试获取实例是否一致
     */
    @Test
    public void getInstanceInSameThread() {

        T instance1 = this.getInstanceMethod.get();
        T instance2 = this.getInstanceMethod.get();
        T instance3 = this.getInstanceMethod.get();

        assertSame(instance1, instance2);
        assertSame(instance1, instance3);
        assertSame(instance2, instance3);

    }

    /**
     * get instance in different thread
     * 在多个线程中测试获取实例是否一致
     */
    @Test(timeout = 10000)
    public void getInstanceInDifferentThreads() throws Exception {

        // add tasks
        final List<Callable<T>> tasks = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            tasks.add(this.getInstanceMethod::get);
        }

        // obtain results
        final ExecutorService executorService = Executors.newFixedThreadPool(4);
        final List<Future<T>> results = executorService.invokeAll(tasks);

        // determine whether it is consistent
        // 判断结果是否都为同一实例
        final T target = this.getInstanceMethod.get();
        for (Future<T> res : results) {
            final T instance = res.get();
            assertNotNull(instance);
            assertSame(target, instance);
        }

        // release resource
        // 释放线程
        executorService.shutdown();
    }

}
