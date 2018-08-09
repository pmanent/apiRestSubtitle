package api.rest.subtitle.command;

import api.rest.subtitle.exception.SubtitleException;

public interface SubtitleCommand {

	public Object execute() throws SubtitleException;

}