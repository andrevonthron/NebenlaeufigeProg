package callableFuture;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTestWithMultipleCallables implements Callable<byte[]> {
	
	private byte[] b;
	
	public CallableTestWithMultipleCallables(byte[] b) {
		this.b = b;
	}

	public static void main(String[] args) {
		
		for(int k=0; k<100; k++) {
			byte[] b = new byte[4000000];
			new Random().nextBytes(b);
			ExecutorService executor = Executors.newCachedThreadPool();
			Set<Callable<byte[]>> tasks = new HashSet<Callable<byte[]>>();
			for(int i=0; i<100; i++) {
				tasks.add(new CallableTestWithMultipleCallables(b));
				//executor.submit(c);
			}
			List<Future<byte[]>> results = null;
			try {
				results = executor.invokeAll(tasks);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("aktive Threads: "+Thread.activeCount());
			//ExecutorService beenden um alle Threads zu stoppen. Diese laufen sonst noch eine Weile weiter.
			List<Runnable> s = executor.shutdownNow();
			System.out.println("aktive Tasks nach shutdownNow(): "+s.size());
			System.out.println("ausgeführte Tasks: "+results.size());
			System.out.println("================================");
		}
		

		
//		try {
//			for (Future<byte[]> f : results) {
//				byte[] res = f.get();
//
//				System.out.println(res[res.length-1]);
//				//for (int i=0; i<res.length; i++) {
//				//System.out.println(res[i]);
//				//}
//			}
//
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (ExecutionException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

	}

	@Override
	public byte[] call() throws Exception {
		Arrays.sort(b);
		return b;
	}

}
