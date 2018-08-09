/**
 * 
 */
package api.rest.subtitle.command;

import java.util.List;

import org.apache.xmlrpc.XmlRpcException;

import com.github.wtekiela.opensub4j.response.SubtitleInfo;

import api.rest.subtitle.exception.SubtitleException;
import api.rest.subtitle.exception.SubtitleXmlRpcException;

/**
 * @author peremanent
 *
 */
public class SearchSubtitleCommand extends SubtitleCommandImpl {

	private String selectedLanguage="";
	private String selectedSeason="";
	private String selectedEpisode="";
	private String selectedQuery="";

	public SearchSubtitleCommand(String username, String password, String language, String useragent) {
		super(username, password, language, useragent);
	}

	@Override
	public Object command() throws SubtitleException{
		List<SubtitleInfo> info=null;
		try {
			info = super.osClient.searchSubtitles(selectedLanguage, selectedQuery, selectedSeason,selectedEpisode);
		} catch (XmlRpcException e) {
			SubtitleXmlRpcException actualException=new SubtitleXmlRpcException(e);
			throw actualException;
		}
		return info;
	}

	public String getSelectedLanguage() {
		return selectedLanguage;
	}

	public void setSelectedLanguage(String selectedLanguage) {
		this.selectedLanguage = selectedLanguage;
	}

	public String getSelectedSeason() {
		return selectedSeason;
	}

	public void setSelectedSeason(String selectedSeason) {
		this.selectedSeason = selectedSeason;
	}

	public String getSelectedEpisode() {
		return selectedEpisode;
	}

	public void setSelectedEpisode(String selectedEpisode) {
		this.selectedEpisode = selectedEpisode;
	}

	public String getSelectedQuery() {
		return selectedQuery;
	}

	public void setSelectedQuery(String selectedQuery) {
		this.selectedQuery = selectedQuery;
	}

}
