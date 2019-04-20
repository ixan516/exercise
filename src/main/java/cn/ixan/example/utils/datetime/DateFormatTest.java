package cn.ixan.example.utils.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年4月10日, 0010
 */
public class DateFormatTest {
	private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String formatDate(Date date) throws ParseException{
		synchronized (format) {
			return format.format(date);
		}
	}

	public static Date parse(String date) throws ParseException {
		synchronized (format) {
			return format.parse(date);
		}
	}

	public static void main(String[] args) throws ParseException, InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		for(int i=0; i<20; i++){
			executorService.execute(() -> {
				for(int j=0; j<10; j++){
					try {
						System.out.println(parse("2019-04-10 21:52:00"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			});
		}
		//等待上述线程执行完毕
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.DAYS);
		System.out.println(formatDate(new Date()));
	}
}
