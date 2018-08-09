/**
 * 
 */
package api.rest.subtitle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author peremanent
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MalformedOpenSubtitleURL extends SubtitleException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -994294358407885891L;

	/**
	 * 
	 */
	public MalformedOpenSubtitleURL() {
	}

	/**
	 * @param message
	 */
	public MalformedOpenSubtitleURL(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public MalformedOpenSubtitleURL(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public MalformedOpenSubtitleURL(String message, Throwable cause) {
		super(message, cause);
	}

}
