/**
 * 
 */
package api.rest.subtitle.command;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.github.wtekiela.opensub4j.response.SubtitleInfo;

import api.rest.subtitle.exception.SubtitleXmlRpcException;

/**
 * @author peremanent
 *
 */
public class SubtitleCommandTest {

	/**
	 * 
	 */
	public SubtitleCommandTest() {
	}
	
	@Test
	public void loadProtocolKeyFromSubtitlesPropertiesTest(){
		List<SubtitleInfo> info=null;
		SearchSubtitleCommand command=new SearchSubtitleCommand("summy","dumyTest","es","NoTemporaryUserAgent");
		
		command.setSelectedQuery("Quuery");
		command.setSelectedSeason("1");
		command.setSelectedEpisode("1");
		command.setSelectedLanguage("es");
		Exception actualexception=null;
		try {
			info = (List<SubtitleInfo>)command.execute();
		} catch (SubtitleXmlRpcException e) {
			actualexception = e;
		}catch (Exception ex) {
			actualexception = ex;
		}
		
		Assert.assertNotNull("Protocol must be https",actualexception);
	}

}
