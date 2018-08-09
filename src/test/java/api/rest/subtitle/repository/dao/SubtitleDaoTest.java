/**
 * 
 */
package api.rest.subtitle.repository.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.wtekiela.opensub4j.response.SubtitleFile;
import com.github.wtekiela.opensub4j.response.SubtitleInfo;
;

/**
 * @author peremanent
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SubtitleDaoTest {

	@Autowired
	private SubtitleDAO subtitleDao;
	
	@Test
	public void searchSubtitle(){
		List<SubtitleInfo> info=subtitleDao.searchSubtitle("Final Space","1","1","eng");
		Assert.assertTrue("Info must be not null", info!=null);
	}
	@Test
	public void downloadSubtitle(){
		Integer subtitleFileID=1955843243;
		List<SubtitleFile> info = subtitleDao.downloadSubtitle(subtitleFileID);
		Assert.assertTrue("Info must be not null", info!=null);
	}
	

	
}
