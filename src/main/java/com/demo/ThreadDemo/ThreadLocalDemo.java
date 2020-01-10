package com.demo.ThreadDemo;

import java.util.Random;

public class ThreadLocalDemo {
	public static class MyRunnable implements Runnable{
		private ThreadLocal<Integer>threadLocal=new ThreadLocal<>();
		@Override
		public void run() {
			// TODO Auto-generated method stub
			threadLocal.set(new Random().nextInt(100));
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread()+":"+threadLocal.get());
		}
		
	}
	public static void main(String[] args) {
		System.out.println("start");
		MyRunnable runnable=new MyRunnable();
		Thread thread1=new Thread(runnable);
		Thread thread2=new Thread(runnable);
		thread1.start();
		thread2.start();
	}

}
