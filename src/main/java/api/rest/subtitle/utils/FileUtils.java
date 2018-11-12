
package api.rest.subtitle.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileUtils {

	public FileUtils() {
	}
	
	public static File generateTempFile(String fileName, String text) throws IOException {
		
		String name = fileName.substring(0,fileName.length()-4);
		
		String extension = fileName.substring(fileName.length()-3, fileName.length());
        // Create temp file.
        File temp = File.createTempFile(name, extension );

        // Delete temp file when program exits.
        temp.deleteOnExit();

        // Write to temp file
        BufferedWriter out = new BufferedWriter(new FileWriter(temp));
        out.write(text);
        out.close();
		return temp;
	}

}
