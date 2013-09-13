import java.io.*;
import java.util.*;


public class FileFinder {

	
	ArrayList<String> filesfound;
	int exists;
	
	FileFinder(String path, String extension){
		exists=1;
		filesfound = new ArrayList<String>();
		File catalog = new File(path);
		if (catalog.exists()){
			FindFile(catalog,extension);
		}
		else{
			exists=0;
		}
	}
		

	void FindFile(File catalog, String extension){
		
		if(!extension.startsWith(".")){
			extension="."+extension;
		}
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
