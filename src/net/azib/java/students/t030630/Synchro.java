package net.azib.java.students.t030630;

/**
 * Synchro
 * 
 * @author Kasutaja
 */
public class Synchro {

	/**
	 * @param args
	 */
	private static int value;

	private static class Code implements Runnable {
		public synchronized void run() {
			for (int i = 0; i < 100000000; i++) {
				//synchronized (Synchro.class) {
					value++;
				//}		
			}
		};
	}

	public static void main(String[] args) throws InterruptedException {
		Code code = new Code();
		Thread t1 = new Thread(code);
		Thread t2 = new Thread(code);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(value);	
	}

}