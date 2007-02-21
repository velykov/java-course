package net.azib.java.students.t030632;

import java.util.Date;

/**
 * Runner
 *
 * @author Toni
 */
public class Runner {
	public void runSomething(Runnable runnable){
		System.out.println("Starting runnable: " + new Date());
		runnable.run();
		System.out.println("Stop runnable:" + new Date());
	}
	public static void main(String[] args) {
		
		Runnable runnable1 = new Runnable(){
			public void run() { 
				System.out.println("Running some code...");
			}
		};
		
		Runnable runnable2 = new Runnable(){
			public void run() {
				System.out.println("Running another code...");
			}
		}; 

		Runner runner = new Runner();
		runner.runSomething(runnable1);
		runner.runSomething(runnable2);
		
		
	}

}
