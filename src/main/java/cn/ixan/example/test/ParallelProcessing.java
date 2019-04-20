package cn.ixan.example.test;

/**
 * @author stack_zhang@outlook.com
 * @date 2019/2/17
 */
public class ParallelProcessing {
	public static void main(String[] args) {
		System.out.println(getRuntimeCPU());
	}

	private static int getRuntimeCPU() {
		return Runtime.getRuntime().availableProcessors();
	}
}
