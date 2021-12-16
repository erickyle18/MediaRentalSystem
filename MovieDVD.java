/**
 * Isaac, Eric
 * 
 * This class represents a movie dvd object.
 */

public class MovieDVD extends Media {

	//Local attribute specific to a DVD
	private double size;	//size in MB
	
	//Constructor
	public MovieDVD(int id, String title, int year, double size)
	{
		//Call the superclass constructor to initialize inherited values
		super(id, title, year);
		
		//Initialize the size with the value passed in
		this.size = size;
	}
	
	//Constructor which takes a line in String format and parses out and assigns the Media attributes
	public MovieDVD(String line)
	{
		super(line);
	
		this.setTitle(line.substring(4, line.length()-13));
		this.setYear(Integer.parseInt(line.substring(4 + this.getTitle().length() + 1, line.length()-8)));
		
		size = Double.parseDouble(line.substring(4 + this.getTitle().length() + 1 + 4 + 1, line.length()-2));
	}
	
	
	//Set method
	public void setSize(double size)
	{
		this.size = size;
	}
	
	//Get method
	public double getSize()
	{
		return size;
	}
	
	
	//MovieDVD's have the same fee as a generic rental, so the calculate rental fee method
	//should not be overidden
	
	//Override the toString() method to return a String representation of a MovieDVD object
	@Override
	public String toString()
	{
		return "MovieDVD [id=" + getId() + ", title=" + getTitle() + ", year=" + getYear() + 
				", size=" + getSize() + "MB" + ", rented=" + getIsRented() + "]\n";
	}
	
}
