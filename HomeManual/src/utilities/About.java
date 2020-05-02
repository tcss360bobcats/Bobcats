package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
	private static String[] authors = {"Darryl James", "Andrew Lim", "Tyke Sykes", "Anthony Nguyen"};
	
	
	/**
	 * Run this to update the current version of the project. 
	 * @param args Command Line Arguments (not utilized) 
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		updateVersion();
	}
	
	/**
	 * Updates the version file to contain the current date. 
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public static void updateVersion() throws FileNotFoundException, UnsupportedEncodingException {
		String updateDate = LocalDate.now().toString();
		PrintWriter writer = new PrintWriter("files/version.txt", "UTF-8");
		writer.println(updateDate);
		System.out.println(updateDate);
		writer.close();
	}
	
	/**
	 * Reads the version file and returns the last date the project was updated. 
	 * @return current version of project
	 * @throws IOException
	 */
	public static String getVersion() throws IOException {
		Scanner file = new Scanner(new File("files/version.txt"));
		String version = file.nextLine();
		file.close();
		return version;
	}
	
	/**
	 * Returns the authors of the project. 
	 * @return authors of project 
	 */
	public static String[] getAuthors() {
		return authors;
	}
	

	/**
	 * testing github 
	 */
	public void test2() {
		System.out.println("test");
  }
	public static void test() {
		System.out.println("hello world");

	}
	
}
