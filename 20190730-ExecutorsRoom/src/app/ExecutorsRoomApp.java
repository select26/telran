package app;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ExecutorsRoomApp {

	private static final int NUM_TASK = 16;
	private static final long THREAD_DALAY = 1000;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exec = Executors.newFixedThreadPool(5);
//		exec.execute(() -> {
//			try {
//				Thread.sleep(3000);
//			} catch (Exception e) {}
//			System.out.println("thread");
//		});
//		exec.shutdownNow();
//		System.out.println("main");
		
/*		
		for (int i = 0; i < NUM_TASK; i++) {
			exec.execute(
					() -> {
						try {
							Thread.sleep(THREAD_DALAY);
						} catch (Exception e) {}
						System.out.println("ID: " + Thread.currentThread().getId() + ", " + Thread.currentThread().getName());
					});
		}
*/
/*		
		Future<String> future = exec.submit( () -> {
			Thread.sleep(THREAD_DALAY);
			return Thread.currentThread().getName();
		});
		
		System.out.println(future.get());
		exec.shutdown();
		System.out.println("main finished..");
*/
		ScheduledExecutorService scheduled = Executors.newSingleThreadScheduledExecutor();
/*		scheduled.scheduleAtFixedRate( () -> {
				System.out.println(LocalTime.now());
				}, 1, 1, TimeUnit.SECONDS);
*/				
		scheduled.scheduleWithFixedDelay( () -> {
			try {
				Thread.sleep(3000);
			} catch (Exception e) {}
			System.out.println(LocalTime.now());
			}, 1, 1, TimeUnit.SECONDS);
		
	}

}
