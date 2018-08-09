/**
 * 
 */
package api.rest.subtitle.command;

import java.util.List;

import org.apache.xmlrpc.XmlRpcException;

import com.github.wtekiela.opensub4j.response.SubtitleFile;

import api.rest.subtitle.exception.SubtitleException;
import api.rest.subtitle.exception.SubtitleXmlRpcException;

/**
 * @author peremanent
 *
 */
public class DownloadSubtitleCommand extends SubtitleCommandImpl {

	private Integer subtitleFileID;
	/**
	 * @param username
	 * @param password
	 * @param language
	 * @param useragent
	 */
	public DownloadSubtitleCommand(String username, String password, String language, String useragent) {
		super(username, password, language, useragent);
	}

	/* (non-Javadoc)
	 * @see api.rest.subtitle.command.SubtitleCommandImpl#command()
	 */
	@Override
	public Object command() throws SubtitleException {
		List<SubtitleFile> fileList=null;
		try {
			fileList = osClient.downloadSubtitles(this.subtitleFileID);
		} catch (XmlRpcException e) {
			SubtitleXmlRpcException actualException=new SubtitleXmlRpcException(e);
			throw actualException;
		}
		return fileList;
	}

	/**
	 * @return the subtitleFileID
	 */
	public Integer getSubtitleFileID() {
		return subtitleFileID;
	}

	/**
	 * @param subtitleFileID the subtitleFileID to set
	 */
	public void setSubtitleFileID(Integer subtitleFileID) {
		this.subtitleFileID = subtitleFileID;
	}

}
