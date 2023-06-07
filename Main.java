import java.io.File;
import java.text.DecimalFormat;

public class Main{
	public static void main(String[] args){
		//Define path
		final String path = System.getProperty("user.dir");
		//Define a array for memory units
		final String[] units = new String[]{"Bytes" , "KB" , "MB" , "GB"};
		//Get list of files
		File dir = new File(path);
		File[] files = dir.listFiles();
		//Define a variable for size of files
		double size = 0;
		//Define DecimalFormat for formating size value
		DecimalFormat df = new DecimalFormat("##.#");

		byte index = 0;
		//Print files information
		for(File f : files){
			//Check if object is a file or folder
			if(f.isFile()){
				//Get file size (byte)
				size = f.length();
				//Convert units
				while(size >= 1024){
					size /= 1024;
					index++;
				}
				System.out.println(f.getName() + "  \u001B[33m" + df.format(size) + " " + units[index] + "\u001B[0m");
			}else{
				System.out.println("\u001B[35m" + f.getName() + "\u001B[0m");
			}
			index = 0;
		}
		
	}
}
