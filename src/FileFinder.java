import java.io.*;
import java.util.*;


public class FileFinder {

	
	ArrayList<String> filesfound;
	
	
	FileFinder(String path, String extension){
		filesfound = new ArrayList<String>();
		File catalog = new File(path);
		FindFile(catalog,extension);
	}
		

	void FindFile(File catalog, String extension){
		
		// dodaæ sprawdzenie kropki
		
		
		File[] list;
		list=catalog.listFiles();
	
			for(File file : list)
			{
				if (file.isDirectory()){
					FindFile(file, extension);
				}
				else{
					
					if (file.getName().contains(extension)){			
					filesfound.add(file.getAbsolutePath());
					}
				}			
			}		
	}
	

}
