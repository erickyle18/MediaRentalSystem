/**
 * Isaac, Eric
 * 
 * This represents a MusicCd object.
 */

import java.util.Calendar;

public class MusicCD extends Media{
	
	//Local attributes specific to a MusicCD
	private int length;
	
	//Constructor
	public MusicCD(int id, String title, int year, int length)
	{
		//Call superclass constructor to initialize the values passed in
		super(id, title, year);
		
		//initialize the length for the MusicCD with the value passed in
		this.length = length;
	}
	
	//Constructor which takes a line in String format and parses out and assigns the Media attributes
	public MusicCD(String line)
	{
		super(line);
		
		this.setTitle(line.substring(4, line.length()-12));
		this.setYear(Integer.parseInt(line.substring(4 + this.getTitle().length() + 1, line.length()-7)));
		
		length = Integer.parseInt(line.substring(4 + this.getTitle().length() + 1 + 4 + 1, line.length() - 3));
		
	}
	
	
	//Set method
	public void setLength(int length)
	{
		this.length = length;
	}
	
	//Get method
	public int getLength()
	{
		return length;
	}
	
	//Override the superclass method calculateRentalFee()
	@Override
	public double calculateRentalFee()
	{
		double fee = length * 0.02;		//basic fee
		int currYear = Calendar.getInstance().get(Calendar.YEAR);
		
		if(this.getYear() == currYear)
			fee += 1;	//add $1.00 to the fee
		
		return fee;
	}
	
	//Override the toString method to return a String representation of a musicCD
	@Override
	public String toString()
	{
		return "MusicCD [id=" + getId() + ", title=" + getTitle() + ", year=" + getYear() +
				", length=" + getLength() + "min" + ", rented=" + getIsRented() + "]\n";
	}

}
