package callableFuture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest implements Callable<byte[]> {
	
	private byte[] b;
	
	public CallableTest(byte[] b) {
		this.b = b;
	}

	public static void main(String[] args) {
		byte[] b = new byte[4000000];
		new Random().nextBytes(b);
		
		Callable<byte[]> c = new CallableTest(b);
		ExecutorService executor = Executors.newCachedThreadPool();
		Future<byte[]> result = executor.submit(c);
		
		//ExecutorService beenden um alle Threads zu stoppen. Diese laufen sonst noch eine Weile weiter.
		List<Runnable> s = executor.shutdownNow();
		System.out.println(s.size());
		
		try {
			byte[] res = result.get();
			System.out.println(result.isDone());
			
			System.out.println(res[res.length-1]);
//			for (int i=0; i<res.length; i++) {
//				System.out.println(res[i]);
//			}
			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public byte[] call() throws Exception {
		Arrays.sort(b);
		return b;
	}

}
