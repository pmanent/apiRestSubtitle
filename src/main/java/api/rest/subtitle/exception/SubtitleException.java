/**
 * 
 */
package api.rest.subtitle.exception;

import javax.validation.ValidationException;

/**
 * @author peremanent
 *
 */
public abstract class SubtitleException extends ValidationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public SubtitleException() {
	}

	/**
	 * @param message
	 */
	public SubtitleException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public SubtitleException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SubtitleException(String message, Throwable cause) {
		super(message, cause);
	}

}
