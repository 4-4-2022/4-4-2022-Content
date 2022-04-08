package com.revature.threads;

import com.revature.repository.CupcakeRepositoryImpl;

/*
 * If you wish to make your own thread, you need only extend the Thread class. Using multiple threads (multi-threading) entails
 * running separate tasks on multiple threads for the purpose of improving performance.
 * 
 * Note that threads have various "states" which give us information about what the thread is currently doing:
 * 1) NEW: this refers to a thread that has been created and has not been started
 * 2) RUNNABLE: refers to a thread that is running
 * 3) BLOCKED: a thread cannot continue execution because it has not acquired a "lock" for another resource that another thread
 * is currently accessing.
 * 4) WAITING: a thread is waiting without a time limit (usually for some other thread to perform a task)
 * 5) TIMED WAITING: a thread is waiting as in the prior state but for a determined amount of time
 * 6) TERMINATED: a thread has completed its execution
 */
public class MyThread extends Thread{

	/*
	 * When you override the run() method, you are specifying this particular thread's logic.
	 */
	@Override
	public void run() {
		super.run();
		
		for(int i = 0; i < 10; i++) {
			CupcakeRepositoryImpl.getCupcakeRepository();
		}
		
		System.out.println(CupcakeRepositoryImpl.counter);
	}
	
	public static void main(String[] args) {
		
		
		/*
		 * If I want to run some tasks on another thread, I need to create those threads and start them myself.
		 */
		MyThread myThread = new MyThread(); //NEW THREAD
		MyRunnable myRunnable = new MyRunnable();
		myThread.start(); //RUNNABLE
		/*
		 * A Runnable needs to be passed to a thread constructor.
		 */
		Thread thread = new Thread(myRunnable);
		thread.start(); //RUNNABLE
		
		for(int i = 0; i < 10; i++) {
			CupcakeRepositoryImpl.getCupcakeRepository();
		}
	}
	
}

/*
 * Another way of creating a thread is by implementing the Runnable interface. 
 */
class MyRunnable implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			CupcakeRepositoryImpl.getCupcakeRepository();
		}
		
	}
	
}
