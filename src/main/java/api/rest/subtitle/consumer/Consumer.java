package api.rest.subtitle.consumer;

import api.rest.subtitle.exception.SubtitleException;

public interface Consumer {

	Object consume() throws SubtitleException;

}