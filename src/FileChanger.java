import java.io.*;
import java.util.*;


public class FileChanger {

	int howmanyfiles;

	FileChanger(){
		
		howmanyfiles=0;
		
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
		
		for (String s: foundfiles){                 
			if(CheckFile(s,changefrom)){
			howmanyfiles=howmanyfiles+1;
			try {
				
				ArrayList<String> newfile = new ArrayList<String>();       
				
				BufferedReader reader = new BufferedReader(new FileReader(new File(s)));   
				String line;
				line = reader.readLine();
				while (line != null){
					line=line.replaceAll(changefrom, changeto);
					newfile.add(line);
					line = reader.readLine();
				}
				
				
				
				PrintWriter writer= new PrintWriter(new File(s));                    
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
	
	
	

	
	

