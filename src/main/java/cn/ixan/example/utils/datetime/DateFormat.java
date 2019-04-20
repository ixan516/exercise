package cn.ixan.example.utils.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Java8日期API
 * @author stack_zhang@outlook.com
 * @date 2019年4月10日, 0010
 */
public class DateFormat {
	private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public static String formatDate(LocalDateTime date) {
		return format.format(date);
	}

	public static LocalDateTime parse(String date) {
		return LocalDateTime.parse(date,format);
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		for(int i=0; i<20; i++){
			executorService.execute(() -> {
				for(int j=0; j<10; j++){
					System.out.println(formatDate(LocalDateTime.now()));
				}
			});
		}
		//等待上述线程执行完毕
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.DAYS);
	}
}
