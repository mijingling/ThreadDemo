package com.demo.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	public static void main(String[] args) throws InterruptedException {
		final CountDownLatch latch = new CountDownLatch(5);// 使用java并发库concurrent
		// 启用5个线程
		for (int i = 1; i <= 5; i++) {
			new Thread(new Runnable() {
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("子线程执行！");
					latch.countDown();// 让latch中的数值减一
				}
			}).start();
		}
		// 主线程
		latch.await();// 阻塞当前线程直到latch中数值为零才执行
		System.out.println("主线程执行！");
	}
}
