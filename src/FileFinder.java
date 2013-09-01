import java.io.*;
import java.util.*;


public class FileFinder {

	
	ArrayList<String> filesfound;
	
	
	// KONTSTRUKTOR
	FileFinder(){
		filesfound = new ArrayList<String>();

	}
		
	
	// FindFile dodaje do pustego atrybutu filesfound œcie¿ki znalezionych plików
	
	void FindFile(File catalog, String extension){
		
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
	
	
	
	// Metoda Wypisz tymczaso - u³atwia pracê
	void wypisz(){
		
		for (String s: filesfound){
			System.out.println(s);
		}
	}
	

}
