import java.io.*;


public class FileFinder {

	File sciezka;
	
	FileFinder(String s){
		sciezka = new File(s);
	}
	
	File FindFile(){
		
		return sciezka;
	}
	
}
