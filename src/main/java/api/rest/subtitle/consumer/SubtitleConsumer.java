package api.rest.subtitle.consumer;

import api.rest.subtitle.command.SubtitleCommand;
import api.rest.subtitle.exception.SubtitleException;

public class SubtitleConsumer implements Consumer {

	private SubtitleCommand command;
	
	public SubtitleConsumer(SubtitleCommand command) {
		this.command=command;
	}
	
	/* (non-Javadoc)
	 * @see api.rest.subtitle.consumer.Consumer#consume()
	 */
	@Override
	public Object consume() throws SubtitleException {
		return this.command.execute();		
	}
	
	

}
