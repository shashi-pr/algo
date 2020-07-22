package practice;

import java.util.concurrent.CountDownLatch;

public class TestHarness {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public long timeTasks(int nThreads, Runnable task) throws InterruptedException {
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(nThreads);
		for (int i = 0; i < nThreads; i++) {
			Thread t = new Thread() {
				public void run() {
					try {
						startGate.await();
						try {
							task.run();
						} finally {
							endGate.countDown();
						}
					} catch (InterruptedException ex) {
					}
				}
			};
		}
		long startTime = System.nanoTime();
		startGate.countDown();
		endGate.await();
		long endTime = System.nanoTime();
		return endTime - startTime;

	}

}
