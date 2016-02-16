import javafx.concurrent.Task;


public class RunnableTask extends Task<String>{

	public Thread t;
	public String threadName;
	public boolean suspended;
	
	public RunnableTask(String threadName) {
		this.threadName = threadName;
	}
	
	@Override
	protected String call() throws Exception {
		try {
			for (int i = 0; i < 100; i++) {
				Thread.sleep(1000);
				System.out.println(threadName);
				synchronized (this) {
					while (suspended) {
						System.out.println( threadName +": suspended");
						wait();
						System.out.println( threadName +": is working");
					}
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void start(){
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
	
	public void suspend(){
		suspended = true;
	}
	
	public synchronized void resume(){
		suspended = false;
		notify();
	}


	

}
