/**
 * Isaac, Eric
 * 
 * The Manager class... 
 *  stores a list of Media objects, 
 *  can load Media objects from files, 
 *  creates/updates Media files,
 * 	can add Media objects to its Media list,	
 * 	can find all Media objects that relate to a specific title and returns the list,
 * 	can rent Media object based on the id (updates rental status, updates the file, returns the rental fee)
 */

import java.util.ArrayList;

import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import java.io.IOException;
import java.io.FileWriter;

import java.io.FileReader;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class Manager {
	
	//Create a new ArrayList of Media objects
	public static ArrayList<Media> titleMatchList1 = new ArrayList<>();
	
	//Formatter which will be used to output text to the file
	private static Formatter output;
	
	//FileWriter object which will be used as a file stream to append
	//Media Objects to the file
	private static FileWriter fStream;
	
	//Scanner object which will be used to read data from the file
	private static Scanner input;
	
	//Create all Media objects for access outside the loop
	private static MovieDVD movie1 = null;
	private static MusicCD music1 = null;
	private static Ebook book1 = null;
	
	
	
	//method to create and update media files with specific Media subclass types
	//Add an Ebook to the Media File
	public static void addEbookToFile(Ebook ebook1)
	{
		//Try to open the file, and write to it
		try
		{	
			fStream = new FileWriter("media_file_1.txt", true);		//This statement makes a FileWriter for appending
			output = new Formatter(fStream);				//This statement opens the file
			
			/**  THIS NEEDS WORK *****
			//Read the contents of the file with a Scanner, 
			//If the ebook ID already exists in the file,
			//Do NOT add it to the file, but send a message
			//to the user that the Ebook ID already exists
			input = new Scanner(new FileReader("media_file_1.txt"));
			while(input.hasNext())
			{
				if(ebook1.getId() == 1234)
				{
					System.out.println("The ID you entered already exists");
					return;
				}
				
			}*/
			
			
			//Write (or append) the ebook contents to the file, then add a new line
			output.format("%d %s %d %d%n", ebook1.getId(), ebook1.getTitle(), ebook1.getYear(),
					ebook1.getNumChapters());
			
			//Flush or write the FileWriter to the file
			fStream.flush();
			
		}
		catch(SecurityException securityException)
		{
			System.err.println("Write permission denied. Terminating");
			System.exit(1); 	//Terminate the program
		}
		catch(FileNotFoundException fileNotFoundException)
		{
			System.err.println("Error opening file. Terminating.");
			System.exit(1); 	//Terminate the program
		}
		catch(IOException inputOutputException)
		{
			System.err.println("Input/Output Exception. Terminating");
			System.exit(1);
		}
		catch(FormatterClosedException formatterClosedException)
		{
			System.err.println("Error writing to file. Terminating");
			System.exit(1);
		}
		catch(NoSuchElementException elementException)
		{
			System.err.println("Invalid input for Ebook...");
			System.exit(1);
		}
		
		//close the file
		if(output != null)
			output.close();
	}
	
	
	//Add a MovieDVD to the Media file
	public static void addMovieDVDToFile(MovieDVD movie1)
	{
		//Try to open the file, and write to it
		try
		{	
			fStream = new FileWriter("media_file_1.txt", true);		//This statement makes a FileWriter for appending
			output = new Formatter(fStream);				//This statement opens the file
					
			/**  THIS NEEDS WORK *****
			//Read the contents of the file with a Scanner, 
			//If the ebook ID already exists in the file,
			//Do NOT add it to the file, but send a message
			//to the user that the Ebook ID already exists
			input = new Scanner(new FileReader("media_file_1.txt"));
			while(input.hasNext())
			{
				if(movie1.getId() == 1234)
				{
					System.out.println("The ID you entered already exists");
					return;
				}
						
			}*/
					
					
			//Write (or append) the ebook contents to the file, then add a new line
			output.format("%d %s %d %.2f%n", movie1.getId(), movie1.getTitle(), movie1.getYear(),
					movie1.getSize());
					
			//Flush or write the FileWriter to the file
			fStream.flush();
					
		}
		catch(SecurityException securityException)
		{
			System.err.println("Write permission denied. Terminating");
			System.exit(1); 	//Terminate the program
		}
		catch(FileNotFoundException fileNotFoundException)
		{
			System.err.println("Error opening file. Terminating.");
			System.exit(1); 	//Terminate the program
		}
		catch(IOException inputOutputException)
		{
			System.err.println("Input/Output Exception. Terminating");
			System.exit(1);
		}
		catch(FormatterClosedException formatterClosedException)
		{
			System.err.println("Error writing to file. Terminating");
			System.exit(1);
		}
		catch(NoSuchElementException elementException)
		{
			System.err.println("Invalid input for Ebook...");
			System.exit(1);
		}
				
		//close the file
		if(output != null)
			output.close();
	}
	
	
	//Add MusicCD to the media file
	public static void addMusicCDToFile(MusicCD music1)
	{
		//Try to open the file, and write to it
		try
		{	
			fStream = new FileWriter("media_file_1.txt", true);		//This statement makes a FileWriter for appending
			output = new Formatter(fStream);				//This statement opens the file
							
			/**  THIS NEEDS WORK *****
			//Read the contents of the file with a Scanner, 
			//If the ebook ID already exists in the file,
			//Do NOT add it to the file, but send a message
			//to the user that the Ebook ID already exists
			input = new Scanner(new FileReader("media_file_1.txt"));
			while(input.hasNext())
			{
				if(music1.getId() == 1234)
				{
					System.out.println("The ID you entered already exists");
					return;
				}
								
			}*/
							
							
			//Write (or append) the ebook contents to the file, then add a new line
			output.format("%d %s %d %d%n", music1.getId(), music1.getTitle(), music1.getYear(),
					music1.getLength());
							
			//Flush or write the FileWriter to the file
			fStream.flush();			
		}
		catch(SecurityException securityException)
		{
			System.err.println("Write permission denied. Terminating");
			System.exit(1); 	//Terminate the program
		}
		catch(FileNotFoundException fileNotFoundException)
		{
			System.err.println("Error opening file. Terminating.");
			System.exit(1); 	//Terminate the program
		}
		catch(IOException inputOutputException)
		{
			System.err.println("Input/Output Exception. Terminating");
			System.exit(1);
		}
		catch(FormatterClosedException formatterClosedException)
		{
			System.err.println("Error writing to file. Terminating");
			System.exit(1);
		}
		catch(NoSuchElementException elementException)
		{
			System.err.println("Invalid input for Ebook...");
			System.exit(1);
		}
						
		//close the file
		if(output != null)
			output.close();
	}
	
	
	
	//Find all media objects that relate to a specific title
	//and return the entire list
	public static ArrayList<Media> findMediaObjectsByString(Media media1)
	{
		//Create a new ArrayList that will only contain titles that match the parameter
		ArrayList<Media> titleMatchList = new ArrayList<>();
		
		for(Media mediaObject : titleMatchList1)
		{
			if(media1.getTitle().equals(mediaObject.getTitle()))
			{
				titleMatchList.add(mediaObject);
			}
				
		}
		
		return titleMatchList;
	}
	
	
	//method to find media objects in a file
	public static void findMediaObjectsInFile(String title, Path path)
	{
		//Create a new ArrayList that will only contain titles that match the parameter
		//ArrayList<Media> titleMatchList1 = new ArrayList<>();
		
		/**
		//Create all Media objects for access outside the loop
		MovieDVD movie1 = null;
		MusicCD music1 = null;
		Ebook book1 = null;*/
		
		//Create the Scanner for reading the file
		Scanner data;
		
		//Open the file for reading
		try
		{
			data = new Scanner(path);
			
			while(data.hasNext())
			{
				String data1 = data.nextLine();   
				if(data1.contains("MB"))
				{
					movie1 = new MovieDVD(data1);
					titleMatchList1.add(movie1);
				}
				else if(data1.contains("min"))
				{
					music1 = new MusicCD(data1);
					titleMatchList1.add(music1);
				}
				else
				{
					book1 = new Ebook(data1);
					titleMatchList1.add(book1);
				}
				
			}
			
		}
		catch(FileNotFoundException fileNotFoundException)
		{
			System.err.println("Error opening file. Terminating.");
			System.exit(1); 	//Terminate the program
		}
		catch(IOException inputOutputException)
		{
			System.err.println("Input/Output Exception. Terminating");
			System.exit(1);
		}
		
		//System.out.println(movie1);
		//System.out.println(music1);
		//System.out.println(book1);
		
		for(Media mediaObject : titleMatchList1)
		{
			if(mediaObject.getTitle().equals(title))
			{
				System.out.println(mediaObject);
				return;
			}
			
		}
		
		System.out.println("There is no media with this title: " + title + "\n");
	}
	
	
	
	
	//method to Rent a media object based on its ID
	public static void rentMediaObject(int id)
	{
		for(Media mediaObject : titleMatchList1)
		{
			if(id == mediaObject.getId())
			{
				mediaObject.setIsRented(true);
				System.out.printf("%s%.2f%n", "Media was successfully rented. Rental fee = $",
						mediaObject.calculateRentalFee());
				return;
			}
		}
		
		System.out.println("The media object id=" + id + " is not found\n");
		
		
		/**
		//Create the Scanner for reading the file
		Scanner data;
		
		//Open the file for reading
		try
		{
			data = new Scanner(path);
					
			while(data.hasNext())
			{
				String data1 = data.nextLine();
				
				
			}
			
		}
		catch(FileNotFoundException fileNotFoundException)
		{
			System.err.println("Error opening file. Terminating.");
			System.exit(1); 	//Terminate the program
		}
		catch(IOException inputOutputException)
		{
			System.err.println("Input/Output Exception. Terminating");
			System.exit(1);
		}*/

		
		
	}

	
	
	
	//MAIN METHOD FOR TESTING ****************
	/**
	public static void main(String[] args)
	{
		Ebook book1 = new Ebook(1234, "Ready Player 1", 2000, 15);
		MovieDVD dvd1 = new MovieDVD(123, "Shrek", 2000, 53.0);
		Ebook book2 = new Ebook(5678, "The Power of Now", 2003, 18);
		
		Ebook book3 = new Ebook(1010, "Ready Player 1", 2021, 55);

		mediaList.add(book1);	
		mediaList.add(book3);
		
		
		System.out.println(findMediaObjectsByString(book1));
		
		//MusicCD music1 = new MusicCD(123, "Invincible", 2005, 123);
		//System.out.println(music1);
		
		//System.out.println(mediaList.get(0));
		//System.out.println(mediaList.get(1));
		
		//addEbookToFile(book1);
		//addEbookToFile(book2);
	}*/
}
