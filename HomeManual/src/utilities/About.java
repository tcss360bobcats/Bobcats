package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * 
 * @author Anthony Nguyen
 * @version May 5, 2020 
 *
 */
public class About {

	private static String[] authors = {"Darryl James", "Andrew Lim", "Tyke Sykes", "Anthony Nguyen"};
	
	
	/**
	 * Run this to update the current version of the project. 
	 * @param args
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		updateVersion();
	}
	
	
	public static void updateVersion() throws FileNotFoundException, UnsupportedEncodingException {
		String updateDate = LocalDate.now().toString();
		PrintWriter writer = new PrintWriter("files/version.txt", "UTF-8");
		writer.println(updateDate);
		System.out.println(updateDate);
		writer.close();
	}
	
	public static String getVersion() throws IOException {
		Scanner file = new Scanner(new File("files/version.txt"));
		String version = file.nextLine();
		file.close();
		return version;
	}
	
	public static String[] getAuthors() {
		return authors;
	}
	
	public static void test() {
		System.out.println("hello world");
	}
	
}
