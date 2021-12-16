/**
 * Isaac, Eric
 * 
 * This class represents a generic media object.
 */

public abstract class Media {
	
	//Attributes for this class
	private int id;
	private String title;
	private int year;		//validate that the year is 4 digits
	
	//Attribute to determine if a media object is rented or available
	//All Media objects are available until they are rented by a customer
	private boolean isRented = false;
	
	//Constructor
	public Media(int id, String title, int year)
	{
		//We need a way to validate the year before initializing it with the value passed in
		
		this.id = id;
		this.title = title;
		this.year = year;	
	}
	
	//Constructor which takes a line in String format and parses out and assigns the Media attributes
	public Media(String line)
	{
		id = Integer.parseInt(line.substring(0, 3));
		
		if(line.length() == 26 && !(line.contains("min")))
			title = line.substring(4, line.length()-8);
		else if(line.length() == 30)
			title = line.substring(4, line.length()-13);
		else if(line.length() == 26 && line.contains("min"))
			title = line.substring(4, line.length()-12);
		
		if(line.length() == 26 && !(line.contains("min")))
			year = Integer.parseInt(line.substring(4 + title.length() + 1, line.length()-3));
		else if(line.length() == 30)
			year = Integer.parseInt(line.substring(4 + title.length() + 1, line.length()-8));
		else if(line.length() == 26 && line.contains("min"))
			year = Integer.parseInt(line.substring(4 + title.length() + 1, line.length()-7));
			
	}
	
	//Set methods
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public void setYear(int year)
	{
		//We need a way to validate the year before initializing it with the value passed in
		
		this.year = year;
	}
	
	public void setIsRented(boolean isRented)
	{
		this.isRented = isRented;
	}
	
	//Get methods
	public int getId()
	{
		return id;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public int getYear()
	{
		return year;
	}
	
	//method to calculate the rental fee, for a generic media, the rental fee is $3.50
	public double calculateRentalFee()
	{
		return 3.50;
	}
	
	public boolean getIsRented()
	{
		return isRented;
	}
}
