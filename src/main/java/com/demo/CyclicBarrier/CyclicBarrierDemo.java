package com.demo.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	// 自定义工作线程
	private static class Worker extends Thread {
		private CyclicBarrier cyclicBarrier;

		public Worker(CyclicBarrier cyclicBarrier) {
			this.cyclicBarrier = cyclicBarrier;
		}

		@Override
		public void run() {
			super.run();

			try {
				// 工作线程开始处理，这里用Thread.sleep()来模拟业务处理
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + "执行业务处理");
				cyclicBarrier.await();
				System.out.println(Thread.currentThread().getName() + "add List");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		int threadCount = 3;
		CyclicBarrier cyclicBarrier = new CyclicBarrier(threadCount);

		for (int i = 0; i < threadCount; i++) {
			System.out.println("创建工作线程" + i);
			Worker worker = new Worker(cyclicBarrier);
			worker.start();
		}
		System.out.println("return xxxList");
	}
}
