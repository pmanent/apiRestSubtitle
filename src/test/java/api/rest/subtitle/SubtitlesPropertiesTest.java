/**
 * 
 */
package api.rest.subtitle;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;
/**
 * @author peremanent
 *
 */
public class SubtitlesPropertiesTest {
	
	@Test
	public void loadSubtitlesPropertiesTest(){
		Properties instance = SubtitleProperties.getInstance();
		Assert.assertTrue("Instance must be not null",instance != null);
	}
	
	
	@Test
	public void loadProtocolKeyFromSubtitlesPropertiesTest(){
		Properties instance = SubtitleProperties.getInstance();
		String protocol=instance.getProperty("PROTOCOL");
		Assert.assertEquals("Protocol must be https","https",protocol);
	}
	@Test
	public void loadHostKeyFromSubtitlesPropertiesTest(){
		Properties instance = SubtitleProperties.getInstance();
		String host=instance.getProperty("HOST");
		Assert.assertEquals("HOST is incorrect","api.opensubtitles.org",host);
	}
	@Test
	public void loadPortKeyFromSubtitlesPropertiesTest(){
		Properties instance = SubtitleProperties.getInstance();
		String port=instance.getProperty("PORT");
		Assert.assertEquals("PORT is incorrect","443",port);
	}
	@Test
	public void loadPathFileKeyFromSubtitlesPropertiesTest(){
		Properties instance = SubtitleProperties.getInstance();
		String path=instance.getProperty("PATH_FILE");
		Assert.assertEquals("PATH_FILE is incorrect","/xml-rpc",path);
	}
	@Test
	public void loadUsernameKeyFromSubtitlesPropertiesTest(){
		Properties instance = SubtitleProperties.getInstance();
		String username=instance.getProperty("OPENSUBTITLES_USERNAME");
		Assert.assertNotNull("OPENSUBTITLES_USERNAME must be not null", username);
	}
	@Test
	public void loadPasswordKeyFromSubtitlesPropertiesTest(){
		Properties instance = SubtitleProperties.getInstance();
		String password=instance.getProperty("OPENSUBTITLES_PASSWORD");
		Assert.assertNotNull("OPENSUBTITLES_PASSWORD must be not null", password);
	}

	@Test
	public void loadLanguageKeyFromSubtitlesPropertiesTest(){
		Properties instance = SubtitleProperties.getInstance();
		String language=instance.getProperty("LETTER_LANGUAGE_CODE");
		Assert.assertNotNull("LETTER_LANGUAGE_CODE must be not null", language);
	}
	@Test
	public void loadUserAgentKeyFromSubtitlesPropertiesTest(){
		Properties instance = SubtitleProperties.getInstance();
		String userAgent=instance.getProperty("USER_AGENT");
		Assert.assertNotNull("USER_AGENT must be not null", userAgent);
	}
}
