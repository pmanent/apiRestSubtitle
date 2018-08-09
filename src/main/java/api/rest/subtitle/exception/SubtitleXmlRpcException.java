/**
 * 
 */
package api.rest.subtitle.exception;

import org.apache.xmlrpc.XmlRpcException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author peremanent
 *
 */
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class SubtitleXmlRpcException extends SubtitleException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2166336083778897454L;

	/**
	 * 
	 */
	public SubtitleXmlRpcException() {
	}

	public SubtitleXmlRpcException(XmlRpcException e) {
		super(e);
	}

}
