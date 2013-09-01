import java.io.*;



public class Changer {

	public static void main(String[] args) {

		
		FileFinder tester = new FileFinder();
		File cat= new File("C:/test");
		String ext = new String(".odt");
	
		
		tester.FindFile(cat,ext);
	//	tester.wypisz();
		
		
		FileChanger test = new FileChanger();
		
		test.ChangeFile(tester.filesfound, "japa", "beczka");
	}

}
