package javaConcepts2;

public class ThreadCreate1 extends Thread {

	public void run() {
		System.out.println("Thread started in ThreadCreate1...");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThreadCreate1 t1 = new ThreadCreate1();
		t1.run();
		ThreadCreate2 m2 = new ThreadCreate2();
		Thread t2 = new Thread(m2);
		t2.run();
		System.out.println("t1 id: " + t1.getId());
		System.out.println("t1 name: " + t1.getName());
		System.out.println("Active count: " + Thread.activeCount());
		System.out.println("t1 state: " + t1.getState());
		System.out.println("t1 thread group: " + t1.getThreadGroup());
		System.out.println("t1 isAlive: " + t1.isAlive());
		System.out.println("t1 isDaemon: " + t1.isDaemon());
		System.out.println("t1 Interrupted: " + t1.isInterrupted());

		System.out.println("t2 id: " + t2.getId());
		System.out.println("t2 name: " + t2.getName());
		System.out.println("Active count: " + Thread.activeCount());
		System.out.println("t2 state: " + t2.getState());
		System.out.println("t2 thread group: " + t2.getThreadGroup());
		System.out.println("t2 isAlive: " + t2.isAlive());
		System.out.println("t2 isDaemon: " + t2.isDaemon());
		System.out.println("t2 Interrupted: " + t2.isInterrupted());

	}

}

class ThreadCreate2 implements Runnable {
	public void run() {
		System.out.println("Thread started in ThreadCreate2...");
	}
}
