import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.DirectoryStream;

public class MediaRentalSystem {
	
	//Create the Scanner object
	static Scanner input1 = new Scanner(System.in);
	
	//Create the path object to load files from
	static Path path;
	
	//Create a Manager object
	static Manager manager1 = new Manager();
	
	//main method begins program execution
	public static void main(String[] args)
	{
		//int to hold the selection
		int selection;
		
		//Display the menu, and while the user does not select
		//The option to quit, keep displaying the menu
		do {
			displayMediaMenu();
			
			selection = input1.nextInt();
			System.out.println();
			input1.nextLine();
			
			//Send the selection to method "chooseSelection" to process the user's selection
			chooseSelection(selection);
			
		}while(selection != 9);
		
	}
	
	//method to display the menu
	public static void displayMediaMenu()
	{
		System.out.println("Welcome to Media Rental System");
		System.out.println("1: Load Media objects...");
		System.out.println("2: Find Media object...");
		System.out.println("3: Rent Media object...");
		System.out.println("9: Quit\n");
		System.out.print("Enter your selection: ");
	}
	
	//method to process the user's selection
	public static void chooseSelection(int userChoice)
	{
		switch(userChoice)
		{
			case 1:
				System.out.print("Enter path (directory) where to load from: ");
				String pathToLoad = input1.nextLine();
				System.out.println();
				path = Paths.get(pathToLoad); 
				if(Files.exists(path))
				{
					//System.out.println("Loading from..." + path);
					return;
				}
				else
				{
					System.out.println("File cannot be opened: Could not load, no such directory\n");
				}
				break;
			case 2:
				System.out.printf("%n%s", "Enter the title: ");
				String mediaTitle = input1.nextLine();
				manager1.findMediaObjectsInFile(mediaTitle, path);
				break;
			case 3:
				System.out.printf("%n%s", "Enter the id: ");
				String mediaID = input1.nextLine();
				int mediaIDInt = Integer.parseInt(mediaID);
				manager1.rentMediaObject(mediaIDInt);
				System.out.println();
				break;
			case 9:
				System.out.println("\nThank you for using the program. Goodbye!");
				System.exit(1);
		}
		
	}
	
}
