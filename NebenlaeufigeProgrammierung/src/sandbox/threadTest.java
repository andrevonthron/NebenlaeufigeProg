package sandbox;

import java.util.concurrent.TimeUnit;

public class threadTest implements Runnable {
	
	private String name;
	
	public threadTest(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		
		
		for(int i=0; i<99; i++) {
			
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			threadTest t = new threadTest("Thread "+String.valueOf(i));
			Thread th = new Thread(t);
			th.start();
		}
		
//		while(true)
//			System.out.println(Thread.activeCount());
		

	}



	@Override
	public void run() {
		
		
		while(true) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(this.name);
		}
			
	}

}
