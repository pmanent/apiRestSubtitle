/**
 * 
 */
package api.rest.subtitle.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.wtekiela.opensub4j.response.SubtitleFile;

import api.rest.subtitle.repository.dao.SubtitleDAO;
import api.rest.subtitle.utils.GsonUtils;


/**
 * @author peremanent
 *
 */

@CrossOrigin(origins = "*")
@RestController
public class SubtitleController {
	@Autowired
	private SubtitleDAO subtitleDAO;
	/**
	 * 
	 */
	public SubtitleController() {
	}

	@RequestMapping(value = "/searchSubtitles", method = RequestMethod.GET, produces = "application/json")
	public String searchSubtitles(@RequestParam Map<String, String> allRequestParams){
		
		String selectedQuery = allRequestParams.get("query");
		String selectedSeason = allRequestParams.get("season");
		String selectedEpisode = allRequestParams.get("episode");
		String selectedLanguage = allRequestParams.get("language");
		
		return GsonUtils.toJson(subtitleDAO.searchSubtitle(selectedQuery,selectedSeason,selectedEpisode,selectedLanguage));
	}
	
	@RequestMapping(value = "/donwloadSubtitle", method = RequestMethod.GET, produces = "application/json")
	public String donwloadSubtitle(@RequestParam Map<String, String> allRequestParams){
		
		String subtitleFileID = allRequestParams.get("id");
		
		List<SubtitleFile> info = subtitleDAO.downloadSubtitle(Integer.valueOf(subtitleFileID));
		
		String contentFile="Empty File";
		if(info!=null){
			Iterator<SubtitleFile> iterator = info.iterator();
			while(iterator.hasNext()){
				SubtitleFile subtitleFileInfo = iterator.next();
				
				contentFile = subtitleFileInfo.getContent().getContent();
				
			}
			
		}
		return GsonUtils.toJson(contentFile);
	}
	
	@RequestMapping(value = "/donwloadFile/{id}", method = RequestMethod.GET)
	public void donwloadFile(
	        @PathVariable("id") String subtitleFileID,
	        @RequestParam Map<String, String> allRequestParams,
	        HttpServletResponse response) throws IOException{
		
		String subtitleFileName = allRequestParams.get("fileName").replaceAll(" ", "_");
		

        InputStream inputStream = subtitleDAO.downloadFile(Integer.valueOf(subtitleFileID), subtitleFileName);
        
        response.setContentType("application/force-download");
        response.setHeader("Content-Disposition", "attachment; filename="+subtitleFileName); 
        
        IOUtils.copy(inputStream, response.getOutputStream());
        
        response.flushBuffer();
        inputStream.close();		
	}

}
