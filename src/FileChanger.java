import java.io.*;
import java.util.*;


public class FileChanger {

	
	//KOSTRUKTOR
	FileChanger(){
		
		
		
	}
	
	boolean CheckFile(String s, String changefrom){
		int flag;
		flag=0;
		try {
		
			BufferedReader reader = new BufferedReader(new FileReader(new File(s)));
			String line;
			line = reader.readLine();
			while (line != null){
					if (line.contains(changefrom)){
						flag=1;
					}
					line = reader.readLine();
			}
			
			
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (flag==1){
			return true;
			
		}
		else
			return false;
		
	}
	
	void ChangeFile(ArrayList<String> foundfiles, String changefrom, String changeto){
		
		for (String s: foundfiles){                  //pêtla po wszystkich znalezionych plikach
			
			if(CheckFile(s,changefrom)){
			
			try {
				
				ArrayList<String> newfile = new ArrayList<String>();           //lista linijek nowego pliku
				
				BufferedReader reader = new BufferedReader(new FileReader(new File(s)));         //zczytywanie i zamienianie w nowym newfile
				String line;
				line = reader.readLine();
				while (line != null){
						line=line.replaceAll(changefrom, changeto);
						System.out.println(line);
					newfile.add(line);
					line = reader.readLine();
				}
				
				
				
				PrintWriter writer= new PrintWriter(new File(s));                     //zapisywanie na miejsce starego pliku
				 for (String newline : newfile){
					 
					 writer.println(newline);
				 }
				 writer.close();
				 reader.close();
			
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			}
			
		}
			
	}
		
}
	
	
	

	
	

