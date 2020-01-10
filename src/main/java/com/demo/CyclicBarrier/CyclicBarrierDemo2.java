package com.demo.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
//CyclicBarrier 的字面意思是可循环使用(Cyclic)的屏障(Barrier)。它要做的事情是，让一组线程到达一个屏障(也可以叫同步点)时被阻塞，直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续干活。
public class CyclicBarrierDemo2 {
	public static void main(String[] args) throws Exception {
		final CyclicBarrier barrier = new CyclicBarrier(5);
		// 启用5个线程
		for (int i = 1; i <= 5; i++) {
			System.out.println("##"+i);
			new Thread(new Runnable() {
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("子线程执行！");
					try {
						barrier.await();// 到达屏障
					} catch (InterruptedException | BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}
		// 主线程
		barrier.await();// 阻塞当前线程直到latch中数值为零才执行
		System.out.println("main主线程执行！");
	}
}
