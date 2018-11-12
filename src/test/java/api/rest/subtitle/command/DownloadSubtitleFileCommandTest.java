package api.rest.subtitle.command;


import org.junit.Test;


public class DownloadSubtitleFileCommandTest {

	public DownloadSubtitleFileCommandTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void downloadSubtitleFileCommandTest(){
		DownloadSubtitleFileCommand command = new DownloadSubtitleFileCommand("dummy","dummy","eng", "TemporaryUserAgent");
		command.setSubtitleFileID(1955842718);
		
		command.execute();
		
	}

}
