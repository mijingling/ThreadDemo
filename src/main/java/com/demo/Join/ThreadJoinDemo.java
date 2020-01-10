package com.demo.Join;

import java.util.Vector;

public class ThreadJoinDemo {
	public static void main(String[] args) throws InterruptedException {
		Vector<Thread> vectors = new Vector<Thread>();
		// 启用5个线程
		for (int i = 1; i <= 5; i++) {
			Thread childrenThread = new Thread(new Runnable() {
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("子线程执行！");
				}
			});
			vectors.add(childrenThread);
			childrenThread.start();
		}
		//主线程
		for (Thread thread : vectors) {
			thread.join(); // 使用join来保证childrenThread的5个线程都执行完后，才执行主线程
		}
		System.out.println("主线程执行！");
	}
}
