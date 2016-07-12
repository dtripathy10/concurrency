import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Creator;

public class CustomActor extends UntypedActor {

	LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	@Override
	public void onReceive(Object message) throws Exception {
		System.out.println(" I am also called boss!!");
		if (message instanceof DTO) {
			log.info("Received String message: {}", message);
			Thread.sleep(1000);
			// getSender().tell(message, getSelf());
		} else {
			unhandled(message);
		}
	}

	/**
	 * Create Props for an actor of this type.
	 * 
	 * @param magicNumber
	 *            The magic number to be passed to this actor’s constructor.
	 * @return a Props for creating this actor, which can then be further
	 *         configured (e.g. calling `.withDispatcher()` on it)
	 */
	public static Props props() {
		return Props.create(new Creator<CustomActor>() {
			private static final long serialVersionUID = 1L;

			@Override
			public CustomActor create() throws Exception {
				return new CustomActor();
			}
		});
	}

	final int magicNumber;

	public CustomActor() {
		this.magicNumber = 17;
		System.out.println("I am called");
	}

}
