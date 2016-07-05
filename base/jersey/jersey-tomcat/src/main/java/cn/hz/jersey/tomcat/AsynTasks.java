package cn.hz.jersey.tomcat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AsynTasks {

	private boolean isAsyn = true;	//是否异步执行
	private boolean awaitComplete = true;	//是否等待执行完成,当异步执行时起作用
	private int size; // 任务数
	private List<Task> tasks;
	private CountDownLatch count;
	
	public AsynTasks(List<Task> tasks, boolean isAsyn, boolean awaitComplete) {
		this.isAsyn = isAsyn;
		this.awaitComplete = awaitComplete;
		this.size = tasks.size();
		this.tasks = tasks;
		if (isAsyn && awaitComplete) {
			this.count = new CountDownLatch(size);
		}
	}

	public AsynTasks(List<Task> tasks, boolean isAsyn) {
		this(tasks, isAsyn, true);
	}

	public AsynTasks(List<Task> tasks) {
		this(tasks, true);
	}

	public void execute() throws InterruptedException {
		if (isAsyn) {
			executeAsyn();
		} else {
			executeSyn();
		}
	}

	private void executeAsyn() throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < size; i++) {
			exec.execute(tasks.get(i).setCount(count));
		}
		if(count != null){
			count.await();
		}
		exec.shutdown();
	}

	private void executeSyn() {

		for (int i = 0; i < size; i++) {
			tasks.get(i).execute();
		}
	}

	public static abstract class Task<V> implements Runnable {

		private CountDownLatch count;

		@Override
		public void run() {
			execute();
			if (count != null) {
				count.countDown();
			}
		}

		public abstract void execute();

		public abstract V result();

		public final Task<V> setCount(CountDownLatch count) {
			this.count = count;
			return this;
		}

	}

	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		List<Task> tasks = new ArrayList<Task>();
		final Random rand = new Random();

		class Task1 extends Task<String> {
			private Random r = rand;
			private String result = "";

			@Override
			public void execute() {
				try {
					System.out.println("bit: " + r.nextInt(10));
					TimeUnit.SECONDS.sleep(1);
					System.out.println("1");
					result = "Hello World";
				} catch (InterruptedException e) {
				}
			}

			@Override
			public String result() {
				return result;
			}

		}

		class Task2 extends Task<Integer> {

			@Override
			public void execute() {
				try {
					TimeUnit.SECONDS.sleep(2);
					System.out.println("2");
				} catch (InterruptedException e) {
				}
			}

			@Override
			public Integer result() {
				return 2;
			}

		}

		class Task3 extends Task {

			@Override
			public void execute() {
				try {
					TimeUnit.SECONDS.sleep(3);
					System.out.println("3");
				} catch (InterruptedException e) {
				}
			}

			@Override
			public String result() {
				return null;
			}

		}

		tasks.add(new Task1());
		tasks.add(new Task2());
		tasks.add(new Task3());
		
		new AsynTasks(tasks, true, false).execute();
		long end = System.currentTimeMillis();
		System.out.println("time: " + (end - start));
	}

}
