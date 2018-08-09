/**
 * 
 */
package api.rest.subtitle;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import api.rest.subtitle.utils.StringUtils;

/**
 * @author peremanent
 *
 */
public class SubtitleProperties extends Properties {

	/**
     * use serialVersionUID from JDK 1.1.X for interoperability
     */
	private static final long serialVersionUID = 1L;
	
	private static SubtitleProperties instance = null;

	/**
	 * Creates an empty property list with no default values.
	 */
	private SubtitleProperties() {
		
		InputStream input = null;
		input = StringUtils.class.getResourceAsStream("/subtitles.properties");
		
		try {
			this.load(input);
		} catch (IOException e) {
			
		}
	}

	/**
	 * @param defaults
	 */
	public SubtitleProperties(Properties defaults) {
		super(defaults);
	}
	
	public static SubtitleProperties getInstance(){
		if(instance == null){
			synchronized(SubtitleProperties.class){
				instance = new SubtitleProperties();
			}
		}
		return instance;
	}

}
