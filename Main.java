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
		//Print Header
		String header = "|------------------------ " + path + " ----------------------|";
		System.out.println("\u001B[36m"+header + "\u001B[0m");

		byte index = 0;
		int len = 0;
		//Print files information
		for(File f : files){
			//Print Table border
			System.out.print("\u001B[36m| \u001B[0m");
			//Check if object is a file or folder
			if(f.isFile()){
				//Get file size (byte)
				size = f.length();
				//Convert units
				while(size >= 1024){
					size /= 1024;
					index++;
				}
				String temp = f.getName() + "  \u001B[33m" + df.format(size) + " " + units[index] + "\u001B[0m";
				System.out.print(temp);
				len = temp.length() - 9;
			}else{
				System.out.print("\u001B[35m" + f.getName() + "\u001B[0m");
				len = f.getName().length();
			}
			index = 0;
			for(int i = 0 ; i < header.length() - len - 3 ; i++){
				System.out.print(" ");
			}
			System.out.println("\u001B[36m|\u001B[0m");
			drawLine(header.length());
		}
		
	}
	private static void drawLine(int length){
		System.out.print("\u001B[36m");
		for(int i = 0 ; i < length ; i++){
			if(i == 0 || i == length - 1){
				System.out.print("|");
			}else{
				System.out.print("-");
			}
		}
		System.out.println("\u001B[0m");
	}
}
