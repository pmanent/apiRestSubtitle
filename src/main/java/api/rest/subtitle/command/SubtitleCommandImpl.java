/**
 * 
 */
package api.rest.subtitle.command;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.xmlrpc.XmlRpcException;

import com.github.wtekiela.opensub4j.api.OpenSubtitlesClient;
import com.github.wtekiela.opensub4j.impl.OpenSubtitlesClientImpl;

import api.rest.subtitle.SubtitleProperties;
import api.rest.subtitle.exception.MalformedOpenSubtitleURL;
import api.rest.subtitle.exception.SubtitleException;
import api.rest.subtitle.exception.SubtitleXmlRpcException;

/**
 * @author peremanent
 *
 */
public abstract class SubtitleCommandImpl implements SubtitleCommand {

	protected OpenSubtitlesClient osClient;
	private String username;
	private String password;
	private String language;
	private String useragent;

	/**
	 * 
	 */
	public SubtitleCommandImpl(String username, String password, String language, String useragent) {
		this.username=username;
		this.password=password;
		this.language=language;
		this.useragent=useragent;
	}
	/* (non-Javadoc)
	 * @see api.rest.subtitle.command.SubtitleCommand#execute()
	 */
	@Override
	public Object execute() throws SubtitleException {
		this.createOpenSubtitlesClient();
		this.doLogin();
		Object result = this.command();
		this.doLogout();
		return result;
	}

	public void createOpenSubtitlesClient() throws SubtitleException{
		URL serverUrl;
		try {
			String protocol = SubtitleProperties.getInstance().getProperty("PROTOCOL");
			String host = SubtitleProperties.getInstance().getProperty("HOST");
			Integer port = Integer.valueOf(SubtitleProperties.getInstance().getProperty("PORT"));
			String pathFile = SubtitleProperties.getInstance().getProperty("PATH_FILE");
			serverUrl = new URL(protocol, host, port,pathFile);
			osClient = new OpenSubtitlesClientImpl(serverUrl);
		} catch (MalformedURLException e) {
			MalformedOpenSubtitleURL actualException=new MalformedOpenSubtitleURL(e);
			throw actualException;
		}
		
	}

	public void doLogin() {
		try {
			osClient.login(this.username, this.password, this.language, this.useragent);
		} catch (XmlRpcException e) {
			SubtitleXmlRpcException actualException=new SubtitleXmlRpcException(e);
			throw actualException;
		}
	}

	public void doLogout() {
		try {
			osClient.logout();
		} catch (XmlRpcException e) {
			SubtitleXmlRpcException actualException=new SubtitleXmlRpcException(e);
			throw actualException;
		}
	}

	public abstract Object command() throws SubtitleException;
}
