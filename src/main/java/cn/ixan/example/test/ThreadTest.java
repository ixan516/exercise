package cn.ixan.example.test;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月18日, 0018
 */
public class ThreadTest {
	public static void main(String[] args) {
		testRunable();
	}
	public static void testRunable(){
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + "world!");
			}
		};
		runnable.run();
	}

	public static void testThread(){
		Thread thread = new Thread(){
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+"hello!");
			}
		};
		thread.start();
	}
}
