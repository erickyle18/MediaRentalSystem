import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame; 
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;

import javax.swing.JOptionPane;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;   
import javax.swing.JTextArea;


public class MediaRentalSystemGUI extends JFrame {
	
	//Declare menu options
	JMenuItem load;
	JMenuItem find;
	JMenuItem rent;
	JMenuItem quit;
	
	//No-argument constructor to set up GUI
	public MediaRentalSystemGUI()
	{
		super("Welcome to Media Rental System");
		
		//create the file menu
		JMenu menu1 = new JMenu("Menu");
		
		
		//create JMenu bar
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(menu1);
		
		//Create JMenus for menu options
		load = new JMenuItem("Load Media objects...");
		find = new JMenuItem("Find Media object...");
		rent = new JMenuItem("Rent Media object...");
		quit = new JMenuItem("Quit");
		
		//Create item handler
		ItemHandler itemHandler = new ItemHandler();
		
		//Add handlers to the buttons
		load.addActionListener(itemHandler);
		find.addActionListener(itemHandler);
		rent.addActionListener(itemHandler);
		quit.addActionListener(itemHandler);
		
		//Add JMenu load to menu
		menu1.add(load);
		menu1.add(find);
		menu1.add(rent);
		menu1.add(quit);
		
	
		
	}
	
	//inner class to handle action events from menu items
	private class ItemHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) 
		{
			if(event.getSource() == load)
			{
				try
				{
					JFileChooser1 app = new JFileChooser1();
					app.setSize(400, 400);
					app.setDefaultCloseOperation(EXIT_ON_CLOSE);
					app.setVisible(true);
				}
				catch(IOException inputOutputException)
				{
					System.out.println("Input output exception...");
					System.exit(1);
				}
				
			}
			
			
			
			else if(event.getSource() == quit)
			{
				JOptionPane.showMessageDialog(null, "Thank you for using the program. Goodbye!");
				System.exit(1);
			}
			
		}
		
	}
	
	
	//inner class for JFileChooser
	private class JFileChooser1 extends JFrame
	{
		private final JTextArea outputArea;
		
		//set up GUI
		public JFileChooser1() throws IOException
		{
			super("Open");
			outputArea = new JTextArea();
			add(new JScrollPane(outputArea));
			//analyzePath();
		}
		
		
		//allow user to specify file or directory name
		private Path getFileOrDirectoryPath()
		{
			JFileChooser fileChooser;
			
			//configure dialog allowing selection of a file or directory
			try
			{
				fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int result = fileChooser.showOpenDialog(this);
				
				if(result == JFileChooser.CANCEL_OPTION)
					System.exit(1);
				
			}
			finally
			{
				
			}
			
			return fileChooser.getSelectedFile().toPath();
			
		}
		
		
	}
	
	
	
	//main method begins program execution
	public static void main(String[] args)
	{
		MediaRentalSystemGUI rentalSystem = new MediaRentalSystemGUI();
		rentalSystem.setDefaultCloseOperation(EXIT_ON_CLOSE);
		rentalSystem.setSize(500, 200);
		rentalSystem.setVisible(true); 
	}

}
