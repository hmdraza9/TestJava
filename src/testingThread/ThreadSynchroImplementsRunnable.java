package testingThread;

public class ThreadSynchroImplementsRunnable{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		newPrinterHere p = new newPrinterHere(); 

		System.out.println("Application started!");
		
		Runnable r1 = new newThreadWorkClass1(p);
		Thread t1 = new Thread(r1);
		
		Runnable r2 = new newThreadWorkClass2(p);
		Thread t2 = new Thread(r2);

		Runnable r3 = new newThreadWorkClass3(p);
		Thread t3 = new Thread(r3);
		
		t1.start();//		t1.join();
		t2.start();//		t2.join();
		t3.start();//		t3.join();

		System.out.println("Application ended!");
	}

}

class newThreadWorkClass1 implements Runnable {

	newPrinterHere ph;
	
	newThreadWorkClass1(newPrinterHere p){
		this.ph=p;
	}

	@Override
	public void run() {
		ph.printPerformer(10, "newThreadWorkClass1");
	}

}

class newThreadWorkClass2 implements Runnable {

	newPrinterHere ph;
	
	newThreadWorkClass2(newPrinterHere p){
		ph=p;
	}

	@Override
	public void run() {
		ph.printPerformer(10, "newThreadWorkClass2");
	}
}

class newThreadWorkClass3 implements Runnable {

	newPrinterHere ph;
	
	newThreadWorkClass3(newPrinterHere p){
		ph=p;
	}

	@Override
	public void run() {
		ph.printPerformer(10, "newThreadWorkClass3");
	}
}

class newPrinterHere {

//	 public void printPerformer(int i, String name) {
	 synchronized void printPerformer(int i, String name) {
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