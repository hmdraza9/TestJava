package testingThread;

public class ParallelThreadsImplementsRunnable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		printerHere p = new printerHere(); 

		System.out.println("Application started!");
		
		Runnable r1 = new threadWorkClass1(p);
		Thread t1 = new Thread(r1);
		
		Runnable r2 = new threadWorkClass2(p);
		Thread t2 = new Thread(r2);

		Runnable r3 = new threadWorkClass3(p);
		Thread t3 = new Thread(r3);
		
		t1.start();//		t1.join();
		t2.start();//		t2.join();
		t3.start();//		t3.join();

		System.out.println("Application ended!");
	}

}

class threadWorkClass1 implements Runnable {

	printerHere ph;
	
	threadWorkClass1(printerHere p){
		this.ph=p;
	}

	@Override
	public void run() {
		ph.printPerformer(10, "threadWorkClass1");
	}

}

class threadWorkClass2 implements Runnable {

	printerHere ph;
	
	threadWorkClass2(printerHere p){
		ph=p;
	}

	@Override
	public void run() {
		ph.printPerformer(10, "threadWorkClass2");
	}
}

class threadWorkClass3 implements Runnable {

	printerHere ph;
	
	threadWorkClass3(printerHere p){
		ph=p;
	}

	@Override
	public void run() {
		ph.printPerformer(10, "threadWorkClass3");
	}
}

class printerHere {

	 public void printPerformer(int i, String name) {
//	 synchronized void printPerformer(int i, String name) {
		for (int j = 0; j < i; j++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Printing: " + name);
		}
	}
}