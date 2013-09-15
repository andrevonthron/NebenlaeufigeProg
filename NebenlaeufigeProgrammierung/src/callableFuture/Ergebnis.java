package callableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Ergebnis implements Future<Ergebnis> {
	
	private String ergebnis;
	
	public Ergebnis() {
		this.ergebnis = "positiv";
	}
	
	public String getErgebnis() {
		return ergebnis;
	}

	@Override
	public boolean cancel(boolean arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Ergebnis get() throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public Ergebnis get(long arg0, TimeUnit arg1) throws InterruptedException,
			ExecutionException, TimeoutException {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public boolean isCancelled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return false;
	}

}
