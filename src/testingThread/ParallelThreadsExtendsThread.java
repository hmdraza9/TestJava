package testingThread;

public class ParallelThreadsExtendsThread {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		subTaskClass task1 = new subTaskClass();
		ThreadCreate3 task2 = new ThreadCreate3();
		task1.start();
		task1.join();
		task2.start();

		System.out.println("Task main text 1");
		System.out.println("Task main text 2");
		System.out.println("Task main text 3");
		}
}

class subTaskClass extends Thread{
	
	@Override
	public void run() {
		System.out.println("task    1 text 1");
		System.out.println("task    1 text 2");
		System.out.println("task    1 text 3");
	}
}