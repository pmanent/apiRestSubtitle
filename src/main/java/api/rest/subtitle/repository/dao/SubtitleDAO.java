package api.rest.subtitle.repository.dao;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.wtekiela.opensub4j.response.SubtitleFile;
import com.github.wtekiela.opensub4j.response.SubtitleInfo;

import api.rest.subtitle.SubtitleProperties;
import api.rest.subtitle.command.DownloadSubtitleCommand;
import api.rest.subtitle.command.DownloadSubtitleFileCommand;
import api.rest.subtitle.command.SearchSubtitleCommand;
import api.rest.subtitle.consumer.Consumer;
import api.rest.subtitle.consumer.SubtitleConsumer;

@Repository
public class SubtitleDAO {
	private String username = "";
	private String password = "";
	private String lang = "";
	private String userAgent = "";
	
	public SubtitleDAO() {
		username = SubtitleProperties.getInstance().getProperty("OPENSUBTITLES_USERNAME");
		password = SubtitleProperties.getInstance().getProperty("OPENSUBTITLES_PASSWORD");
		lang = SubtitleProperties.getInstance().getProperty("LETTER_LANGUAGE_CODE");
		userAgent = SubtitleProperties.getInstance().getProperty("USER_AGENT");
	}
	
	public List<SubtitleInfo> searchSubtitle(String selectedQuery,String selectedSeason,String selectedEpisode,String selectedLanguage){
		
		List<SubtitleInfo> info = new ArrayList<SubtitleInfo>();
		SearchSubtitleCommand command= new SearchSubtitleCommand(username,password,lang,userAgent);
		command.setSelectedQuery(selectedQuery);
		command.setSelectedSeason(selectedSeason);
		command.setSelectedEpisode(selectedEpisode);
		command.setSelectedLanguage(selectedLanguage);
		
		Consumer subtitleConsumer=new SubtitleConsumer(command);
		
		info = (List<SubtitleInfo>)subtitleConsumer.consume();
		
		return info;
	}

	public List<SubtitleFile> downloadSubtitle(Integer subtitleFileID){
		
		List<SubtitleFile> info = new ArrayList<SubtitleFile>();
		
		DownloadSubtitleCommand command= new DownloadSubtitleCommand(username,password,lang,userAgent);
		
		command.setSubtitleFileID(subtitleFileID);
		
		Consumer subtitleConsumer=new SubtitleConsumer(command);
		
		info = (List<SubtitleFile>)subtitleConsumer.consume();
		
		return info;
	}
	
	public InputStream downloadFile(Integer subtitleFileID, String fileName) {
		
		DownloadSubtitleFileCommand command = new DownloadSubtitleFileCommand(username,password,lang,userAgent);
		
		command.setSubtitleFileID(subtitleFileID);
		command.setFileName(fileName);
		
		Consumer subtitleConsumer=new SubtitleConsumer(command);
		
		InputStream fileInputStream =  (InputStream)subtitleConsumer.consume();
		
		return fileInputStream;
	}
}
