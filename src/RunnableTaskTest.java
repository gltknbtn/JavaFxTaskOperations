import javafx.application.Application;
import javafx.stage.Stage;


public class RunnableTaskTest extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		RunnableTask r1 = new RunnableTask("thread-1");
		r1.start();
		
		RunnableTask r2 = new RunnableTask("thread-2");
		r2.start();
		
		r1.suspend();
		Thread.sleep(10000);
		r1.resume();
		
		Thread.sleep(10000);
		r2.suspend();
		
		Thread.sleep(10000);
		r2.resume();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
