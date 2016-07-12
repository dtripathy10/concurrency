import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Test {

	public static void main(String[] args) {

		// ActorSystem is a heavy object: create only one per application
		final ActorSystem system = ActorSystem.create("MySystem");
		final ActorRef listener1 = system.actorOf(Props.create(CustomActor.class), "listener1");
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 10; i++) {
			DTO dto = new DTO();
			listener1.tell(dto, null);
			System.out.println("Executor Done !!");

		}

		executorService.shutdown();

	}

}
