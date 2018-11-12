/**
 * 
 */
package api.rest.subtitle.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author peremanent
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SubtitleIOException extends SubtitleException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public SubtitleIOException() {
	}
	
	public SubtitleIOException(IOException e) {
		super(e);
	}

}
