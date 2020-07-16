package testingThread;

public class ThreadSynchroExtendsThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Application started");
		
		final printerHereSync phs = new printerHereSync();
		
		ThreadClass1 t1 = new ThreadClass1(phs);
		ThreadClass2 t2 = new ThreadClass2(phs);
		ThreadClass3 t3 = new ThreadClass3(phs);
		t3.start();
		t1.start();
		t2.start();
		System.out.println("Application stopped");
		
	}
}

class ThreadClass1 extends Thread {

	printerHereSync ph;

	ThreadClass1(printerHereSync p) {
		this.ph = p;
	}

	@Override
	public void run() {
//		ph = new printerHereSync();
		ph.printPerformer(10, "ThreadClass1");
	}
}

class ThreadClass2 extends Thread {

	printerHereSync ph;

	ThreadClass2(printerHereSync p) {
		this.ph = p;
	}

	@Override
	public void run() {
//		ph = new printerHereSync();
		ph.printPerformer(10, "ThreadClass2");
	}
}

class ThreadClass3 extends Thread {

	printerHereSync ph;

	ThreadClass3(printerHereSync p) {
		this.ph = p;
	}

	@Override
	public void run() {
//		ph = new printerHereSync();
		ph.printPerformer(10, "ThreadClass3");
	}
}

class printerHereSync {

//	synchronized void printPerformer(int m, String str) {
	public void printPerformer(int m, String str) {
		for (int i = 0; i < m; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Printing: " + str);
		}
	};

}