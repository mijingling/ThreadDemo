package com.demo.CyclicBarrier;

import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierDemo3 {
	private static final Integer THREAD_SIZE = 3;
	 
    public static void main(String[] args) throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        Integer sum = 0;
        ThreadPoolExecutor pool = new ThreadPoolExecutor(THREAD_SIZE, THREAD_SIZE, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        Future<Integer> sum10 = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Integer sum1 = 0;
                try {
                    for (int i = 1; i <= 100; i++) {
                        sum1 = sum1 + i;
                    }
                } catch (Exception e) {
                    System.out.println("1 error:" + e.getMessage());
                }
                System.out.println(sum1);
                System.out.println(Thread.currentThread().getName());
                cyclicBarrier.await();
                return sum1;
            }
        });
        System.out.println("sum10:" + sum10.get());
 
//        ThreadPoolExecutor pool2 = new ThreadPoolExecutor(THREAD_SIZE, THREAD_SIZE, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        Future<Integer> sum20 = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Integer sum1 = 0;
                try {
                    for (int i = 101; i <= 200; i++) {
                        sum1 = sum1 + i;
                    }
                } catch (Exception e) {
                    System.out.println("1 error:" + e.getMessage());
                }
                System.out.println(sum1);
                System.out.println(Thread.currentThread().getName());
                cyclicBarrier.await();
                return sum1;
            }
        });
 
//        ThreadPoolExecutor pool3 = new ThreadPoolExecutor(THREAD_SIZE, THREAD_SIZE, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        Future<Integer> sum30 = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Integer sum1 = 0;
                try {
                    for (int i = 201; i <= 300; i++) {
                        sum1 = sum1 + i;
                    }
                } catch (Exception e) {
                    System.out.println("1 error:" + e.getMessage());
                }
                System.out.println(sum1);
                System.out.println(Thread.currentThread().getName());
                cyclicBarrier.await();
                return sum1;
            }
        });
//        System.out.println("sum30:" + sum30.get());
        pool.shutdown();
        sum = sum10.get() + sum20.get() + sum30.get();
        System.out.println("sum:" + sum);
    }
}
