/**
 * 
 */
package api.rest.subtitle.command;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import com.github.wtekiela.opensub4j.response.SubtitleFile;

import api.rest.subtitle.exception.SubtitleException;
import api.rest.subtitle.exception.SubtitleIOException;
import api.rest.subtitle.utils.FileUtils;

/**
 * @author peremanent
 *
 */
public class DownloadSubtitleFileCommand extends SubtitleCommandImpl {
	
	private Integer subtitleFileID;
	private String fileName;
	
	private DownloadSubtitleCommand downloadSubtitleCommand;
	
	/**
	 * @param username
	 * @param password
	 * @param language
	 * @param useragent
	 */
	public DownloadSubtitleFileCommand(String username, String password, String language, String useragent) {
		super(username, password, language, useragent);
		this.downloadSubtitleCommand = new DownloadSubtitleCommand(username, password, language, useragent);
		
	}

	/**
	 * 
	 * @see api.rest.subtitle.command.SubtitleCommandImpl#command()
	 */
	@Override
	public Object command() throws SubtitleException {
		

        InputStream inputStream = null;
        
		List<SubtitleFile> fileList = this.downloadSubsititle();
		if(fileList != null) {
			Iterator<SubtitleFile> iterator = fileList.iterator();
			while(iterator.hasNext()){
				SubtitleFile subtitleFileInfo = iterator.next();
				String content = subtitleFileInfo.getContent().getContent();
				
				File temp;
				try {
					
					temp = FileUtils.generateTempFile(fileName, content);
					inputStream = new FileInputStream(temp);
					
				} catch (IOException e) {
					SubtitleIOException actualException=new SubtitleIOException(e);
					throw actualException;
				}
				
			}
			
		}
		
		return inputStream;
	}
	
	
	private List<SubtitleFile> downloadSubsititle() {
		List<SubtitleFile> fileList=null;
		this.downloadSubtitleCommand.setSubtitleFileID(subtitleFileID);
		
		fileList = (List<SubtitleFile>)this.downloadSubtitleCommand.execute();
		
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

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
