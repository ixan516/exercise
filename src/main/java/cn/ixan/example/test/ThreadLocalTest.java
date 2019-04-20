package cn.ixan.example.test;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月17日, 0017
 */
public class ThreadLocalTest {
	private static ThreadLocal<Integer> sqlNum = new ThreadLocal<Integer>(){
		@Override
		protected Integer initialValue(){
			return 0;
		}
	};

	public static int getNextNum(){
		sqlNum.set(sqlNum.get()+1);
		return sqlNum.get();
	}

	public static void main(String[] args) {
		for(int i=0; i<3; i++){
			new Thread(){
				@Override
				public void run() {
					for (int i = 0; i < 3; i++) {
						System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn["
								+ getNextNum() + "]");
					}
				}
			}.start();
		}
	}
}
