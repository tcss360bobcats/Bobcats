package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * About contains and updates information about the project. 
 * 
 * @author Anthony Nguyen
 * @author Tyke Sykes
 * @version May 5, 2020 
 *
 */
public class About {

	/**	 Authors of the project	 */
	private static String[] authors = {"Darryl James", "Andrew Lim",
									   "Tyke Sykes", "Anthony Nguyen"};
	
	/**
	 * Run this to update the current version of the project. 
	 * @param args Command Line Arguments (not utilized) 
	 */
	public static void main(String[] args) {
		updateVersion();
	}
	
	/**
	 * Updates the version file to contain the current date. 
	 * @author Anthony
	 */
	public static void updateVersion() {
		String updateDate = LocalDate.now().toString();
		PrintWriter writer = null;
		try {
			//"files/version.txt"
			writer = new PrintWriter("./res/files/version.txt");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		writer.println(updateDate);
		writer.close();
		System.out.println(updateDate);
	}
	
	/**
	 * Reads the version file and returns the last date the project was updated. 
	 * @author Anthony
	 * @return current version of project
	 */
	public static String getVersion() {
		Scanner file = null;
		try {
			file = new Scanner(new File("./res/files/version.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String version = file.nextLine();
		System.out.println(version);
		file.close();
		return version;
	}
	
	/**
	 * Returns the authors of the project. 
	 * @author Anthony 
	 * @return authors of project 
	 */
	public static String[] getAuthors() {
		return authors;
	}
		
}
