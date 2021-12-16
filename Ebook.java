/**
 * Isaac, Eric
 * 
 * Class to represent an Ebook object.
 */

import java.util.Calendar;

public class Ebook extends Media {
	
	//Attribute specific to an Ebook object
	private int numChapters;
	
	//Constructor
	public Ebook(int id, String title, int year, int numChapters)
	{
		//Call the superclass constructor to initialize the inherited attributes
		super(id, title, year);
		
		//Initialize the chapters in the book with the int that is passed in as numChapters
		this.numChapters = numChapters;
	}
	
	//Constructor which takes a line in String format and parses out and assigns the Media attributes
	public Ebook(String line)
	{
		super(line);
		numChapters = Integer.parseInt(line.substring(line.length()-2));
	}
	
	
	//Set method
	public void setNumChapters(int numChapters)
	{
		this.numChapters = numChapters;
	}
	
	//Get method
	public int getNumChapters()
	{
		return numChapters;
	}
	
	//Overidden calculate rental fee method
	@Override
	public double calculateRentalFee()
	{
		double fee = (numChapters * 0.10) + super.calculateRentalFee();	//basic fee, every chapters cost 10 cents
		
		int currYear = Calendar.getInstance().get(Calendar.YEAR);
		
		if(this.getYear() == currYear)
			fee += 1;
		
		return fee;
	}
	
	//Overidden to String method
	@Override
	public String toString()
	{
		return "EBook [id="+ getId() + ", title=" + getTitle() + ", year=" + getYear() +
				", chapters=" + getNumChapters() + ", rented=" + getIsRented() + "]\n";
	}
	
}
