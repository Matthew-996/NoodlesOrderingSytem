import java.io.File;

/**
 * This class is a class to get the file path, which store a static method to be used by other part
 * @author Bailin Rong
 */
public class FilePathGet {
	
	 /**
		 * get corresponding file poisiton
		 * @param filename the name of file
		 * @return the path to the position of file in the computer
		 * 
		 */
	public static String getpath(String filename)
	{
		File directory = new File("File");
		String path = directory.getAbsolutePath();
		path = path +"\\"+filename;
		return path;
	}	
}
